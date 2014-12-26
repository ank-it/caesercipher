import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BorderFactory;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import javax.swing.BoxLayout;
import java.awt.FlowLayout;

public class CaesarCipherGui extends JFrame 
{
	public CaesarCipherGui()
	{
		JPanel caeserCipherPanel = new JPanel();
		JPanel shiftPanel = new JPanel();

		JMenuBar menuBar = new JMenuBar();
		JMenu caeserCipherMenu = new JMenu("Caeser Cipher");
		JMenuItem clear = new JMenuItem("Clear");
		JMenuItem quit = new JMenuItem("Quit");
		quit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				System.exit(0);
			}
		});

		caeserCipherMenu.add(clear);
		caeserCipherMenu.add(quit);
		menuBar.add(caeserCipherMenu);
		this.setJMenuBar(menuBar);

		JLabel messageLabel = new JLabel("Message:");
		JLabel encryptedMessageLabel = new JLabel("Encrypted Message:");
		JLabel shiftLabel = new JLabel("Shift:");

		JButton encryptButton = new JButton("Encyrpt");

		JTextField messageField = new JTextField("Hello World");
		JTextField encryptedMessageField = new JTextField();
		encryptedMessageField.setEditable(false);
		JTextField shiftField = new JTextField("3");

		caeserCipherPanel.setLayout(new BoxLayout(caeserCipherPanel, BoxLayout.PAGE_AXIS));

		caeserCipherPanel.add(messageLabel);
		caeserCipherPanel.add(messageField);
		caeserCipherPanel.add(encryptedMessageLabel);
		caeserCipherPanel.add(encryptedMessageField);

		shiftPanel.setLayout(new FlowLayout(FlowLayout.LEADING));

		shiftPanel.add(shiftLabel);
		shiftPanel.add(shiftField);

		caeserCipherPanel.add(shiftPanel);
		caeserCipherPanel.add(encryptButton);
		caeserCipherPanel.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));

		add(caeserCipherPanel);

		this.setSize(500, 500);
		this.setTitle("Caeser Cipher");
		setVisible(true);
	}
}