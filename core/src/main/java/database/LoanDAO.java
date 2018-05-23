package database;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.Borrower;
import Entities.Loan;
import Entities.Tool;

public class LoanDAO {
	
	public void Add(Loan loan) throws FilloException {
		String query = "INSERT INTO Loans(Number, Tool, Borrower, Date, Expiration) VALUES ('"+ loan.getLoanNumber() + "',"
																							+ "'"+ loan.get_tool().getId() +"',"
																									+ "'"+ loan.get_borrower().getName() +"',"
																											+ "'"+ loan.get_creationDate() +"',"
																													+ "'"+ loan.get_expirationDate() +"')";
		ExcelDB db = new ExcelDB();
		db.Write(query);
	}
	
	public List<Loan> GetAll() throws FilloException {
		String query = "SELECT * FROM Loans";
		ExcelDB db = new ExcelDB();
		return parseLoans(db.Read(query));
	}
	
	public Loan GetOne(String number) throws FilloException {
		String query = "SELECT * FROM Loans WHERE Number='" + number + "'";
		ExcelDB db = new ExcelDB();
		return parseLoan(db.Read(query));
	}

	
	//TODO -> Ver esto, ya que hay que ver si se labura con ID o con nombre las herramientas y los trabajadores. Necesario saber hacer los GetOne
	public List<Loan> parseLoans(Recordset rs) throws FilloException{
		try {
		List<Loan> loans = new ArrayList<Loan>();
		BorrowerDAO bDao = new BorrowerDAO();
		ToolDAO tDao = new ToolDAO();
		while (rs.next()) {
			Tool tool = tDao.GetOne(rs.getField("Tool"));
			Borrower borrower = bDao.GetOne(rs.getField("Borrower"));
			Loan loan = new Loan(Integer.parseInt(rs.getField("Number")), tool, borrower);
			DateFormat df = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
			loan.set_creationDate(df.parse(rs.getField("Date")));
			loan.set_expirationDate(df.parse(rs.getField("Expiration")));
			loans.add(loan);
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
			while(rs.next()) {
				BorrowerDAO bDao = new BorrowerDAO();
				ToolDAO tDao = new ToolDAO();
				Tool tool = tDao.GetOne(rs.getField("Tool"));
				Borrower borrower = bDao.GetOne(rs.getField("Borrower"));
				loan = new Loan(Integer.parseInt(rs.getField("Number")), tool, borrower);
				DateFormat df = new SimpleDateFormat("EE MMM dd HH:mm:ss z yyyy", Locale.ENGLISH);
				loan.set_creationDate(df.parse(rs.getField("Date")));
				loan.set_expirationDate(df.parse(rs.getField("Expiration")));	
			}
			rs.close();
			return loan;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
