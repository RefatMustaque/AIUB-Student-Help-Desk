package aiubStudebtHelpDesk;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JOptionPane;
public class DataContext {
	private Connection connection;
	private Statement statement;
	
	public DataContext()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			this.connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/phonebook", "root", "");
			this.statement = this.connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
															ResultSet.CONCUR_UPDATABLE);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
	}
	
	public Vector<Vector<String>> getContactListAsString()
	{
		try
		{
			String sql = "SELECT * FROM person";
			ResultSet rs = this.statement.executeQuery(sql);
			Vector<Vector<String>> personList = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> person = new Vector<String>();
				person.add(rs.getString("ID"));
				person.add(rs.getString("Name"));
				person.add(rs.getString("Address"));
				person.add(rs.getString("Phone"));
				person.add(rs.getString("Email"));
				person.add(rs.getString("Catagory"));
				personList.add(person);
			}
			return personList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean Save(Person person)
	{
		try
		{
			String sql = "INSERT INTO person VALUES ('0','" + person.getName() +  "','" + person.getAddress() +  "', '" + person.getPhone() +  "', '" + person.getEmail() +  "', '" + person.getCatagory() +  "')";
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}
	
	
	public boolean Update(String selectedName,String selectedAddress,String selectedPhone,String selectedEmail,String selectedCatagory,String selectedID)
	{
		try
		{
			String sql = "UPDATE person SET Name ='" + selectedName +  "', Address ='" + selectedAddress +  "', Phone = '" + selectedPhone +  "', Email = '" + selectedEmail +  "', Catagory=  '" + selectedCatagory +  "' where ID ='"+selectedID+"'";
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}
	
	public boolean Delete(String selectedID)
	{
		try
		{
			String sql = "DELETE from person where ID ='"+selectedID+"'";
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}
	
	public Vector<String> getCatagorytListAsString()
	{
		try
		{
			String sql = "SELECT DISTINCT Catagory FROM catagory";
			ResultSet rs = this.statement.executeQuery(sql);
			//Vector<String> personList = new Vector<String>();
			Vector<String> person = new Vector<String>();
			while(rs.next())
			{
				
				person.add(rs.getString("Catagory"));
				//personList.addAll(person.Catagory);
			}
			return person;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
			
	}
	
	public boolean CatagorySave(Person person)
	{
		try
		{
			String sql = "INSERT INTO Catagory VALUES ('0','" + person.getCatagory() +  "')";
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}
	
	public boolean CourseSave(Person person)
	{
		try
		{
			String sql = "INSERT INTO CompletedCourse VALUES ('0', '" + person.getCourse() +  "')";
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(null, "Already added.");
			ex.printStackTrace();
			return false;
		}		
	}
	
	
	public Vector<Vector<String>> getCompletedCoursetListAsString()
	{
		try
		{
			String sql = "SELECT * FROM  `completedcourse`";
			ResultSet rs = this.statement.executeQuery(sql);
			//Vector<String> completedCourseList = new Vector<String>();
			Vector<Vector<String>> completedCourse = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> course = new Vector<String>();
				course.add(rs.getString("ID"));
				course.add(rs.getString("CourseName"));
				completedCourse.add(course);
				//personList.addAll(person.Catagory);
			}
			return completedCourse;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
			
	}
	
	
	public Vector<Vector<String>> getCourseListAsString()
	{
		try
		{
			String sql = "SELECT * FROM CourseList";
			ResultSet rs = this.statement.executeQuery(sql);
			Vector<Vector<String>> courseList = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> course = new Vector<String>();
				course.add(rs.getString("ID"));
				course.add(rs.getString("CourseName"));
				course.add(rs.getString("PREREQ."));
				courseList.add(course);
			}
			return courseList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}
	
	public Vector<Vector<String>> getCourseNameAsString()
	{
		try
		{
			String sql = "SELECT * FROM CourseList";
			ResultSet rs = this.statement.executeQuery(sql);
			Vector<Vector<String>> courseList = new Vector<Vector<String>>();
			while(rs.next())
			{
				Vector<String> course = new Vector<String>();
				course.add(rs.getString("CourseName"));
				courseList.add(course);
			}
			return courseList;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
	}

	public boolean SaveCmpCrs(String selectedId, String selectedName)
	{
		try
		{
			String sql = "INSERT INTO Eligible Course VALUES ('0','" + person.getName() +  "','" + person.getAddress() +  "', '" + person.getPhone() +  "', '" + person.getEmail() +  "', '" + person.getCatagory() +  "')";
			this.statement.execute(sql);
			return true;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return false;
		}		
	}
}
