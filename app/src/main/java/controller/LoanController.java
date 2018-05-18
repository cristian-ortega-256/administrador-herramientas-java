package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;

import Entities.Tool;
import Entities.Borrower;
import model.LoanFormViewModel;
import model.LoanSystem;
import view.View;
import view.AdapterUI;

public class LoanController implements ActionListener{
	
	private View view;
	private AdapterUI adapterUI;
	private LoanSystem loanSystem;
	private LoanFormViewModel vm;
	
	public LoanController(View view, LoanFormViewModel vm, LoanSystem loanSystem, AdapterUI adapterUI) {
		this.view = view;
		this.adapterUI = adapterUI;
		this.loanSystem = loanSystem;
		
		this.vm = vm;
		
		this.view.getBtnCreateLoan().addActionListener(this);
	}
	
	public void initialize() {
		this.view.getCbWorkers()
			.setModel(new DefaultComboBoxModel(this.vm.getAllBorrowers().toArray()));
		this.view.getCbTools()
			.setModel(new DefaultComboBoxModel(this.vm.getAllTools().toArray()));
		this.view.show();
		this.adapterUI.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.view.getBtnCreateLoan()) {
			Tool loanTool = (Tool)this.view.getCbTools().getSelectedItem();
			Borrower loanWorker =  (Borrower)this.view.getCbWorkers().getSelectedItem();
			this.loanSystem.checkLoanGeneration(loanTool, loanWorker);
		}
	}
	
	public AdapterUI getAdapterUI() {
		return adapterUI;
	}

}
