package aiubStudebtHelpDesk;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

import java.text.*;
import java.util.*;

public class ContactListFrame extends JFrame implements ActionListener{
	
	private static final String tring = null;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton buttonAdd, buttonUpdate, buttonDelete, buttonBack, buttonCatagory;
	//private AddPersonFrame Source;
	
	public ContactListFrame()
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
		else if(buttonText.equals("Add"))
		{
			AddPersonFrame apf = new AddPersonFrame();
			apf.setVisible(true);
			this.setVisible(false);
		}
		else if(buttonText.equals("Update"))
		{
			int row = table.getSelectedRow();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			String selectedID = tableModel.getValueAt(row, 0).toString();
			String selectedName = tableModel.getValueAt(row, 1).toString();
			String selectedAddress = tableModel.getValueAt(row, 2).toString();
			String selectedPhone = tableModel.getValueAt(row, 3).toString();
			String selectedEmail = tableModel.getValueAt(row, 4).toString();
			String selectedCatagory = tableModel.getValueAt(row, 5).toString();
			
			DataContext context = new DataContext();
			context.Update(selectedName, selectedAddress, selectedPhone, selectedEmail, selectedCatagory, selectedID);
			JOptionPane.showMessageDialog(null, "Selected person's details updated successfully");
		}
		else if(buttonText.equals("Delete"))
		{
			int row = table.getSelectedRow();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			String selectedID = tableModel.getValueAt(row, 0).toString();
			
			if(row >= 0)
			{
				tableModel.removeRow(row);
			}
			
			DataContext context = new DataContext();
			context.Delete(selectedID);
			JOptionPane.showMessageDialog(null, "Person deleted successfully");
			
		}
		
		else if(buttonText.equals("Catagory"))
		{
			CreateCatagoryFrame ccf = new CreateCatagoryFrame();
	    	ccf.setVisible(true);
	    	this.setVisible(false);
		}
		
		else if(buttonText.equals("Back"))
		{
			AiubStudentHelpDesk ashd = new AiubStudentHelpDesk();
			ashd.setVisible(true);
			this.setVisible(false);
		}
	}
	
	private void initializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		DataContext context = new DataContext();
		Vector<String> columns = new Vector<String>();
		columns.add("ID");
		columns.add("Name");
		columns.add("Address");
		columns.add("Phone");
		columns.add("Email");
		columns.add("Catagory");
		this.tableModel = new DefaultTableModel(context.getContactListAsString(), columns);
		
		this.table = new JTable(this.tableModel);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(3).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(4).setPreferredWidth(100);
		this.table.getColumnModel().getColumn(5).setPreferredWidth(100);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds(0, 0, 500, 180);
		this.panel.add(this.scrollPane);
		
		this.buttonAdd = new JButton("Add");
		this.buttonAdd.setBounds(530, 20, 90, 20);
		this.buttonAdd.addActionListener(this);
		this.panel.add(this.buttonAdd);
		
		this.buttonUpdate = new JButton("Update");
		this.buttonUpdate.setBounds(530, 70, 90, 20);
		this.buttonUpdate.addActionListener(this);
		this.panel.add(this.buttonUpdate);
		
		this.buttonDelete = new JButton("Delete");
		this.buttonDelete.setBounds(530, 120, 90, 20);
		this.buttonDelete.addActionListener(this);
		this.panel.add(this.buttonDelete);
		
		this.buttonCatagory = new JButton("Catagory");
		this.buttonCatagory.setBounds(530, 170, 90, 20);
		this.buttonCatagory.addActionListener(this);
		this.panel.add(this.buttonCatagory);
		
		this.buttonBack = new JButton("Back");
		this.buttonBack.setBounds(530, 220, 90, 20);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
		
		this.add(this.panel);
		
		this.setSize(650, 300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
