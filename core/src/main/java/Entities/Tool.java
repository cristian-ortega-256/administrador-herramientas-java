package Entities;

import Entities.ToolType;

public class Tool {
	
	private int id;
	private String name;
	private ToolType type;
	
	public Tool(int id, String name, ToolType toolType) {
		this.id = id;
		this.name = name;
		this.type = toolType;
	}
	
	public Tool(String name, ToolType toolType) {
		this.name = name;
		this.type = toolType;
	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public ToolType getType() {
//		return type;
//	}
//
//	public void setType(ToolType type) {
//		this.type = type;
//	}
	
	public int getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return name;
	}
	
	public boolean equals(Tool t) {
		return this.id == t.id ? true : false;
	}
	
}
