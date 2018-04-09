package aiubStudebtHelpDesk;


import java.awt.event.*;

import javax.swing.*;

import java.text.*;
import java.util.*;

public class AiubStudentHelpDesk extends JFrame implements ActionListener{
	

		
		//private static final String tring = null;
		private JPanel panel;
		private JButton buttonCgpaCalc,
						buttonTeacher,
						buttonFriend, 
						buttonCourseList,
						buttonCompletedCourse,
						buttonEligibleCourse,
						buttonExit;
		
		public AiubStudentHelpDesk()
		{
			this.initializeComponents();
		}
		
		public void actionPerformed(ActionEvent event)
		{
			String buttonText = event.getActionCommand();
			if(buttonText.equals("CGPA CALC"))
			{
				CgpaCalc cal = new CgpaCalc();
				cal.setVisible(true);
				this.setVisible(false);
			}
			
			else if(buttonText.equals("Contact List"))
			{
				ContactListFrame clf = new ContactListFrame();
				clf.setVisible(true);
				this.setVisible(false);
			}
			else if(buttonText.equals("Course List"))
			{
				CourseListFrame clf = new CourseListFrame();
				clf.setVisible(true);
				this.setVisible(false);
			}
			
			else if(buttonText.equals("Completed Course"))
			{
				CompletedCourseListFrame cclf = new CompletedCourseListFrame();
				cclf.setVisible(true);
				this.setVisible(false);
			}
			
			
			else if(buttonText.equals("Exit"))
			{
				System.exit(0);
			}
		}
		
		private void initializeComponents()
		{
			this.panel = new JPanel();
			this.panel.setLayout(null);
						
			this.buttonCgpaCalc = new JButton("CGPA CALC");
			this.buttonCgpaCalc.setBounds(40, 20, 110, 40);
			this.buttonCgpaCalc.addActionListener(this);
			this.panel.add(this.buttonCgpaCalc);
			
			this.buttonTeacher = new JButton("Contact List");
			this.buttonTeacher.setBounds(170, 20, 110, 40);
			this.buttonTeacher.addActionListener(this);
			this.panel.add(this.buttonTeacher);
			
			this.buttonCourseList = new JButton("Course List");
			this.buttonCourseList.setBounds(100, 80, 110, 40);
			this.buttonCourseList.addActionListener(this);
			this.panel.add(this.buttonCourseList);
			
			this.buttonCompletedCourse = new JButton("Completed Course");
			this.buttonCompletedCourse.setBounds(80, 140, 150, 40);
			this.buttonCompletedCourse.addActionListener(this);
			this.panel.add(this.buttonCompletedCourse);
			
			this.buttonExit = new JButton("Exit");
			this.buttonExit.setBounds(110, 220, 90, 60);
			this.buttonExit.addActionListener(this);
			this.panel.add(this.buttonExit);
			
			this.add(this.panel);
			
			this.setTitle("Aiub Student Help Desk");
			this.setSize(320, 330);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

}
