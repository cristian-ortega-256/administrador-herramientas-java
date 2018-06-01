package database;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;

public class LoanDAO {
	
	public void Add(Loan loan) throws FilloException {
		String query = "INSERT INTO Loans(Numero, Herramienta, Trabajador, Fecha, Expiracion) VALUES ('"+ loan.getLoanNumber() + "',"
																							+ "'"+ loan.get_tool().getId() +"',"
																									+ "'"+ loan.get_borrower().getName() +"',"
																											+ "'"+ loan.get_creationDate() +"')";
		ExcelDB db = new ExcelDB();
		db.Write(query);
	}
	
	public void delete(int id) throws FilloException {
		String query = "DELETE FROM Loans WHERE Numero=" + id;
		ExcelDB db = new ExcelDB();
		db.Write(query);
	}
	
	public List<Loan> GetAll() throws FilloException {
		String query = "SELECT * FROM Loans";
		ExcelDB db = new ExcelDB();
		return parseLoans(db.Read(query));
	}
	
	public Loan GetOne(String number) throws FilloException {
		String query = "SELECT * FROM Loans WHERE Numero='" + number + "'";
		ExcelDB db = new ExcelDB();
		return parseLoan(db.Read(query));
	}
	
	public int GetLastFreeLoanNumber() throws FilloException{
		try {
			List<Loan> loans = this.GetAll();
			if (loans.isEmpty())
				return 0;
			else {
				loans.sort(new Comparator<Loan>() {
					public int compare(Loan l1, Loan l2) {
						return l1.getLoanNumber() - l2.getLoanNumber();
					}
				});
				int index = loans.size() - 1;
				return loans.get(index).getLoanNumber() + 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		
	}

	
	//TODO -> Ver esto, ya que hay que ver si se labura con ID o con nombre las herramientas y los trabajadores. Necesario saber hacer los GetOne
	public List<Loan> parseLoans(Recordset rs) throws FilloException{
		try {
		List<Loan> loans = new ArrayList<Loan>();
		while(rs != null & rs.next()) {
			HashMap<String,String> dataSet = this.generateDataHash(rs);
			if(this.isValidSet(dataSet))
				loans.add(this.generateLoan(dataSet));
		}
		rs.close();
		return loans;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Loan parseLoan(Recordset rs) throws FilloException {
		try {
			Loan loan = null;
			while(rs != null & rs.next()) {
				HashMap<String,String> dataSet = this.generateDataHash(rs);
				if(this.isValidSet(dataSet))
					loan = this.generateLoan(dataSet);
			}
			rs.close();
			return loan;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private Loan generateLoan(HashMap<String, String> dataSet) throws FilloException, ParseException {
		BorrowerDAO bDao = new BorrowerDAO();
		ToolDAO tDao = new ToolDAO();
		Tool tool = tDao.GetOne(dataSet.get("Herramienta"));
		Borrower borrower = bDao.GetOne(dataSet.get("Trabajador"));
		Loan loan = new Loan(Integer.parseInt(dataSet.get("Numero")), tool, borrower);
		DateFormat df = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
		loan.set_creationDate(df.parse(dataSet.get("Fecha")));
		return loan;
	}

	private boolean isValidSet(HashMap<String, String> dataSet) {
		Iterator it = dataSet.entrySet().iterator();
		while(it.hasNext()) {
			if(it.next().equals(""))
				return false;
		}
		return true;
	}

	private HashMap<String,String> generateDataHash(Recordset rs) throws FilloException {
		HashMap<String,String> data = new HashMap<String,String>();
		for(String column:rs.getFieldNames()) {
			data.put(column,rs.getField(column));
		}
		return data;
	}

}
