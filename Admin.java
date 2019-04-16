package hpack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin {

	private JFrame frame;
	private JTextField name;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin window = new Admin();
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
	public Admin() {
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
		
		JLabel lblAdmin = new JLabel("ADMIN Account");
		lblAdmin.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAdmin.setBounds(142, 11, 173, 14);
		frame.getContentPane().add(lblAdmin);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(65, 55, 52, 14);
		frame.getContentPane().add(lblNewLabel);
		
		name = new JTextField();
		name.setBounds(184, 54, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		password = new JTextField();
		password.setBounds(184, 92, 86, 20);
		frame.getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(65, 93, 75, 14);
		frame.getContentPane().add(lblPassword);
		
		JButton btnNewButton = new JButton("Verify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (name.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Input Username and Password");	
				}
				else if (name.getText().equals("Fahim") && password.getText().equals("12345")) {
					JOptionPane.showMessageDialog(null, "Login is successful");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter correct");
			}
			}
		});
		btnNewButton.setBounds(128, 206, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}

}
