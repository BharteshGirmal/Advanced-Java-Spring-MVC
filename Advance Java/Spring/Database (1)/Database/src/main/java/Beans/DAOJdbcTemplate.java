package Beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import DataObject.AppoinmentDO;

@Component
public class DAOJdbcTemplate 
{
	@Autowired
	private JdbcTemplate template; // injecting  ...
	
	public void Insert(int id , String name , int price)
	{
		template.update("insert into Product1 values(?,?,?)", id,name,price);
	}
	
	public void addAppoint(String uname,String date,String purpose,String reason,String time)
	{
		template.update("insert into appoinment values(?,?,?,?,?)",uname,date,purpose,reason,time);
	}
	public void updateAppoint(String uname,String purpose)
	{
		template.update("update appoinment set purpose=? where uname=?",purpose,uname);
	}

	public List<AppoinmentDO> showAppoint(String name)
	{
		List<AppoinmentDO> list =  template.query("select * from appoinment where uname='"+name+"'",(rs,rownum)->{ return new AppoinmentDO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));});
	    return list;
	}
	
	public List<AppoinmentDO> showAllAppoint()
	{
		List<AppoinmentDO> list =  template.query("select * from appo1",(rs,rownum)->{ return new AppoinmentDO(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));});
	    return list;
	}
}
