package view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.AbstractBorder;
import javax.swing.border.EmptyBorder;

public class NotificationComponent {
	
	public static JPanel generateNotification(String title,String subtitle) {
		JPanel wrapper = new JPanel();
		wrapper.setBackground(Color.WHITE);
		AbstractBorder brdr = new TextBubbleBorder(Color.BLACK,2,16,0);
		wrapper.setBorder(brdr);
		wrapper.setLayout(new GridBagLayout());
		
		GridBagConstraints gbc = generateGrid();
		JLabel lblTitle = generateLabel(title, true);
		wrapper.add(lblTitle, gbc);
		
		GridBagConstraints gbc2 = generateGrid();
		JLabel lblSubTitle = generateLabel(subtitle, false);
		wrapper.add(lblSubTitle, gbc2);
		
		JPanel generalContainer = new JPanel();
		generalContainer.setBackground(Color.WHITE);
		generalContainer.setBorder(new EmptyBorder(5, 5, 5, 5));
		generalContainer.add(wrapper);
		
		return generalContainer;
	}

	private static JLabel generateLabel(String content, boolean centered) {
        return centered ? new JLabel(content, SwingConstants.CENTER) : new JLabel(content);
	}
	
	private static GridBagConstraints generateGrid() {
		GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        return gbc;
	}
}
