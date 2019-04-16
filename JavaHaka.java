package hpack;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.awt.event.ActionEvent;

public class JavaHaka {

	private JFrame frame;
	private JTextField UserName;
	private JTextField Father_Name;
	private JTextField MotherName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaHaka window = new JavaHaka();
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
	public JavaHaka() {
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
		
		JLabel lblNewLabel = new JLabel("Student Information");
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 30));
		lblNewLabel.setBounds(75, 11, 314, 35);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Student Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 65, 104, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		UserName = new JTextField();
		UserName.setBounds(140, 64, 86, 20);
		frame.getContentPane().add(UserName);
		UserName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Father's Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 96, 104, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		Father_Name = new JTextField();
		Father_Name.setBounds(140, 95, 86, 20);
		frame.getContentPane().add(Father_Name);
		Father_Name.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Mother's Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(10, 121, 104, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		MotherName = new JTextField();
		MotherName.setBounds(140, 120, 86, 20);
		frame.getContentPane().add(MotherName);
		MotherName.setColumns(10);
		
		JButton Submit = new JButton("Submit");
		Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*if (UserName.getText().isEmpty() || Father_Name.getText().isEmpty() || MotherName.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Please Input Username, Father's Name and Mother's Name");	
				}
				else if (UserName.getText().equals("Fahim") && Father_Name.getText().equals("Father") && MotherName.getText().equals("Mother")) {
					JOptionPane.showMessageDialog(null, "Login is successful");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please enter correct");
				}*/
				
				String Name = UserName.getText().toString();
				String FName = Father_Name.getText().toString();
				String MName = MotherName.getText().toString();
				
				try {
					FileWriter writer = new FileWriter("Student.txt", true);
					writer.write(Name);
					writer.write(FName);
					writer.write(MName);
					
					writer.close();
					JOptionPane.showMessageDialog(Submit, "Success");
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(Submit, "error");
				}
		}
		});
		Submit.setFont(new Font("Gill Sans MT", Font.PLAIN, 18));
		Submit.setBounds(163, 214, 89, 23);
		frame.getContentPane().add(Submit);
	}
}
