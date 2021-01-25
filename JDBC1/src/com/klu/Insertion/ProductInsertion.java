package com.klu.Insertion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Connections.DBUtil;
import com.klu.Bean.ProductBean;
public class ProductInsertion {
	Scanner s = new Scanner(System.in);
	   public int ItemInsert(ProductBean Products)throws ClassNotFoundException, SQLException
	   {
		   Connection con=DBUtil.DBConnection();
		   PreparedStatement ps=con.prepareStatement("insert into Productdetails values(?,?,?)"); 
		   ps.setInt(1,Products.getitemid());
		   ps.setString(2,Products.getitemName());
		   ps.setInt(3,Products.getitemcost());
		   int i = ps.executeUpdate();
		   con.close();
		   return i;
	   }
	  
	   public void StudentDisplay(ProductBean Products)throws ClassNotFoundException, SQLException
	   {
		   Connection con=DBUtil.DBConnection();
		   PreparedStatement stmt=con.prepareStatement("select * from Productdetails");  
		   ResultSet rs=stmt.executeQuery();  
		   while(rs.next()){  
		   System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getInt(3));
		   }
		   con.close();
		   }
	   public int TotalCost() throws  ClassNotFoundException, SQLException
	   {
		   Connection con=DBUtil.DBConnection();
		   PreparedStatement ps=con.prepareStatement("select  sum(itemcost) from Productdetails");  
		   ResultSet rs=ps.executeQuery();  
		   while(rs.next()){  
		   System.out.println("Total itemcost of all items: "+rs.getInt(1)+" Rupees");
		   }
		   int i = ps.executeUpdate();
		   con.close();
		   return i;
		   }
	   
	}
	


