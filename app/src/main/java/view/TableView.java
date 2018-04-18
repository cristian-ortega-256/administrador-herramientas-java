package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;

import Entities.Loan;
import Entities.Retreat;
import javax.swing.JLabel;

public class TableView{

	private JFrame frame;
	private JList<Loan> listLoan;
	private JList<Retreat> listRetreat;
	private JLabel lblRET;
	private JLabel lblLOA;
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
		frame.setBounds(550, 100, 670, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		this.listLoan = new JList();
		listLoan.setBounds(0, 22, 283, 272);
		frame.getContentPane().add(listLoan);
		
		this.listRetreat = new JList();
		listRetreat.setBounds(293, 22, 351, 272);
		frame.getContentPane().add(listRetreat);
		
		lblRET = new JLabel("R E T R E A T S");
		lblRET.setBounds(451, 0, 121, 14);
		frame.getContentPane().add(lblRET);
		
		lblLOA = new JLabel("L O A N S");
		lblLOA.setBounds(120, 0, 61, 14);
		frame.getContentPane().add(lblLOA);
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

	public JList<Retreat> getListRetreat() {
		return listRetreat;
	}

	public void setListRetreat(JList<Retreat> listRetreat) {
		this.listRetreat = listRetreat;
	}
	
	
}
