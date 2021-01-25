package com.klu.main;

import java.sql.SQLException;
import java.util.Scanner;

import com.klu.Bean.ProductBean;
import com.klu.Insertion.ProductInsertion;
import java.util.Scanner;
public class ProductMain {
	public static void main(String[] args)throws ClassNotFoundException,SQLException {
		Scanner s =new Scanner(System.in);
		
		ProductInsertion si=new ProductInsertion();
		ProductBean sb=new ProductBean();
		while(true) {
			System.out.println("\n1.insert into table \n2.display the details \n3.Total itemcost ");
			int ch = s.nextInt();
		switch(ch) {
		case 1:
			System.out.println("enter itemid,itemName,itemcost");
			int itemid=s.nextInt();
			String itemName=s.next();
			int itemcost=s.nextInt();
			
			sb.setitemid(itemid);
			sb.setitemName(itemName);
			sb.setitemcost(itemcost);
			int i=si.ItemInsert(sb);
			if(i>0)
				System.out.println("Insertion is successfull");
			else
				System.out.println("fail");
			break;
		case 2:
			si.StudentDisplay(sb);
			break;
		case 3:
			int total=si.TotalCost();
			if(total>0) {
				System.out.println("Total itemcost can be displayed");
			}
				else {
					System.out.println("Total itemcost can't be displayed");
			}
		}
		}
	}
}
