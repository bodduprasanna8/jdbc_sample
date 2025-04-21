package my_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dbdrop {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3307/";
	private static final String username = "root";
	private static final String password = "root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
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
			src.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
