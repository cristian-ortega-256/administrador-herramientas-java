package model;

import java.util.ArrayList;
import java.util.Observable;

public class Model extends Observable{
	
	private ArrayList<String> data;
	
	public Model() {
		super();
		this.data = new ArrayList<String>();
	}
	
	public void addValue(String value) {
		this.data.add(value);
		setChanged();
        notifyObservers(this.data);
	}

	public ArrayList<String> getData() {
		return this.data;
	}

}
