package view;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.DefaultListModel;

import Entities.Alarm;
import Entities.Loan;
import Entities.Retreat;

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
		if (arg.getClass() == Loan.class) {
			Loan eLoan = (Loan) arg;
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement(eLoan);
			this.table.getListLoan().setModel(listModel);	
		}
		else if (arg.getClass() == Retreat.class) {
			Retreat eRetreat = (Retreat) arg;
			DefaultListModel listModel = new DefaultListModel();
			listModel.addElement(eRetreat);
			this.table.getListRetreat().setModel(listModel);
		}
		else {
			ArrayList<Alarm> eAlarmsList = (ArrayList<Alarm>) arg;
			DefaultListModel listModel = new DefaultListModel();
			for (Alarm alarm: eAlarmsList) {
				listModel.addElement(alarm);				
			}
			this.table.getAlarmsList().setModel(listModel);
		}
	}
	
}
