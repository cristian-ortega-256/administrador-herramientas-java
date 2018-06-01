package database;

import java.util.ArrayList;

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
	
	public ExcelDB(String path) throws FilloException{
		Fillo fillo = new Fillo();
		this.con = fillo.getConnection(path);
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
	
	public ArrayList<String> getExcelSheetNames() {
		return this.con.getMetaData().getTableNames();
	}
	
	public ArrayList<String> getSheetColumns(String tableName) throws FilloException {
		Recordset rs = this.Read("SELECT * FROM " + tableName);
		ArrayList<String> columns = rs.getFieldNames(); 
		rs.close();
		return columns;
	}
	
	// TODO --> Corroborar el nombre de las hojas de excel
	// TODO --> Corroborar que por cada hoja esten las columnas pertinentes
}
