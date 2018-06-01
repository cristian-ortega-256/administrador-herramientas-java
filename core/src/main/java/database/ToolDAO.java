package database;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.collections4.map.HashedMap;

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
		while(rs != null && rs.next()) {
			HashMap<String,String> dataSet = this.generateDataHash(rs);
			if(this.isValidSet(dataSet))
				tool = this.generateTool(dataSet);
		}
		rs.close();
		return tool;
	}
	
	public List<Tool> parseTools(Recordset rs) throws FilloException{
		List<Tool> tools = new ArrayList<Tool>();
		while (rs != null && rs.next()) {
			Tool t = null;
			HashMap<String,String> dataSet = this.generateDataHash(rs);
			if(this.isValidSet(dataSet))
				t = this.generateTool(dataSet);
			if(t != null)
				tools.add(t);
		}
		rs.close();
		return tools;
	}
	
	private Tool generateTool(HashMap<String, String> dataSet) {
		try {
			String name = dataSet.get("Nombre");
			ToolTypeDAO ttDao = new ToolTypeDAO();
			ToolType tt = ttDao.GetOne(dataSet.get("Tipo de herramienta"));
			Tool tool = new Tool(name, tt);
			if(!this.isParsable(dataSet.get("ID")))
				return null;
			tool.setId(Integer.parseInt(dataSet.get("ID")));
			return tool;
		}
		catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public boolean isParsable(String input){
	    boolean parsable = true;
	    try{
	        Integer.parseInt(input);
	    }catch(NumberFormatException e){
	        parsable = false;
	    }
	    return parsable;
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
