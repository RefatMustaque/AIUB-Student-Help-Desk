package aiubStudebtHelpDesk;


import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

//import personFrame.PersonFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class LoginFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel labelUsername, labelPassword;
	private JTextField textUsername;
	private JPasswordField textPassword;
	private JCheckBox checkboxRememberMe;
	private JButton buttonLogin, buttonCancel;
	
	
	public LoginFrame()
	{
		this.InitializeComponents();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String textOfButton = event.getActionCommand();
		
		if(textOfButton.equals("Login"))
		{
			String username = this.textUsername.getText().trim();
			String passsword = this.textPassword.getText().trim();
			
			if(username.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Please enter your username");
			}
			else if(passsword.equals(""))
			{
				JOptionPane.showMessageDialog(this, "Please enter your password");
			}
			else if(passsword.length() < 4)
			{
				JOptionPane.showMessageDialog(this, "Password should have at least 4 characters");
			}
			else
			{
				if(username.equals("admin") && passsword.equals("admin"))
				{
					AiubStudentHelpDesk ashd = new AiubStudentHelpDesk();
					ashd.setVisible(true);
					this.setVisible(false);
				}
				
				else
				{
					JOptionPane.showMessageDialog(this, "Wrong Username or Password.");
				}
			}
		}
		else if(textOfButton.equals("Cancel"))
		{
			System.exit(0); // Close the program
		}
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		
		this.labelUsername = new JLabel("USERNAME");
		this.labelUsername.setBounds(20, 20, 80, 20);
		this.panel.add(this.labelUsername);
		
		
		this.textUsername = new JTextField();
		this.textUsername.setBounds(110, 20, 120, 20);
		this.panel.add(this.textUsername);
		
		
		this.labelPassword = new JLabel("PASSWORD");
		this.labelPassword.setBounds(20, 50, 80, 20);
		this.panel.add(this.labelPassword);
		
		
		this.textPassword = new JPasswordField();
		this.textPassword.setBounds(110, 50, 120, 20);
		this.panel.add(this.textPassword);
		
		
		this.checkboxRememberMe = new JCheckBox("Remember Me");
		this.checkboxRememberMe.setBounds(106, 80, 120, 20);
		this.panel.add(this.checkboxRememberMe);
		
		
		this.buttonCancel = new JButton("Cancel");
		this.buttonCancel.setBounds(40, 110, 80, 20);
		this.buttonCancel.addActionListener(this);
		this.panel.add(this.buttonCancel);
		
		
		this.buttonLogin = new JButton("Login");
		this.buttonLogin.setBounds(130, 110, 80, 20);
		this.buttonLogin.addActionListener(this);
		this.panel.add(this.buttonLogin);
		
		
		this.add(this.panel);
		
		this.setTitle("Aiub Student Help Desk");
		this.setSize(270, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}