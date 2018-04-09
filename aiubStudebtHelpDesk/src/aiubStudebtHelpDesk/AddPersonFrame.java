package aiubStudebtHelpDesk;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class AddPersonFrame extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JRootPane rootPane;
	private JLabel labelName, labelAddress, labelPhone, labelEmail, labelCatagory;
	private JTextField textName, textAddress, textPhone, textEmail;
	private JComboBox comboCatagory;
	private JButton buttonSave, buttonExit, buttonContactList;
	
	public AddPersonFrame()
	{
		this.initializeComponents();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Exit"))
		{
			System.exit(0);
		}
		else if(buttonText.equals("List"))
		{
			ContactListFrame clf = new ContactListFrame();
			clf.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonText.equals("Save"))
		{
			Person person = new Person();
			person.setName(textName.getText());
			person.setAddress(textAddress.getText());
			person.setPhone(textPhone.getText());
			person.setEmail(textEmail.getText());
			person.setCatagory(comboCatagory.getSelectedItem().toString());
			DataContext context = new DataContext();
			context.Save(person);
			JOptionPane.showMessageDialog(null, "Person saved successfully");
			
			textName.setText("");
			textAddress.setText("");
			textEmail.setText("");
		}
	}
	
	private void initializeComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.labelName = new JLabel("Name");
		this.labelName.setBounds(20, 20, 70, 20);
		this.panel.add(this.labelName);
		
		this.textName = new JTextField();
		this.textName.setBounds(100, 20, 150, 20);
		this.panel.add(this.textName);
		
		this.labelAddress = new JLabel("Address");
		this.labelAddress.setBounds(20, 50, 70, 20);
		this.panel.add(this.labelAddress);
		
		this.textAddress = new JTextField();
		this.textAddress.setBounds(100, 50, 150, 20);
		this.panel.add(this.textAddress);
		
		this.labelPhone = new JLabel("Phone");
		this.labelPhone.setBounds(20, 80, 70, 20);
		this.panel.add(this.labelPhone);
		
		this.textPhone = new JTextField();
		this.textPhone.setBounds(100, 80, 150, 20);
		this.panel.add(this.textPhone);
		
		this.labelEmail = new JLabel("Email");
		this.labelEmail.setBounds(20, 110, 70, 20);
		this.panel.add(this.labelEmail);
		
		this.textEmail = new JTextField();
		this.textEmail.setBounds(100, 110, 150, 20);
		this.panel.add(this.textEmail);
		
		this.labelCatagory = new JLabel("Catagory");
		this.labelCatagory.setBounds(20, 140, 70, 20);
		this.panel.add(this.labelCatagory);
		
		DataContext context = new DataContext();
		//this.tableModel = new DefaultTableModel(context.getContactListAsString(), columns);
		
		
		this.comboCatagory = new JComboBox(context.getCatagorytListAsString());
		this.comboCatagory.setBounds(100, 140, 150, 20);
		this.panel.add(this.comboCatagory);
		
		
		this.buttonContactList = new JButton("List");
		this.buttonContactList.setBounds(60, 180, 70, 40);
		this.buttonContactList.addActionListener(this);
		this.panel.add(this.buttonContactList);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(150, 180, 70, 40);
		this.buttonSave.addActionListener(this);
		this.panel.add(this.buttonSave);
		
		this.rootPane = this.getRootPane();
		this.rootPane.setDefaultButton(this.buttonSave);
		
		this.add(this.panel);
		
		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}