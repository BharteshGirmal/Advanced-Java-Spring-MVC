package Beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DAOBean
{
	@Autowired
	private DataSource DS;
	
	public void Insert(int id , String name , int price)
	{
		try {
			Connection con=DS.getConnection();
			PreparedStatement Pstmt =con.prepareStatement("insert into Product1 values(?,?,?)");
			Pstmt.setInt(1, id);
			Pstmt.setString(2, name);
			Pstmt.setInt(3, price);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
