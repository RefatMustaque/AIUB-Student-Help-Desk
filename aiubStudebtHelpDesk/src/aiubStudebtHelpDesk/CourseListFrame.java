package aiubStudebtHelpDesk;
	

import java.awt.event.*;

import javax.swing.*;
import javax.swing.table.*;

//import java.text.*;
import java.util.*;

public class CourseListFrame extends JFrame implements ActionListener{
	
	//private static final String tring = null;
	private JPanel panel;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel tableModel;
	private JButton buttonBack, buttonAddCourse;
	private JLabel labelCourseList;
	private JComboBox comboCourseList;
	//private AddPersonFrame Source;
	
	public CourseListFrame()
	{
		this.initializeComponents();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String buttonText = event.getActionCommand();
		if(buttonText.equals("Add"))
		{
			/*Person person = new Person();
			person.setCourse(comboCourseList.getSelectedItem().toString());
			DataContext context = new DataContext();
			context.CourseSave(person);
			JOptionPane.showMessageDialog(null, "Person saved successfully");*/
			
			int row = table.getSelectedRow();
			
			DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
			
			String selectedID = tableModel.getValueAt(row, 0).toString();
			String selectedName = tableModel.getValueAt(row, 1).toString();
			
			DataContext context = new DataContext();
			context.SaveCmpCrs(selectedID, selectedName);
			JOptionPane.showMessageDialog(null, "Selected person's details updated successfully");
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
		columns.add("PREREQ.");
		this.tableModel = new DefaultTableModel(context.getCourseListAsString(), columns);
		
		this.table = new JTable(this.tableModel);
		this.table.getColumnModel().getColumn(0).setPreferredWidth(80);
		this.table.getColumnModel().getColumn(1).setPreferredWidth(400);
		this.table.getColumnModel().getColumn(2).setPreferredWidth(80);
		this.table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		
		this.scrollPane = new JScrollPane(this.table);
		this.scrollPane.setBounds(0, 0, 500, 200);
		this.panel.add(this.scrollPane);
		
		this.labelCourseList = new JLabel("Add to completed course list");
		this.labelCourseList.setBounds(20, 220, 200, 20);
		this.panel.add(this.labelCourseList);
		
		this.comboCourseList = new JComboBox(context.getCourseNameAsString());
		this.comboCourseList.setBounds(20, 250, 330, 20);
		this.panel.add(this.comboCourseList);
		
		this.buttonBack = new JButton("Add");
		this.buttonBack.setBounds(20, 280, 90, 20);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
		
		this.buttonAddCourse = new JButton("Back");
		this.buttonAddCourse.setBounds(370, 240, 90, 20);
		this.buttonAddCourse.addActionListener(this);
		this.panel.add(this.buttonAddCourse);
		
		this.add(this.panel);
		
		this.setSize(500, 350);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}

