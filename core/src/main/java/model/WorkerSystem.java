package model;

import java.util.ArrayList;

import Entities.Worker;

public class WorkerSystem {
	private ArrayList<Worker> workers;
	
	public WorkerSystem() {
		this.workers = new ArrayList<Worker>();
		this.populateWorkers();
	}
	
	private void populateWorkers() {
		this.workers.add(new Worker("Goku"));
		this.workers.add(new Worker("Vegeta"));
		this.workers.add(new Worker("Gohan"));
		this.workers.add(new Worker("Trunks"));
	}

	public ArrayList<Worker> getWorkers() {
		return workers;
	}

	public void setWorkers(ArrayList<Worker> workers) {
		this.workers = workers;
	}
	
}
