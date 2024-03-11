package Hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entities.StudentEntity;

public class HibernateApplication 
{
	static Session session=null;
	public static void main(String[] args) 
	{
		SessionFactory sessionFactory =null;
		StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		// Create MetadataSources
		MetadataSources sources = new MetadataSources(registry);
		// Create Metadata
		Metadata metadata = sources.getMetadataBuilder().build();
		// Create SessionFactory
		sessionFactory= metadata.getSessionFactoryBuilder().build();

		Session session = sessionFactory.openSession();
		Insert();
	}
	
	public static void Insert()
	{
		StudentEntity obj= new StudentEntity(1,125,"C Programming","Denies Ritchie");
		Transaction tx =session.beginTransaction();
		session.save(obj);
		tx.commit();
	}
	
	public static void Update()
	{
		Transaction tx =session.beginTransaction();
		StudentEntity DBrow= session.get(StudentEntity.class, 1);
		// .get ====> select * from table 
		DBrow.setRollNumber(126); // update the value of the first record 
		tx.commit();
	}
	
	public static void Delete()
	{
		Transaction tx=session.beginTransaction();
		StudentEntity DBrow=session.get(StudentEntity.class,1);
		session.delete(DBrow);
		tx.commit();
	}
	
	public static void SelectAll()
	{
		// Here we have to fire a HQL(Hibernate Query Language) Instead
		Query<StudentEntity> HQL=session.createQuery("from Hibernate.StudentEntity");
		HQL.list().stream().forEach((row)->{System.out.println(row);});
	}
}
