package study;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import study.dao.HolidayDAO;

public class UserOfHoliday 
{
    static Session session=null;
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
         session = sessionFactory.openSession();
         
         HolidayDAO dao = new HolidayDAO();
         
         dao.insert(session,1,"Diwali","02-05-2022");
         System.out.println("Record Inserted...");
         
         //dao.update(session,1,"Padava");
         System.out.println("Record Updated...");
         
         //dao.delete(session,1);
         System.out.println("Record Deleted...");
         
         //dao.select(session);
	}
}