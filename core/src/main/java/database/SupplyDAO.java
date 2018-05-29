package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import Entities.Supply;

public class SupplyDAO {

	public List<Supply> GetAll() throws FilloException {
		String query = "SELECT * FROM Supplies";
		ExcelDB db = new ExcelDB();
		return parseSupplies(db.Read(query));
	}
	
	public Supply GetOne(String id) throws FilloException {
		String query = "SELECT * FROM Supplies WHERE ID='" + id + "'";
		ExcelDB db = new ExcelDB();
		return parseSupply(db.Read(query));
	}
	
	public Supply parseSupply(Recordset rs) throws FilloException {
		Supply supply = null;
		while(rs != null && rs.next()) {
			supply = this.generateSupply(rs);
		}
		rs.close();
		return supply;
	}

	public List<Supply> parseSupplies(Recordset rs) throws FilloException{
		List<Supply> supplies = new ArrayList<Supply>();
		while (rs != null && rs.next()) {
			Supply supply = this.generateSupply(rs);
			supplies.add(supply);
		}
		rs.close();
		return supplies;
	}
	
	private Supply generateSupply(Recordset rs) throws FilloException {
		HashMap<String,String> dataSet = this.generateDataHash(rs);
		int stock = Integer.parseInt(dataSet.get("Stock"));
		int minimumStock = Integer.parseInt(dataSet.get("MinimumStock"));
		return new Supply(dataSet.get("Nombre"), stock, minimumStock);
	}
	
	private HashMap<String,String> generateDataHash(Recordset rs) throws FilloException {
		HashMap<String,String> data = new HashMap<String,String>();
		for(String column:rs.getFieldNames()) {
			data.put(column,rs.getField(column));
		}
		return data;
	}
	
}
