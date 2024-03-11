package Study;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionEx 
{

	public static void main(String[] args) throws SQLException
	{
		DAO obj= new DAO();
		Connection con=obj.MyGetConnection();
		con.setAutoCommit(false);
		PreparedStatement Pstmt=con.prepareStatement("update Account set Balance=? where AccNo=?");
		try
		{
		Pstmt.setInt(1, 5000);
		Pstmt.setString(2, "A");
		Pstmt.executeUpdate();
		
		Pstmt.setInt(1, 7000);
		Pstmt.setString(2, "B");

		Pstmt.executeUpdate();
		                                      
		System.out.println("Sucessded................");
		con.commit();
		}
		catch(SQLException e)
		{
			System.out.println("Failed................");
			con.rollback();
		}
		
	}

}
