package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

import Entities.Tool;
import Entities.ToolType;
import Entities.Worker;
import model.LoanSystem;
import model.ToolSystem;
import model.WorkerSystem;
import view.View;
import view.AdapterUI;

public class Controller implements ActionListener{
	
	private View view;
	private AdapterUI adapterUI;
	private LoanSystem loanSystem;
	private WorkerSystem workerSystem;
	private ToolSystem toolSystem;
	
	public Controller(View view, LoanSystem loanSystem) {
		this.view = view;
		this.adapterUI = new AdapterUI();
		
		this.loanSystem = loanSystem;
		this.loanSystem.addObserver(this.adapterUI);
		
		this.workerSystem = new WorkerSystem();
		this.toolSystem = new ToolSystem();
		
		this.view.getBtnCreateLoan().addActionListener(this);
	}
	
	public void initialize() {
		this.view.getCbWorkers()
			.setModel(new DefaultComboBoxModel(this.workerSystem.getWorkers().toArray()));
		this.view.getCbTools()
			.setModel(new DefaultComboBoxModel(this.toolSystem.getTools().toArray()));
		this.view.show();
		this.adapterUI.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.view.getBtnCreateLoan()) {
			this.loanSystem.generateLoan((Tool)this.view.getCbTools().getSelectedItem(), 
					(Worker)this.view.getCbWorkers().getSelectedItem());
		}
	}

}
