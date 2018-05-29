package database;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.ToolType;

public class ToolTypeDAO {

	public ToolType GetOne(String IdToolType) throws FilloException { 
		String query = "SELECT * FROM TipoHerramienta WHERE ID=" + IdToolType + "";
		ExcelDB db = new ExcelDB();
		return parseToolType(db.Read(query));
	}
	
	public ToolType parseToolType(Recordset rs) throws FilloException {
		try {
			ToolType tt = null;
			while(rs != null && rs.next()) {
				String name = rs.getField("Nombre");
				tt = new ToolType(name);
			}
			rs.close();
			return tt;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
}
