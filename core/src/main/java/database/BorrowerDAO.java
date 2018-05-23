package database;

import java.util.ArrayList;
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
		String query = "SELECT * FROM Borrowers WHERE Name='" + name + "'";
		ExcelDB db = new ExcelDB();
		return parseBorrower(db.Read(query));
	}
	
	public List<Borrower> parseBorrowers(Recordset rs) throws FilloException {
		List<Borrower> borrowers = new ArrayList<Borrower>();
		while (rs.next()) {
			String name = rs.getField("Name");
			Borrower borrower = new Borrower(name);
			borrowers.add(borrower);
		}
		rs.close();
		return borrowers;
	}
	
	public Borrower parseBorrower(Recordset rs) throws FilloException{
		Borrower borrower = null;
		while(rs.next()) {
			String name = rs.getField("Name");
			borrower = new Borrower(name);	
		}
		return borrower;
	}
	
}
