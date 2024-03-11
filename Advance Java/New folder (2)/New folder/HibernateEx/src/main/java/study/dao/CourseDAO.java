package study.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import study.entity.CourseEntity1;

public class CourseDAO 
{
	public void dur(Session session, int id, String cname, String cdesc, int dur, String fac)
	{
		Transaction tx = session.beginTransaction();
		CourseEntity1 c1 = new CourseEntity1(id,cname,cdesc,dur,fac);
		session.save(c1);
		tx.commit();
	}

	public void update(Session session, int id, String nfac) 
	{
		Transaction tx = session.beginTransaction();
		CourseEntity1 dbRow = session.get(CourseEntity1.class, id);
		dbRow.setFacultyName(nfac);
		session.save(dbRow);
		tx.commit();
	}

	public void delete(Session session, int id)
	{
		Transaction tx = session.beginTransaction();
		CourseEntity1 dbRow = session.get(CourseEntity1.class, id);
		session.delete(dbRow);
		tx.commit();
	}

	public void show(Session session, int id) 
	{
		Query<CourseEntity1> q = session.createQuery("from study.entity.CourseEntity1 where id = '"+id+"' ");
		 q.list().stream().forEach((row)->{System.out.println(row);});
	}

	public void showAll(Session session) 
	{
		Query<CourseEntity1> q = session.createQuery("from study.entity.CourseEntity1");
	    q.list().stream().forEach((row)->{System.out.println(row);});
	}
}
