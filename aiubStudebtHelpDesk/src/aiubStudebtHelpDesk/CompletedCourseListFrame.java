package aiubStudebtHelpDesk;
	

import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

//import java.text.*;
import java.util.*;

public class CompletedCourseListFrame extends JFrame implements ActionListener{
	
	//private static final String tring = null;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton buttonBack;
	//private JLabel labelCourseList;
	//private JComboBox comboCourseList;
	//private AddPersonFrame Source;
	
	public CompletedCourseListFrame()
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
		columns.add("Course Name");
		this.tableModel = new DefaultTableModel(context.getCompletedCoursetListAsString(), columns);
		
		this.table = new JTable(this.tableModel);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(30);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(400);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds(0, 0, 500, 200);
		this.panel.add(this.scrollPane);
		
		this.buttonBack = new JButton("Back");
		this.buttonBack.setBounds(200, 240, 90, 20);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
		
		this.add(this.panel);
		
		this.setSize(500, 320);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
