package HibernateHW1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

import DAO.CourseDAO;
import DAO.StudentDAO;


public class CourseApplication 
{
	static Session session=null;
	static int id;
	static String courseName;
	static String courseDesc;
	static int duration;
	static String facultyName;
	
	public static void main(String[] args) 
	{
		SessionFactory sessionFactory =null;
		StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.getMetadataBuilder().build();
		sessionFactory= metadata.getSessionFactoryBuilder().build();
		session = sessionFactory.openSession();
		
		int choice=0;
		Scanner sc= new Scanner(System.in);
		do
		{
			System.out.println("1.Add a Course"
					+ "\n2.Update a Course"
					+ "\n3.Delete a Course"
					+ "\n4.Show a Course"
					+ "\n5.Show all Students"
					+ "\n6.Delete Student"
					+ "\n7.Show all Courses"
					+ "\n0.Exit"
					+ "\nEnter Your Choice ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				sc.nextLine();
				System.out.println("Enter the id : ");
				id=sc.nextInt();
				System.out.println("Enter the Course Name : ");
				courseName=sc.nextLine();
				System.out.println("Enter the Course Desciption : ");
				courseDesc=sc.nextLine();
				System.out.println("Enter the Duration : ");
				duration=sc.nextInt();
				System.out.println("Enter the Faculty Name : ");
				facultyName=sc.next();
				CourseDAO.AddCourse( session, id, courseName, courseDesc, duration, facultyName);
				System.out.println(".............. Record Inserted ..............");
				break;
			case 2:
				System.out.println("Enter the Course Name to Update");
				courseName=sc.next();
				System.out.println("Enter the ID ");
				id=sc.nextInt();
				CourseDAO.UpdateCourse(session,id,courseName);
				System.out.println(".............. Record Updated ..............");
				break;
			case 3:
				System.out.println("Enter the ID to Delete a Record");
				id=sc.nextInt();
				CourseDAO.DeleteCourse(session, id);
				System.out.println(".............. Record Deleted ..............");
				break;
			case 4:
				System.out.println("............... Details ...............");
				System.out.println("Enter the ID to Show the Details");
				id=sc.nextInt();
				CourseDAO.ShowCourse(session , id);
				System.out.println(".......................................");
				break;
			case 5:
				System.out.println("............... Details ...............");
				StudentDAO.ShowStudents(session);
				System.out.println(".......................................");
				break;
			case 6:
				System.out.println("Enter the ID to Delete a Record");
				id=sc.nextInt();
				StudentDAO.DeleteStudent(session, id);
				System.out.println(".............. Record Deleted ..............");
				break;
			case 7:
				System.out.println("............... Details ...............");
				CourseDAO.ShowAllCourses(session);
				System.out.println(".......................................");
				break;
			default :
				System.out.println("Invalid Choice ........................");
			}
		}while(true);
	
	} // end of main 
	
}
