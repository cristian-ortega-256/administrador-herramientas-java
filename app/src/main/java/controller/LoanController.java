package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Entities.Tool;
import Entities.ToolType;
import Entities.Alarm;
import Entities.Borrower;
import model.LoanFormViewModel;
import model.LoanObserver;
import model.LoanSystem;
import model.ToolSystem;
import model.AlarmSystem;
import model.BorrowerSystem;
import view.View;
import view.AdapterUI;

public class LoanController implements ActionListener{
	
	private View view;
	private AdapterUI adapterUI;
	public AdapterUI getAdapterUI() {
		return adapterUI;
	}

	private LoanObserver loanObserver;
	private AlarmSystem alarmSystem;
	private LoanSystem loanSystem;
	private LoanFormViewModel vm;
	
	public LoanController(View view, LoanFormViewModel vm) {
		this.view = view;
		this.adapterUI = new AdapterUI();
		this.alarmSystem =  new AlarmSystem(new ArrayList<Alarm>(), new ArrayList<Alarm>());
		this.loanObserver = new LoanObserver(this.alarmSystem);
		
		this.vm = vm;
		
		this.loanSystem = new LoanSystem(this.vm.getAllTools());
		this.loanSystem.addObserver(this.adapterUI);
		this.loanSystem.addObserver(this.loanObserver);
		
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

}
