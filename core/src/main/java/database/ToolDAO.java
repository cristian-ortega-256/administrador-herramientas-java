package database;

import java.util.ArrayList;
import java.util.List;
import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import Entities.Tool;
import Entities.ToolType;

public class ToolDAO {

	
	public List<Tool> GetAll() throws FilloException {
		String query = "SELECT * FROM Tools";
		ExcelDB db = new ExcelDB();
		return parseTools(db.Read(query));
	}
	
	public Tool parseTool(Recordset rs) throws FilloException {
		String name = rs.getField("Name");
		Tool tool = new Tool(name, ToolType.Martillo);
		rs.close();
		return tool;
	}
	
	public List<Tool> parseTools(Recordset rs) throws FilloException{
		List<Tool> tools = new ArrayList<Tool>();
		while (rs.next()) {
			String name = rs.getField("Name");
			Tool tool = new Tool(name, ToolType.Martillo);
			tools.add(tool);
		}
		rs.close();
		return tools;
	}
}
