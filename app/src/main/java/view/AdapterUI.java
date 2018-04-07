package view;

import java.util.Observable;
import java.util.Observer;

import Entities.Loan;

public class AdapterUI implements Observer{
	
	private TableView table;
	
	public AdapterUI() {
		this.table = new TableView();
	}
	
	public void show() {
		this.table.show();
	}

	@Override
	public void update(Observable o, Object arg) {
		Loan loan = (Loan) arg;
		this.table.getTextField().setText(loan.get_worker().getName());
	}
	
}
