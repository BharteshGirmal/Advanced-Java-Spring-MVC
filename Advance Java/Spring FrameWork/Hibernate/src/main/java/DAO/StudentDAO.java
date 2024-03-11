package DAO;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import Entities.StudentEntity;

public class StudentDAO 
{
	public static void ShowStudents(Session session)
	{
		Query<StudentEntity> HQL=session.createQuery("from Entities.StudentEntity");
		HQL.list().stream().forEach((row)->{System.out.println(row);});
	}
	
	public static void DeleteStudent(Session session,int id)
	{
		Transaction tx=session.beginTransaction();
		StudentEntity DBrow=session.get(StudentEntity.class,id);
		session.delete(DBrow);
		tx.commit();
	}

}
