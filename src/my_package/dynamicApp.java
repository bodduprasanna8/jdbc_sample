package my_package;

import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class dynamicApp {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String username = "root";
	private static final String password = "root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		int choice;
		do {
			Scanner src = new Scanner(System.in);
			System.out.println("choose your choice");
			DisplayMenu();
			choice=Integer.parseInt(src.next());
			switch(choice) {
			case 1:
				createDatabase();
				break;
			case 2:
				dropDatabase();
				break;
			case 3:
				dataInsertion();
				break;
			case 4:
				deletebyId();
				break;
			case 5:
				updateData();
				break;
			case 6:
				getbyId();
				break;
			case 7:
				getAll();
				break;
			case 8:
				login();
				break;
				
			case 9:
				System.exit(0);
				break;
				
			default:
				System.out.println("invalid");
				break;
				
			}
			
		}while(choice>0);
	}

	private static void login() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter db name");
			String url="jdbc:mysql://localhost:3307/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql="select * from "+src.next()+" where order_id=? and order_name=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter order id");
			pmst.setInt(1,src.nextInt());
			System.out.println("enter order name");
			pmst.setString(2,src.next());
			ResultSet rs = pmst.executeQuery();
			if (rs.next()) {
				System.out.println("login successful");
			}
			else {
				System.out.println("login unsuccessful");
			}
			pmst.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void getAll() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter db name");
			String url="jdbc:mysql://localhost:3307/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql="select * from "+src.next();
			pmst=conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("Order Id : "+rs.getInt("order_id"));
				System.out.println("Order name : "+rs.getString("order_name"));
				System.out.println("Order pincode : "+rs.getString("order_pincode"));
				System.out.println("Order address : "+rs.getString("order_address"));
			}
			pmst.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

	private static void getbyId() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter db name");
			String url="jdbc:mysql://localhost:3307/"+src.next();
			conn=DriverManager.getConnection(url, username, password);
			System.out.println("enter table name");
			String sql="select * from "+src.next()+" where order_id=?";
			pmst=conn.prepareStatement(sql);
			System.out.println("enter order id");
			pmst.setInt(1,src.nextInt());
			ResultSet rs = pmst.executeQuery();
			while (rs.next()) {
				System.out.println("Order Id : "+rs.getInt("order_id"));
				System.out.println("Order name : "+rs.getString("order_name"));
				System.out.println("Order pincode : "+rs.getString("order_pincode"));
				System.out.println("Order address : "+rs.getString("order_address"));
			}
			pmst.close();
			conn.close();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
				
	}

	private static void updateData() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database");
			String url = "jdbc:mysql://localhost:3307/"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter table name:");
			String sql="update "+src.next()+"set order_name=?,order_pincode=?,order_address=? where order_id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter order name: ");
			pmst.setString(1, src.next());
			System.out.println("enter order pincode: ");
			pmst.setString(2, src.next());
			System.out.println("enter order address: ");
			pmst.setString(3, src.next());
			System.out.println("enter order Id: ");
			pmst.setInt(4, src.nextInt());
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("Data inserted");
			}
			else {
				System.out.println("Data is not inserted");
			}
			pmst.close();
			conn.close();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void deletebyId() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database");
			String url = "jdbc:mysql://localhost:3307/"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter table name:");
			String sql="delete from "+src.next()+" where order_id=?";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter order Id: ");
			pmst.setInt(1, src.nextInt());
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("Data deleted");
			}
			else {
				System.out.println("Data is not deleted");
			}
			pmst.close();
			conn.close();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		 
		
	}

	private static void dataInsertion() {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			System.out.println("enter database");
			String url = "jdbc:mysql://localhost:3307/"+src.next();
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter table name:");
			String sql="insert into "+src.next()+"(order_id,order_name,order_pincode,order_address) values(?,?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter order Id: ");
			pmst.setInt(1, src.nextInt());
			System.out.println("enter order name: ");
			pmst.setString(2, src.next());
			System.out.println("enter order pincode: ");
			pmst.setString(3, src.next());
			System.out.println("enter order address: ");
			pmst.setString(4, src.next());
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("Data inserted");
			}
			else {
				System.out.println("Data is not inserted");
			}
			pmst.close();
			conn.close();
	
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void dropDatabase() {

		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3307/";
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter database name: ");
			String sql="drop database "+src.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i==0) {
				System.out.println("Database drop");
			}
			else {
				System.out.println("Database not drop");
			}
			pmst.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void createDatabase() {
		try {
			
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			String url = "jdbc:mysql://localhost:3307/";
			conn = DriverManager.getConnection(url,username,password);
			System.out.println("enter database name: ");
			String sql="create database "+src.next();
			pmst = conn.prepareStatement(sql);
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("Database created");
			}
			else {
				System.out.println("Database not created");
			}
			pmst.close();
			conn.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void DisplayMenu() {
		System.out.println("\t1.create db");
		System.out.println("\t2.drop db");
		System.out.println("\t3.data insertion");
		System.out.println("\t4.delete by email");
		System.out.println("\t5.update data");
		System.out.println("\t6.get by email");
		System.out.println("\t7.get all");
		System.out.println("\t8.login");
		System.out.println("\t9.exit");
	}

}
