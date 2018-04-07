package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;

public class View {

	private JFrame frame;
	private JTextField txtDatos;
	private JButton btnAgregar;

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
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(168, 177, 117, 29);
		frame.getContentPane().add(btnAgregar);
		
		txtDatos = new JTextField();
		txtDatos.setText("Datos");
		txtDatos.setBounds(168, 83, 130, 26);
		frame.getContentPane().add(txtDatos);
		txtDatos.setColumns(10);
	}

	public JTextField getTxtDatos() {
		return txtDatos;
	}

	public void setTxtDatos(JTextField txtDatos) {
		this.txtDatos = txtDatos;
	}

	public JButton getBtnAgregar() {
		return btnAgregar;
	}

	public void setBtnAgregar(JButton btnAgregar) {
		this.btnAgregar = btnAgregar;
	}
	
	public void show() {
		this.frame.setVisible(true);
	}
}
