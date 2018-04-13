package model;

import java.util.ArrayList;

import Entities.Tool;
import Entities.ToolType;

public class ToolSystem {
	private ArrayList<Tool> tools;
	
	public ToolSystem() {
		this.tools = new ArrayList<Tool>();
		this.populateInternalTools();
	}
	
	private void populateInternalTools() {
		this.tools.add(new Tool("Taladro - 01",ToolType.Taladro));
		this.tools.add(new Tool("Taladro - 02",ToolType.Taladro));
		this.tools.add(new Tool("Taladro - 03",ToolType.Taladro));
		this.tools.add(new Tool("Destornillador - 01",ToolType.Destornillador));
		this.tools.add(new Tool("Destornillador - 02",ToolType.Destornillador));
		this.tools.add(new Tool("Destornillador - 03",ToolType.Destornillador));
		this.tools.add(new Tool("Martillo - 01",ToolType.Martillo));
		this.tools.add(new Tool("Martillo - 02",ToolType.Martillo));
		this.tools.add(new Tool("Martillo - 03",ToolType.Martillo));
	}

	public ArrayList<Tool> getTools() {
		return tools;
	}

	public void setTools(ArrayList<Tool> tools) {
		this.tools = tools;
	}
	
}
