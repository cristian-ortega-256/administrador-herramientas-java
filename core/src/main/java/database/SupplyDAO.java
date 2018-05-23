package database;

import java.util.ArrayList;
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
	
	public Supply parseSupply(Recordset rs) throws FilloException {
		Supply supply = null;
		while(rs.next()) {
			String name = rs.getField("Name");
			int stock = Integer.parseInt(rs.getField("Stock"));
			int minimumStock = Integer.parseInt(rs.getField("MinimumStock"));
			supply = new Supply(name, stock, minimumStock);	
		}
		rs.close();
		return supply;
	}
	
	public List<Supply> parseSupplies(Recordset rs) throws FilloException{
		List<Supply> supplies = new ArrayList<Supply>();
		while (rs.next()) {
			String name = rs.getField("Name");
			int stock = Integer.parseInt(rs.getField("Stock"));
			int minimumStock = Integer.parseInt(rs.getField("MinimumStock"));
			Supply supply = new Supply(name, stock, minimumStock);
			supplies.add(supply);
		}
		rs.close();
		return supplies;
	}
	
}
