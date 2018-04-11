package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TableView{

	private JFrame frame;
	private JLabel textField;
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
		frame.setBounds(100, 100, 450, 150);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JLabel("");
		textField.setBounds(6, 6, 438, 116);
		frame.getContentPane().add(textField);
	}
	
	public JLabel getTextField() {
		return textField;
	}

	public void setTextField(JLabel textField) {
		this.textField = textField;
	}

	public void show() {
		this.frame.setVisible(true);
	}
}
