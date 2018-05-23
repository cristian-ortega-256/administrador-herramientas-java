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
	
	public Tool GetOne(String id) throws FilloException {
		String query = "SELECT * FROM Tools WHERE ID='" + id + "'";
		ExcelDB db = new ExcelDB();
		return parseTool(db.Read(query));
	}
	
	public Tool parseTool(Recordset rs) throws FilloException {
		Tool tool = null;
		while(rs.next()) {
			String name = rs.getField("Name");
			ToolTypeDAO ttDao = new ToolTypeDAO();
			ToolType tt = ttDao.GetOne(rs.getField("IdToolType"));
			tool = new Tool(name, tt);	
		}
		rs.close();
		return tool;
	}
	
	public List<Tool> parseTools(Recordset rs) throws FilloException{
		List<Tool> tools = new ArrayList<Tool>();
		while (rs.next()) {
			String name = rs.getField("Name");
			ToolTypeDAO ttDao = new ToolTypeDAO();
			ToolType tt = ttDao.GetOne(rs.getField("IdToolType"));
			Tool tool = new Tool(name, tt);
			tool.setId(Integer.parseInt(rs.getField("ID")));
			tools.add(tool); 
		}
		rs.close();
		return tools;
	}
	
}
