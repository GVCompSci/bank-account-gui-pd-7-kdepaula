import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * AP Computer Science Period 7
 * Katelyn DePaula
 * @author kdepaula20
 *
 */
public class Frame extends JFrame
{
	private static final double OVER_DRAFT_FEE = 15;
	private static final double RATE = .0025;
	private static final double TRANSACTION_FEE = 1.5;
	private static final double MIN_BAL = 300;
	private static final double MIN_BAL_FEE = 10;
	private static final double FREE_TRANSACTIONS = 10;
	
	public Frame()
	{
		ArrayList <BankAccount> accList = new ArrayList<BankAccount>();
		setTitle("Bank Account");
		setBounds(500, 200, 400, 250);
		
		CardLayout cl = new CardLayout();
		JPanel overall = new JPanel();
		overall.setLayout(cl);
		
		JMenuBar bar = new JMenuBar();
		
		JMenu menu1 = new JMenu("Account");
		JMenuItem addAcc = new JMenuItem("Add Account");
		menu1.add(addAcc);
		JMenuItem option2 = new JMenuItem("Remove Account");
		menu1.add(option2);
		JMenuItem option3 = new JMenuItem("Find Account");
		menu1.add(option3);
		bar.add(menu1);
		
		JMenu menu2 = new JMenu("Transaction");
		JMenuItem option4 = new JMenuItem("hmm");
		menu2.add(option4);
		JMenuItem option5 = new JMenuItem("this");
		menu2.add(option5);
		JMenuItem option6 = new JMenuItem("no");
		menu2.add(option6);
		bar.add(menu2);
		
		JMenuItem menu3 = new JMenuItem("Home");
		JMenu cluster = new JMenu("Many options");
		menu3.add(cluster);
		JMenuItem option7 = new JMenuItem("stuff");
		cluster.add(option7);
		JMenuItem option8 = new JMenuItem("?!!??!");
		cluster.add(option8);
		bar.add(menu3);
		
		option1.addActionListener(new ActionListener ()
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				man.setVisible(false);
			}

		});
		
		option8.addActionListener(new ActionListener ()
		{
			
			public void actionPerformed(ActionEvent arg0) 
			{
				man.setVisible(true);
			}

		});
	
		
		JLabel name = new JLabel("Name: ");
		name.setBounds(30, 30, 80, 20);
		add(name);
		
		JTextField nameTxt = new JTextField("");
		nameTxt.setBounds(140, 30, 200, 20);
		add(nameTxt);
		
		JLabel bal = new JLabel("Initial Balance: ");
		bal.setBounds(30, 90, 100, 20);
		add(bal);
		
		JTextField balTxt = new JTextField("");
		balTxt.setBounds(140, 90, 200, 20);
		add(balTxt);
		
		JLabel acc = new JLabel("Account Type: ");
		acc.setBounds(30, 60, 100, 20);
		add(acc);
		
		JComboBox type = new JComboBox(new String[] {"", "Checking", "Savings"});
		type.setBounds(140, 60, 200, 20);
		add(type);
		
		JButton displayAcc = new JButton("Display All Accounts");
		displayAcc.setBounds(200, 120, 150, 30);
		add(displayAcc);
		displayAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
					for(BankAccount a : accList)
					{
						System.out.print(a.toString());
						System.out.println();
					}
			}
		});
		
		JButton createAcc = new JButton("Create Account");
		createAcc.setSize(new Dimension(140, 30));
		createAcc.setLocation(new Point(30, 120));
		add(createAcc);
		createAcc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(!isNumeric(balTxt.getText()) || type.getSelectedItem().equals("") || nameTxt.getText().equals(""))
				{
					
				}
				else if(type.getSelectedItem().equals("Checking"))
				{
					accList.add(new CheckingAccount(nameTxt.getText(), Double.parseDouble(balTxt.getText()), OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTIONS));
					nameTxt.setText("");
					balTxt.setText("");
					type.setSelectedItem("");
				}
				else if(type.getSelectedItem().equals("Savings"))
				{
					accList.add(new SavingsAccount(nameTxt.getText(), Double.parseDouble(balTxt.getText()), RATE, MIN_BAL, MIN_BAL_FEE));
					nameTxt.setText("");
					balTxt.setText("");
					type.setSelectedItem("");
				}
			}
		});
		
		this.setJMenuBar(bar);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		
	}
	
	
	
	public static void main(String args[])
	{
		Frame fr = new Frame();
	}
	
	private static boolean isNumeric(String str) 
	{
		try
		{
			Double.parseDouble(str);
			return true;
		}
		
		catch(IllegalArgumentException e)
		{
			return false;
		}
	}
}
