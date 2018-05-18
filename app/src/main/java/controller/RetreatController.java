package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import Entities.Borrower;
import Entities.Supply;
import model.RetreatFormViewModel;
import model.RetreatSystem;
import view.RetreatView;

public class RetreatController implements ActionListener {

	private RetreatView retreatView;
	private RetreatSystem retreatSystem;
	private RetreatFormViewModel rvm;
	
	public RetreatController(RetreatView retreatView, RetreatFormViewModel rvm, RetreatSystem retreatSystem) {
		this.retreatView = retreatView;
		this.rvm = rvm;
		this.retreatSystem = retreatSystem;
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
