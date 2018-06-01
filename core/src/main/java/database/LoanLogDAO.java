package database;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.Borrower;
import Entities.Loan;
import Entities.LoanLogRow;
import Entities.Tool;
import Entities.ToolType;

public class LoanLogDAO {
	public void Add(Loan loan, String action) throws FilloException {
		String query = "INSERT INTO PrestamosLog(Numero, Elemento, Trabajador, Accion, Fecha) VALUES ('"+ loan.getLoanNumber() + "',"
																							+ "'"+ loan.get_tool().getName() +"',"
																							+ "'"+ loan.get_borrower().getName() +"',"
																							+ "'"+ action +"'," + "'"+ new Date() +"')";
		ExcelDB db = new ExcelDB();
		db.Write(query);
	}
	/*
	public void delete(int id) throws FilloException {
		String query = "DELETE FROM PrestamosLog WHERE Numero=" + id;
		ExcelDB db = new ExcelDB();
		db.Write(query);
	}
	*/
	
	public List<Loan> getAllLogRows() throws FilloException{
		String query = "SELECT * FROM PrestamosLog";
		ExcelDB db = new ExcelDB();
		return parseRows(db.Read(query));
	}
	
	public List<String> getOneActions(int id) throws FilloException {
		String query = "SELECT * FROM PrestamosLog WHERE Numero=" + id;
		ExcelDB db = new ExcelDB();
		return parseActionRows(db.Read(query));
	}

	private List<String> parseActionRows(Recordset rs) throws FilloException {
		List<String> rows = new ArrayList<String>();
		while(rs != null & rs.next()) {
			HashMap<String,String> dataSet = this.generateDataHash(rs);
			if(this.isValidSet(dataSet)) {
				rows.add(dataSet.get("Accion"));
			}
		}
		return rows;
	}

	private List<Loan> parseRows(Recordset rs) throws FilloException {
		ArrayList<Loan> rows = new ArrayList<Loan>();
		while(rs != null & rs.next()) {
			HashMap<String,String> dataSet = this.generateDataHash(rs);
			if(this.isValidSet(dataSet)) {
				rows.add(this.generateLoan(dataSet));
			}
		}
		return rows;
	}

	private Loan generateLoan(HashMap<String, String> dataSet) {
		Tool t = new Tool(0,dataSet.get("Elemento"),new ToolType(""));
		Borrower b = new Borrower(dataSet.get("Trabajador"));
		int id = Integer.parseInt(dataSet.get("Numero"));
		return new Loan(id,t,b); 
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
