package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import Entities.Loan;

public class TableView{

	private JFrame frame;
	private JList<Loan> listLoan;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableView window = new TableView();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TableView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		this.listLoan = new JList();
		listLoan.setBounds(0, 0, 600, 600);
		frame.getContentPane().add(listLoan);
	}
	
	public JList<Loan> getListLoan() {
		return listLoan;
	}

	public void setListLoan(JList<Loan> listLoan) {
		this.listLoan = listLoan;
	}

	public void show() {
		this.frame.setVisible(true);
	}
}
