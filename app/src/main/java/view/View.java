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
		frame.setBounds(0, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnCreateLoan = new JButton("Create Loan");
		btnCreateLoan.setBounds(165, 176, 117, 29);
		frame.getContentPane().add(btnCreateLoan);
		
		cbWorkers = new JComboBox<Borrower>();
		cbWorkers.setBounds(138, 38, 156, 30);
		frame.getContentPane().add(cbWorkers);
		
		cbTools = new JComboBox<Tool>();
		cbTools.setBounds(138, 104, 156, 30);
		frame.getContentPane().add(cbTools);
		
		JLabel lblBorrower = new JLabel("Borrower");
		lblBorrower.setBounds(138, 10, 61, 16);
		frame.getContentPane().add(lblBorrower);
		
		JLabel lblTool = new JLabel("Tool");
		lblTool.setBounds(138, 80, 61, 16);
		frame.getContentPane().add(lblTool);
		
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
