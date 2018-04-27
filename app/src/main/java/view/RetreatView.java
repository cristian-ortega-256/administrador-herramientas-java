package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import Entities.Borrower;
import Entities.Supply;

import javax.swing.JLabel;
import javax.swing.JButton;

public class RetreatView {

	private JFrame frame;
	private JTextField txtQuantity;
	private JComboBox cbBorrow;
	private JComboBox cbSupplies;
	private JButton btnCreate;
	private JLabel lblTool;
	private JLabel lblRetreater;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RetreatView window = new RetreatView();
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
	public RetreatView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("RETREATS");
		frame.setBounds(100, 400, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		cbBorrow = new JComboBox<Borrower>();
		cbBorrow.setBounds(132, 58, 146, 20);
		frame.getContentPane().add(cbBorrow);
		
		cbSupplies = new JComboBox<Supply>();
		cbSupplies.setBounds(132, 113, 146, 20);
		frame.getContentPane().add(cbSupplies);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(220, 145, 56, 20);
		frame.getContentPane().add(txtQuantity);
		txtQuantity.setColumns(10);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setBounds(132, 148, 76, 14);
		frame.getContentPane().add(lblQuantity);
		
		btnCreate = new JButton("Create Retreat");
		btnCreate.setBounds(132, 196, 119, 23);
		frame.getContentPane().add(btnCreate);
		
		lblTool = new JLabel("Tool");
		lblTool.setBounds(132, 85, 61, 16);
		frame.getContentPane().add(lblTool);
		
		lblRetreater = new JLabel("Retreater");
		lblRetreater.setBounds(132, 30, 61, 16);
		frame.getContentPane().add(lblRetreater);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JTextField getTxtQuantity() {
		return txtQuantity;
	}

	public void setTxtQuantity(JTextField txtQuantity) {
		this.txtQuantity = txtQuantity;
	}

	public JComboBox<Borrower> getCbBorrow() {
		return cbBorrow;
	}

	public void setCbBorrow(JComboBox<Borrower> cbBorrow) {
		this.cbBorrow = cbBorrow;
	}

	public JComboBox<Supply> getCbSupplies() {
		return cbSupplies;
	}

	public void setCbSupplies(JComboBox<Supply> cbSupplies) {
		this.cbSupplies = cbSupplies;
	}

	public JButton getBtnCreate() {
		return btnCreate;
	}

	public void setBtnCreate(JButton btnCreate) {
		this.btnCreate = btnCreate;
	}
	
	public void show() {
		this.frame.setVisible(true);
	}	
}
