package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import Entities.Tool;
import Entities.Borrower;

public class View {

	private JFrame frame;
	private JComboBox<Borrower> cbWorkers;
	private JComboBox<Tool> cbTools;
	private JButton btnCreateLoan; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					View window = new View();
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
	public View() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("LOANS");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCreateLoan = new JButton("Agregar");
		btnCreateLoan.setBounds(168, 177, 117, 29);
		frame.getContentPane().add(btnCreateLoan);
		
		cbWorkers = new JComboBox<Borrower>();
		cbWorkers.setBounds(43, 37, 156, 30);
		frame.getContentPane().add(cbWorkers);
		
		cbTools = new JComboBox<Tool>();
		cbTools.setBounds(43, 80, 156, 30);
		frame.getContentPane().add(cbTools);
		
	}

	public JComboBox<Borrower> getCbWorkers() {
		return cbWorkers;
	}

	public void setCbWorkers(JComboBox<Borrower> cbWorkers) {
		this.cbWorkers = cbWorkers;
	}

	public JComboBox<Tool> getCbTools() {
		return cbTools;
	}

	public void setCbTools(JComboBox<Tool> cbTools) {
		this.cbTools = cbTools;
	}

	public JButton getBtnCreateLoan() {
		return btnCreateLoan;
	}

	public void setBtnCreateLoan(JButton btnCreateLoan) {
		this.btnCreateLoan = btnCreateLoan;
	}

	public void show() {
		this.frame.setVisible(true);
	}
}
