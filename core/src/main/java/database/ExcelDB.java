package database;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class ExcelDB {
	
	private Connection con;
	private Recordset rs;

	public ExcelDB() throws FilloException{
		Fillo fillo = new Fillo();
		this.con = fillo.getConnection("excel/Test.xlsx");
	}
	
	public Recordset Read(String query) {
		try {
			this.rs = this.con.executeQuery(query);
			return rs;
		}catch (Exception e) {
			this.rs = null;
			return rs;
		}
		finally {
			//this.rs.close();
			this.con.close();
		}		
	}
	
	public void Write(String query) {
		try {
			this.con.executeUpdate(query);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		} 
		finally {
			this.con.close();
		}
	}
}
