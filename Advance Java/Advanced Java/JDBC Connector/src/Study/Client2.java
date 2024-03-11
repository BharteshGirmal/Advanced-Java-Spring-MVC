package Study;

import java.sql.ResultSet;

public class Client2
{
	public static void main(String[] args) {
		
		DAO obj= new DAO();
		ResultSet rs=obj.GetRows("select * from Product1");
		obj.ShowResultSet(rs);
		
		// Show all the records which having cost more than 200
		ResultSet rs1=obj.GetRows("select * from Product1 where price>200");
		obj.ShowResultSet(rs1);
		System.out.println("Inserting a product");
		
		obj.AddProduct(111, "HardDisk", 222);
		obj.ShowResultSet(obj.GetRows("select * from Product1"));
		
		obj.UpdatCost(122, 12);
		obj.ShowResultSet(obj.GetRows("select * from Product1"));
	}

}
