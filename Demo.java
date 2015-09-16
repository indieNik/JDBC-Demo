package com.psl.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Scanner;

public class JdbcDemo {
	public static void main(String[] args) {

		try {
			Class.forName("com.mysql.jdbc.Driver"); // To load the Explicit
													// Classe "Driver"
			System.out.println("Driver Loaded!");

			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/demo", "root", "root"); //
			System.out.println("Connected!");

			
			DatabaseMetaData db = con.getMetaData();
			
			System.out.println("Version: " + db.getDriverVersion() + "\nName: " + db.getDriverName());
			
			PreparedStatement pstmt = con.prepareStatement("select * from emp");
			
//			ResultSet rs = pstmt.executeQuery();
			
			ResultSetMetaData rsdb = pstmt.getMetaData();
			
			int count = rsdb.getColumnCount();
			
			for (int i = 1; i < count; i++) {
				System.out.println(rsdb.getColumnName(i));
			}
			
//			Statement stmt = con.createStatement();
//			 stmt.execute("create table emp(id int(10), name varchar(20))");
//			 Only Once
//			 System.out.println("Table Created!");

//			stmt.execute("insert into emp value(103,'Mali')");
//			System.out.println("Inserted!");

//			ResultSet rs = stmt.executeQuery("select * from emp");

//			while (rs.next()) {
//				System.out.println(rs.getInt(1) + " " + rs.getString(2));
//			}

//			System.out.println("Executed! Closing the Statement!");
//			stmt.close();
			
/*			CallableStatement cst = con.prepareCall("call MyProcedure3(?,?)");
			
//			PreparedStatement pstmt = con.prepareStatement("insert into emp value(?, ?)");
			
			Scanner sc = new Scanner(System.in);
			
			System.out.println("Enter ID: ");
			int id = sc.nextInt();
			
//			System.out.println("Enter Name: ");
//			String name = sc.next();
			
			cst.setInt(1, id);
//			cst.setString(2, name); // Provide the parameter values

			cst.registerOutParameter(2, Types.VARCHAR); 
			
			cst.execute();
			
			ResultSet rs = cst.executeQuery("select * from emp");
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " " + rs.getString(2));
			}

			System.out.println("Name From Database: " + cst.getString(2));
			
			System.out.println("Executed! Closing the Prepared Statement!");
			cst.close();
*/			
			System.out.println("Closing the Connection!");
			con.close();

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
