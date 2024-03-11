package study.dao;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import study.entity.HolidayEntity;

public class HolidayDAO 
{
	public void insert(Session session, int i, String string, String string1)
	{
		Transaction tx = session.beginTransaction();
		HolidayEntity h = new HolidayEntity(i, string, string1);
		session.save(h);
		tx.commit();
	}

	public void update(Session session, int i, String string) 
	{
		Transaction tx = session.beginTransaction();
		HolidayEntity dbRow = session.get(HolidayEntity.class, i);
		dbRow.setNameOfHoliday(string);
		session.save(dbRow);
		tx.commit();
	}

	public void delete(Session session, int i)
	{
		Transaction tx = session.beginTransaction();
		HolidayEntity dbRow = session.get(HolidayEntity.class, i);
		session.delete(dbRow);
		tx.commit();
	}

	public void select(Session session)
	{
		Query<HolidayEntity> q = session.createQuery("from study.entity.HolidayEntity");
		q.list().stream().forEach((row)->{System.out.println(row);});
	}
}