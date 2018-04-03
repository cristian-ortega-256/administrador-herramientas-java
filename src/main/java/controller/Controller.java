package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Model;
import view.View;
import view.TableView;

public class Controller implements ActionListener{
	
	private View view;
	private Model model;
	
	private TableView table;
	
	public Controller(View view, Model model) {
		this.view = view;
		this.model = model;
		
		this.table = new TableView();
		
		this.model.addObserver(this.table);
		
		this.view.getBtnAgregar().addActionListener(this);
	}
	
	public void initialize() {
		this.view.show();
		this.table.show();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == this.view.getBtnAgregar()) {
			this.model.addValue(this.view.getTxtDatos().getText());
		}
	}

}
