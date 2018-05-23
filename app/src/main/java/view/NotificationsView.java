package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

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

import Entities.Notification;

import javax.swing.UIManager;

public class NotificationsView implements Observer{

	private ArrayList<Notification> notifications;
	private JFrame frame;
	private JPanel panel;
	private JScrollPane sPanel;
	private int width = 585;
	private int height = 580;

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
		frame.setBounds(1220, 100, width, height+20);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, width, height);
		panel.setLayout(new GridBagLayout());
		
		// NOTIFICATIONS SECTION
		this.notifications = new ArrayList<Notification>();
		this.checkNotificationsRender();
		
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

	@Override
	public void update(Observable o, Object arg) {
		this.notifications = (ArrayList<Notification>) arg;
		this.checkNotificationsRender();
	}

	private void checkNotificationsRender() {
		if(this.notifications.size() == 0) {
			this.renderEmptyMessage();						
		}
		else {
			this.renderNotifications();
		}
	}

	private void renderEmptyMessage() {
		panel.removeAll();
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
		panel.add(NotificationComponent.generateNotification("There are no notifications avaiable..",""),gbc);
		
	}

	private void renderNotifications() {
		panel.removeAll();
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        for (int i=0; i<this.notifications.size(); i++){
        	Notification n = this.notifications.get(i);
            panel.add(NotificationComponent.generateNotification(n.getTitle(),n.getMessage()),gbc);        	
        }
        this.panel.revalidate();
        this.panel.repaint();
	}	

}
