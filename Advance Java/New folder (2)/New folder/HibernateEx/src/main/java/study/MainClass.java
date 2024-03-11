package study;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import study.entity.StudentEntity1;

public class MainClass
{
	static Session session = null;
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
             
             //insertEx();
             //updateEx();
             //deleteEx();
             selectEx();
	}
	
	public static void insertEx()
	{
		StudentEntity1 obj = new StudentEntity1(1,201,"AAA","BBB");
        org.hibernate.Transaction tx = session.beginTransaction();
        session.save(obj);
        tx.commit();
	}
	public static void updateEx()
	{
		org.hibernate.Transaction tx = session.beginTransaction();
		StudentEntity1 dbRow = session.get(StudentEntity1.class, 1);
	    dbRow.setRollNumber(205);
	    session.save(dbRow);
        tx.commit();
	}
	public static void deleteEx()
	{
		org.hibernate.Transaction tx = session.beginTransaction();
		StudentEntity1 dbRow = session.get(StudentEntity1.class, 1);
	    session.delete(dbRow);
        tx.commit();
	}
	public static void selectEx()
	{
		//we are firing HQL = hibernate Query Lang
		Query<StudentEntity1> q = session.createQuery("from study.entity.StudentEntity1");
	    q.list().stream().forEach((row)->{System.out.println(row);});
	}
}