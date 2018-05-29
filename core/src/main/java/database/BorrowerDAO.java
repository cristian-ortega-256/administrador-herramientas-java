package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.Borrower;

public class BorrowerDAO {

	public List<Borrower> GetAll() throws FilloException {
		String query = "SELECT * FROM Borrowers";
		ExcelDB db = new ExcelDB();
		return parseBorrowers(db.Read(query));	
	}
	
	public Borrower GetOne(String name) throws FilloException {
		String query = "SELECT * FROM Borrowers WHERE Nombre='" + name + "'";
		ExcelDB db = new ExcelDB();
		return parseBorrower(db.Read(query));
	}
	
	public Borrower parseBorrower(Recordset rs) throws FilloException{
		Borrower borrower = null;
		while(rs != null && rs.next()) {
			borrower = this.createBorrower(rs);	
		}
		return borrower;
	}
	
	public List<Borrower> parseBorrowers(Recordset rs) throws FilloException {
		List<Borrower> borrowers = new ArrayList<Borrower>();
		while (rs != null && rs.next()) {
			Borrower borrower = this.createBorrower(rs) ;
			borrowers.add(borrower);
		}
		rs.close();
		return borrowers;
	}
	
	private Borrower createBorrower(Recordset rs) throws FilloException {
		HashMap<String,String> dataSet = this.generateDataHash(rs);
		return new Borrower(dataSet.get("Nombre"));
	}
	
	private HashMap<String,String> generateDataHash(Recordset rs) throws FilloException {
		HashMap<String,String> data = new HashMap<String,String>();
		for(String column:rs.getFieldNames()) {
			data.put(column,rs.getField(column));
		}
		return data;
	}
	
}
