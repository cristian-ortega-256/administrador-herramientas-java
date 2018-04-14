package Entities;

public class Borrower {
	
	//private int id;
	private String name;

	public Borrower(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

//	public void setName(String name) {
//		this.name = name;
//	}

	@Override
	public String toString() {
		return name;
	}
	
}
