package Entities;

import Entities.ToolType;

public class Tool {
	
	private String name;
	private ToolType type;
	
	public Tool(String name, ToolType toolType) {
		this.name = name;
		this.type = toolType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ToolType getType() {
		return type;
	}

	public void setType(ToolType type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
}
