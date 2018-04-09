package aiubStudebtHelpDesk;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.text.*;
import java.util.*;

public class CreateCatagoryFrame extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JRootPane rootPane;
	private JLabel labelCatagory;
	private JTextField textCatagory;
	private JButton buttonSave, buttonContactList;
	
	public ArrayList<String> catagory = new ArrayList<String>();
	//public String[] catagoryList = new String[catagory.size()];
	public CreateCatagoryFrame()
	{
		this.initializeComponents();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		
		if(buttonText.equals("Contact List"))
		{
			ContactListFrame clf = new ContactListFrame();
			clf.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonText.equals("Save"))
		{
			Person person = new Person();
			person.setCatagory(textCatagory.getText());
			DataContext context = new DataContext();
			context.CatagorySave(person);
			JOptionPane.showMessageDialog(null, "Catagory saved successfully");
			
			textCatagory.setText("");
		}
	}
	
	private void initializeComponents() {
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		this.labelCatagory = new JLabel("Catagory Name");
		this.labelCatagory.setBounds(20, 20, 100, 20);
		this.panel.add(this.labelCatagory);
		
		this.textCatagory = new JTextField();
		this.textCatagory.setBounds(130, 20, 150, 20);
		this.panel.add(this.textCatagory);
		
		this.buttonContactList = new JButton("Contact List");
		this.buttonContactList.setBounds(40, 60, 120, 40);
		this.buttonContactList.addActionListener(this);
		this.panel.add(this.buttonContactList);
		
		this.buttonSave = new JButton("Save");
		this.buttonSave.setBounds(180, 60, 70, 40);
		this.buttonSave.addActionListener(this);
		this.panel.add(this.buttonSave);
		
		this.rootPane = this.getRootPane();
		this.rootPane.setDefaultButton(this.buttonSave);
		
		this.add(this.panel);
		
		this.setSize(300, 200);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}