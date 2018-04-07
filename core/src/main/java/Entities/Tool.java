package Entities;

import Entities.ToolType;

public class Tool {
	
	//private int id;
	private String name;
	private ToolType type;
	private boolean state; // Maybe this is not necessary, talk about this
	
	public Tool(String name, ToolType toolType, boolean state) {
		this.name = name;
		this.type = toolType;
		this.state = state;
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

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}
	
}
