package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import Entities.Tool;
import Entities.ToolType;
import Entities.Worker;
import model.LoanSystem;
import model.Model;
import view.View;
import view.AdapterUI;
import view.TableView;

public class Controller implements ActionListener{
	
	private View view;
	private AdapterUI adapterUI;
	private LoanSystem loanSystem;
	
	public Controller(View view, LoanSystem loanSystem) {
		this.view = view;
		this.adapterUI = new AdapterUI();
		
		this.loanSystem = loanSystem;
		this.loanSystem.addObserver(this.adapterUI);
		
		this.view.getBtnAgregar().addActionListener(this);
	}
	
	public void initialize() {
		this.view.show();
		this.adapterUI.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.view.getBtnAgregar()) {
			Tool tool = new Tool("TestTaladro", ToolType.Taladro, false);
			Worker worker = new Worker("Goku");
			this.loanSystem.generateLoan(tool, worker, new Date());
		}
	}

}
