import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
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
	private JTextField shiftField;
	private JTextArea messageField, encryptedMessageField;
	private Cipher cipher;

	public CaesarCipherGui()
	{
		cipher = new Cipher();

		JPanel caeserCipherPanel = new JPanel();
		JPanel shiftPanel = new JPanel();

		JMenuBar menuBar = new JMenuBar();
		JMenu caeserCipherMenu = new JMenu("Caeser Cipher");
		JMenuItem clear = new JMenuItem("Clear");
		clear.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				clear();
			}
		});
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
		JPanel messagePanel = new JPanel();
		messagePanel.add(messageLabel);

		JLabel encryptedMessageLabel = new JLabel("Encrypted Message:");
		JPanel encryptedMessagePanel = new JPanel();
		encryptedMessagePanel.add(encryptedMessageLabel);

		JLabel shiftLabel = new JLabel("Shift:");

		JButton encryptButton = new JButton("Encyrpt");
		encryptButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent event)
			{
				if(!getMessage().isEmpty() && !getShift().isEmpty() && validateShift(getShift()))
				{
					setEncryptedMessage(cipher.encrypt(getMessage(), Integer.parseInt(getShift())));
				}
			}
		});

		messageField = new JTextArea("Hello World");
		messageField.setColumns(20);
		messageField.setLineWrap(true);
		messageField.setRows(5);
		messageField.setWrapStyleWord(true);

		encryptedMessageField = new JTextArea();
		encryptedMessageField.setEditable(false);

		shiftField = new JTextField("3");
		shiftField.setColumns(4);

		caeserCipherPanel.setLayout(new BoxLayout(caeserCipherPanel, BoxLayout.PAGE_AXIS));

		caeserCipherPanel.add(messagePanel);
		caeserCipherPanel.add(messageField);
		caeserCipherPanel.add(encryptedMessagePanel);
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

	public String getMessage()
	{
		return messageField.getText();
	}

	public String getShift()
	{
		return shiftField.getText();
	}

	public void setEncryptedMessage(String eMessage)
	{
		encryptedMessageField.setText(eMessage);
	}

	public void clear()
	{
		messageField.setText("");
		encryptedMessageField.setText("");
		shiftField.setText("");
	}

	public boolean validateShift(String shiftVal)
	{
		int i;
		boolean ret = true;
		try
		{
			i = Integer.parseInt(shiftVal);
			if(i < 1)
			{
				ret = false;
			}
		}
		catch(NumberFormatException e)
		{
			ret = false;
		}

		return ret;
	}
}