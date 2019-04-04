import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RemoveAccount extends JPanel
{
	public RemoveAccount(ArrayList <BankAccount> accList)
	{
		setLayout(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		JLabel name = new JLabel("Name: ");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(name, gbc);
		
		JTextField nameTxt = new JTextField("");
		gbc.gridx = 1;
		nameTxt.setPreferredSize(new Dimension(200, 30));
		add(nameTxt, gbc);
		
		JLabel bal = new JLabel("Account Number: ");
		gbc.gridx = 0;
		gbc.gridy = 1;
		add(bal, gbc);
		
		JTextField balTxt = new JTextField("");
		balTxt.setPreferredSize(new Dimension(200, 30));
		gbc.gridx = 1;
		add(balTxt, gbc);
		
		JLabel acc = new JLabel("Account Number: ");
		gbc.gridx = 0;
		gbc.gridy = 3;
		add(acc, gbc);
		
		JButton removeAcc = new JButton("Remove Account");
		gbc.gridx = 0;
		gbc.gridy = 0;
		add(removeAcc, gbc);
		removeAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				
			}
		});	
		
	}
}
