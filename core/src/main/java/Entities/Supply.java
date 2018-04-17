package Entities;

public class Supply {
	
	private String name;
	private int stock;
	private int minimumStock; 

	public Supply(String name, int stock,int minimumStock) {
		this.name = name ;
		this.stock = stock; 
		this.minimumStock = minimumStock;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getMinimumStock() {
		return minimumStock;
	}

	public void setMinimumStock(int minimumStock) {
		this.minimumStock = minimumStock;
	}

	@Override
	public boolean equals(Object obj) {
		Supply other = (Supply) obj;
		if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	
	
	
	
}
