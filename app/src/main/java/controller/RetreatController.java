package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import Entities.Borrower;
import Entities.Supply;
import model.AlarmSystem;
import model.RetreatFormViewModel;
import model.RetreatSystem;
import model.SupplyObserver;
import model.SupplySystem;
import view.AdapterUI;
import view.RetreatView;

public class RetreatController implements ActionListener {

	private RetreatView retreatView;
	private AdapterUI retreatAdapterUI;
	private RetreatSystem retreatSystem;
	private RetreatFormViewModel rvm;
	private SupplySystem supplySystem;
	
	public RetreatController(RetreatView retreatView, RetreatFormViewModel rvm, AdapterUI retreatAdapterUI, AlarmSystem alarmSystem) {
		this.retreatView = retreatView;
		this.rvm = rvm;
		this.retreatAdapterUI = retreatAdapterUI;
		this.supplySystem = new SupplySystem();
		
		this.supplySystem.addObserver(new SupplyObserver(alarmSystem));
		
		this.retreatSystem = new RetreatSystem(this.supplySystem);
		this.retreatSystem.addObserver(this.retreatAdapterUI);
		
		this.retreatView.getBtnCreate().addActionListener(this);
	}
	
	public void initialize() {
		this.retreatView.getCbBorrow().setModel(new DefaultComboBoxModel(this.rvm.getAllBorrowers().toArray()));
		this.retreatView.getCbSupplies().setModel(new DefaultComboBoxModel(this.rvm.getAllSupplies().toArray()));
		this.retreatView.show();
		//this.retreatAdapterUI.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.retreatView.getBtnCreate()) {
			Supply retreatSupply = (Supply)this.retreatView.getCbSupplies().getSelectedItem();
			Borrower retreatBorrower =  (Borrower)this.retreatView.getCbBorrow().getSelectedItem();
			int retreatQuantity =  Integer.parseInt(this.retreatView.getTxtQuantity().getText());
			this.retreatSystem.checkRetreatGeneration(retreatSupply, retreatBorrower, retreatQuantity);
		}
		
	}
}
