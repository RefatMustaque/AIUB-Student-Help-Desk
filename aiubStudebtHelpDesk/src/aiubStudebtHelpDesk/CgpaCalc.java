package aiubStudebtHelpDesk;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPanel;

//import personFrame.PersonFrame;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CgpaCalc extends JFrame implements ActionListener {

	private JPanel panel;
	private JLabel labelPreviousSemCgpa,
				   labelCurrentSemCgpa,
				   labelCompeltedCredit,
				   CurrentSemCredit;
	private JTextField textPreviousSemCgpa,
					   textCurrentSemCgpa,
					   textCompeltedCredit,
					   textCurrentSemCredit;
	private JButton buttonCalc, buttonBack;
	
	
	public CgpaCalc()
	{
		this.InitializeComponents();
	}
	
	public void actionPerformed(ActionEvent event)
	{
		String textOfButton = event.getActionCommand();
		
		if(textOfButton.equals("Calculate"))
		{
			double PreviousSemCgpa = Double.parseDouble( textPreviousSemCgpa.getText());
			double CurrentSemCgpa = Double.parseDouble( textCurrentSemCgpa.getText());
			double CompeltedCredit = Double.parseDouble( textCompeltedCredit.getText());
			double CurrentSemCredit = Double.parseDouble( textCurrentSemCredit.getText());
			
			String CGPA = String.format("%.2f",((PreviousSemCgpa*CompeltedCredit)+(CurrentSemCgpa*CurrentSemCredit))/(CompeltedCredit+CurrentSemCredit));
			
			
			JOptionPane.showMessageDialog(null, "Your CGPA is "+CGPA);
		}
		else if(textOfButton.equals("Back"))
		{
			AiubStudentHelpDesk ashd = new AiubStudentHelpDesk();
			ashd.setVisible(true);
			this.setVisible(false);
			
		}
	}
	
	private void InitializeComponents()
	{
		this.panel = new JPanel();
		this.panel.setLayout(null);
		
		
		this.labelPreviousSemCgpa = new JLabel("Previous Semester CGPA");
		this.labelPreviousSemCgpa.setBounds(20, 20, 150, 20);
		this.panel.add(this.labelPreviousSemCgpa);
		
		
		this.textPreviousSemCgpa = new JTextField();
		this.textPreviousSemCgpa.setBounds(20, 50, 50, 20);
		this.panel.add(this.textPreviousSemCgpa);
		
		this.labelCompeltedCredit = new JLabel("Completed Credit");
		this.labelCompeltedCredit.setBounds(20, 80, 150, 20);
		this.panel.add(this.labelCompeltedCredit);
		
		
		this.textCompeltedCredit= new JTextField();
		this.textCompeltedCredit.setBounds(20, 110, 50, 20);
		this.panel.add(this.textCompeltedCredit);
		
		this.labelCurrentSemCgpa = new JLabel("Current CGPA");
		this.labelCurrentSemCgpa.setBounds(20, 140, 120, 20);
		this.panel.add(this.labelCurrentSemCgpa);
		
		
		this.textCurrentSemCgpa = new JTextField();
		this.textCurrentSemCgpa.setBounds(20, 170, 50, 20);
		this.panel.add(this.textCurrentSemCgpa);
		
		this.CurrentSemCredit = new JLabel("Current Semester Credit");
		this.CurrentSemCredit.setBounds(20, 200, 150, 20);
		this.panel.add(this.CurrentSemCredit);
		
		this.textCurrentSemCredit= new JTextField();
		this.textCurrentSemCredit.setBounds(20, 220, 50, 20);
		this.panel.add(this.textCurrentSemCredit);
		
		
		this.buttonCalc = new JButton("Calculate");
		this.buttonCalc.setBounds(30, 260, 100, 20);
		this.buttonCalc.addActionListener(this);
		this.panel.add(this.buttonCalc);
		
		this.buttonBack = new JButton("Back");
		this.buttonBack.setBounds(140, 260, 80, 20);
		this.buttonBack.addActionListener(this);
		this.panel.add(this.buttonBack);
		
		
		this.add(this.panel);
		
		this.setTitle("Aiub Student Help Desk");
		this.setSize(320, 330);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
