package model;

import java.util.ArrayList;
import java.util.List;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import Entities.Tool;
import Entities.ToolType;
import database.ExcelDB;
import database.ToolDAO;

public class ToolSystem {
	
	private List<Tool> allTools;
	
	public ToolSystem() {
		this.allTools = new ArrayList<Tool>();
	}
	
	public void setTools(List<Tool> list) {
		this.allTools = list;
	}
	
	public List<Tool> getAllTools() {
		return allTools;
	}
	
}
