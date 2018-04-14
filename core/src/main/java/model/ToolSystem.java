package model;

import java.util.ArrayList;
import java.util.List;

import Entities.Tool;
import Entities.ToolType;

public class ToolSystem {
	
	private List<Tool> allTools;
	
	public ToolSystem() {
		this.allTools = new ArrayList<Tool>();
		this.populateInternalTools();
	}
	// TODO --> Move this outside of the class
	private void populateInternalTools() {
		this.allTools.add(new Tool("Taladro - 01",ToolType.Taladro));
		this.allTools.add(new Tool("Taladro - 02",ToolType.Taladro));
		this.allTools.add(new Tool("Taladro - 03",ToolType.Taladro));
		this.allTools.add(new Tool("Destornillador - 01",ToolType.Destornillador));
		this.allTools.add(new Tool("Destornillador - 02",ToolType.Destornillador));
		this.allTools.add(new Tool("Destornillador - 03",ToolType.Destornillador));
		this.allTools.add(new Tool("Martillo - 01",ToolType.Martillo));
		this.allTools.add(new Tool("Martillo - 02",ToolType.Martillo));
		this.allTools.add(new Tool("Martillo - 03",ToolType.Martillo));
	}
	
	public List<Tool> getAllTools() {
		return allTools;
	}
	
}
