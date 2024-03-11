package DAO;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import Entities.CourseEntity;

public class CourseDAO 
{
	public static void AddCourse( Session session,int id,String courseName,String courseDesc,int duration,String facultyName)
	{
		CourseEntity obj=new CourseEntity(id, courseName, courseDesc, duration, facultyName);
		Transaction tx =session.beginTransaction();
		session.save(obj);
		tx.commit();
	}
	
	public static void UpdateCourse(Session session, int id , String name)
	{
		Transaction tx =session.beginTransaction();
		CourseEntity DBrow= session.get(CourseEntity.class, id);
		// .get ====> select * from table 
		DBrow.setCourseName(name);// update the value of the first record 
		tx.commit();
	}
	public static void DeleteCourse( Session session ,int id )
	{
		Transaction tx =session.beginTransaction();
		CourseEntity DBrow= session.get(CourseEntity.class, id);
		session.delete(DBrow);
		tx.commit();
	}
	public static void ShowCourse(Session session , int id )
	{
		Query<CourseEntity> HQL=session.createQuery("from Entities.CourseEntity where id = '"+id+"' ");
		HQL.list().stream().forEach((row)->{System.out.println(row);});
	}
	
	public static void ShowAllCourses(Session session )
	{
		Query<CourseEntity> HQL=session.createQuery("from Entities.CourseEntity");
		HQL.list().stream().forEach((row)->{System.out.println(row);});
	}
}
