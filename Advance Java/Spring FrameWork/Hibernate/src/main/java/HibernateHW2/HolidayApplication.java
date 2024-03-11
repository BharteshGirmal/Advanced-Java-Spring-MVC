package HibernateHW2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import DAO.HolidayDAO;

public class HolidayApplication 
{
	public static void main(String[] args)
	{
		SessionFactory sessionFactory =null;
		StandardServiceRegistry registry =  new StandardServiceRegistryBuilder().configure().build();
		MetadataSources sources = new MetadataSources(registry);
		Metadata metadata = sources.getMetadataBuilder().build();
		sessionFactory= metadata.getSessionFactoryBuilder().build();
		Session session = sessionFactory.openSession();
		
		HolidayDAO dao=new HolidayDAO();
		dao.insert(session, 1, "Diwali","25-10-2022" );
		dao.insert(session, 2, "Ganesh-Chaturthi","31-07-2022" );
		dao.insert(session, 3, "Dashera","5-10-2022" );
		System.out.println("Record Inserted .............");
		
	    //dao.update(session,1,"Padava");
        //System.out.println("Record Updated...");
        
        //dao.delete(session,1);
       // System.out.println("Record Deleted...");
        
        //dao.select(session);
	}

}
