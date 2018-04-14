package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;

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
		Loan eLoan = (Loan) arg;
		DefaultListModel listModel = new DefaultListModel();
		listModel.addElement(eLoan);
		this.table.getListLoan().setModel(listModel);
	}
	
}
