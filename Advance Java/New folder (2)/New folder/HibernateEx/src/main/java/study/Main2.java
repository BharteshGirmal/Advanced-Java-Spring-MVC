package study;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import study.dao.CourseDAO;

public class Main2
{
	public static void main(String[] args) 
	{
					//we configure hibernate ORM
					SessionFactory sessionFactory =null;
				
					//read xml
					StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		             // Create MetadataSources
		             MetadataSources sources = new MetadataSources(registry);
		            
		             // Create Metadata
		             //using xml and entity create DDL
		             Metadata metadata = sources.getMetadataBuilder().build();
		            
		             // Create SessionFactory
		             //get factory
		             sessionFactory= metadata.getSessionFactoryBuilder().build();
		        
		             //acquired session(interface between javacode and hibernate)
		             
		             Session session = null;
		             session = sessionFactory.openSession();
		  CourseDAO dao = new CourseDAO();           
		 Scanner sc = new Scanner(System.in);            
		 int ch;           
		 do
		 {
			System.out.println("1.Add Course\n"
					         + "2.Update Course\n"
					         + "3.Delete Course\n"
					         + "4.Show A Course\n"
					         + "5.Show All Course\n"
					         + "6.Quit\n"); 
			System.out.println("Enter Your Choice:");
			ch = sc.nextInt();
			
			switch(ch)
			{
				case 1:{ 
					       System.out.println("Enter ID:");
					       int id = sc.nextInt();
					       System.out.println("Enter CourseName:");
					       String cname = sc.next();
					       System.out.println("Enter CourseDescription:");
					       String cdesc = sc.next();
					       System.out.println("Enter Duration:");
					       int dur = sc.nextInt();
					       System.out.println("Enter FacultyName:");
					       String fac = sc.next();
					       
					       dao.dur(session,id,cname,cdesc,dur,fac);
					       System.out.println("Record Insered...");
					       break;
				}
				case 2:{
					       System.out.println("Enter ID:");
					       int id = sc.nextInt();
					       System.out.println("Enter NewFacultyName");
					       String nfac = sc.next();
					       dao.update(session,id,nfac);
					       System.out.println("Record Updated...");
					       break;
				}
				case 3:{ 
					       System.out.println("Enter ID:");
					       int id= sc.nextInt();
					       dao.delete(session,id);
					       System.out.println("Record Deleted...");
					       break;
				}
				case 4:{
						   System.out.println("Enter ID:");
						   int id= sc.nextInt();
						   dao.show(session,id);
					       break;
				}
				case 5:{
					       dao.showAll(session);
					       break;
				}
				case 6:{
					       break;
				}
				default:{
					       System.out.println("Please Enter Correct Choice:");
					       break;
				}
			}
			if(ch==6)
			{
				System.out.println("Quit");
				break;
			}
		 }
		 while(true);
	}
}