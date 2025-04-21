package my_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertion {
	private static final String driver = "com.mysql.cj.jdbc.Driver";
	private static final String url = "jdbc:mysql://localhost:3307/sample";
	private static final String username = "root";
	private static final String password = "root";
	private static PreparedStatement pmst;
	private static Connection conn;
	public static void main(String[] args) {
		try {
			Scanner src=new Scanner(System.in);
			Class.forName(driver);
			conn = DriverManager.getConnection(url,username,password);
			String sql="insert into giet(id,name,email) values(?,?,?)";
			pmst = conn.prepareStatement(sql);
			System.out.println("enter Id: ");
			pmst.setInt(1, src.nextInt());
			System.out.println("enter name: ");
			pmst.setString(2, src.next());
			System.out.println("enter email: ");
			pmst.setString(3, src.next());
			int i = pmst.executeUpdate();
			if (i>0) {
				System.out.println("Data inserted");
			}
			else {
				System.out.println("Data is not inserted");
			}
			pmst.close();
			conn.close();
			src.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

