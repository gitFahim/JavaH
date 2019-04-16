package hpack;

import java.util.regex.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Bank1 {

	private JFrame frame;
	private JTextField UserName;
	private JPasswordField password;
	private JTextField var;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank1 window = new Bank1();
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
	public Bank1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bank System");
		lblNewLabel.setFont(new Font("Bookman Old Style", Font.BOLD, 18));
		lblNewLabel.setBounds(152, 11, 168, 22);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel Username = new JLabel("Username");
		Username.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Username.setBounds(10, 51, 97, 14);
		frame.getContentPane().add(Username);
		
		UserName = new JTextField();
		UserName.setBounds(162, 50, 86, 20);
		frame.getContentPane().add(UserName);
		UserName.setColumns(10);
		
		JLabel Password = new JLabel("Password");
		Password.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Password.setBounds(10, 80, 67, 14);
		frame.getContentPane().add(Password);
		
		password = new JPasswordField();
		password.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				String PATTERN = "^([a-zA-Z0-9@*#]{8,15})$";
				Pattern patt = Pattern.compile(PATTERN);
				Matcher match = patt.matcher(password.getText());
				if(!match.matches()) {
					var.setText("Password is incorrect");
				}
				else {
					var.setText(null);
				}
			}
		});
		password.setBounds(152, 81, 96, 20);
		frame.getContentPane().add(password);
		
		JLabel lblAccountName = new JLabel("Account Name");
		lblAccountName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAccountName.setBounds(10, 124, 97, 14);
		frame.getContentPane().add(lblAccountName);
		
		JRadioButton SavingAccount = new JRadioButton("Saving Account");
		SavingAccount.setBounds(152, 122, 109, 23);
		frame.getContentPane().add(SavingAccount);
		
		JRadioButton DepositAccount = new JRadioButton("Deposit Account");
		DepositAccount.setBounds(152, 148, 109, 23);
		frame.getContentPane().add(DepositAccount);
		
		JButton Button = new JButton("Save");
		Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String Name = UserName.getText().toString();
				String Password = password.getText().toString();
				String Save = SavingAccount.getText().toString();
				String Dep = DepositAccount.getText().toString();
			
			
			try {
				FileWriter writer = new FileWriter("Bank.txt", true);
				writer.write(Name);
				writer.write(Password);
				writer.write(Save);
				writer.write(Dep);
				
				writer.close();
				JOptionPane.showMessageDialog( Button , "Success");
			}
			catch(Exception e) {
				JOptionPane.showMessageDialog(Button, "Failed");
			}
			}
		});
		Button.setBounds(152, 198, 89, 23);
		frame.getContentPane().add(Button);
		
		var = new JTextField();
		var.setBounds(280, 79, 86, 20);
		frame.getContentPane().add(var);
		var.setColumns(10);
	}
}
