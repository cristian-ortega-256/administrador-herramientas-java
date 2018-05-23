package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.UIManager;

public class NotificationsView {

	private JFrame frame;
	private JPanel panel;
	private JScrollPane sPanel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NotificationsView window = new NotificationsView();
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
	public NotificationsView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		int width = 255;
		int height = 500;
		frame.setBounds(100, 100, width, height+20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, width, height);
		panel.setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
		
		// NOTIFICATIONS SECTION
        // TODO --> Show notifications dynamically
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		panel.add(Notification.generateNotification(),gbc);
		
		// SCROLL SECTION
		sPanel = new JScrollPane(panel);
		sPanel.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		sPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		sPanel.setBounds(0, 0, width, height);
		frame.getContentPane().add(sPanel);
	}
	
	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getPanel() {
		return panel;
	}

	public void setPanel(JPanel panel) {
		this.panel = panel;
	}

	public JScrollPane getsPanel() {
		return sPanel;
	}

	public void setsPanel(JScrollPane sPanel) {
		this.sPanel = sPanel;
	}

	public void show() {
		this.frame.setVisible(true);
	}	

}
