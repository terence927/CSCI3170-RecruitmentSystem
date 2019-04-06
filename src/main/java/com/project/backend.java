package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class backend {
	public static void createTables() {
		Connection con = null;
		con = dbCon.getConnection();
		try {
			Statement stmt = con.createStatement();
			//stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0;");
		    String sql1 = "CREATE TABLE Position (\r\n" + 
		    		"\r\n" + 
		    		"  Position_ID  varchar(6) primary key not null,\r\n" + 
		    		"\r\n" + 
		    		"  Position_Title varchar(30) not null,\r\n" + 
		    		"\r\n" + 
		    		"  Salary integer,\r\n" + 
		    		"  \r\n" + 
		    		"  Experience integer,\r\n" + 
		    		"  \r\n" + 
		    		"  Employer_ID varchar(6) not null,\r\n" + 
		    		"  \r\n" + 
		    		"  Status BOOLEAN" + 
		    		");";
		    String sql2 = "CREATE TABLE Employee (\r\n" + 
		    		"\r\n" + 
		    		"  Employee_ID  varchar(6) primary key not null,\r\n" + 
		    		"\r\n" + 
		    		"  Name varchar(30) not null,\r\n" + 
		    		"\r\n" + 
		    		"  Expected_Salary integer,\r\n" + 
		    		"  \r\n" + 
		    		"  Experience integer,\r\n" + 
		    		"  \r\n" + 
		    		"  Skills varchar(50) not null\r\n" + 
		    		"  \r\n" + 
		    		");";
		    String sql3 = "CREATE TABLE Company (\r\n" + 
		    		"\r\n" + 
		    		"  Company   varchar(30) not null,\r\n" + 
		    		"\r\n" + 
		    		"  Size integer,\r\n" + 
		    		"  \r\n" + 
		    		"  Founded varchar(4) not null\r\n" + 
		    		"  \r\n" + 
		    		");";
		    String sql4 = "CREATE TABLE Employer (\r\n" + 
		    		"\r\n" + 
		    		"  Employer_ID  varchar(6) primary key not null,\r\n" + 
		    		"\r\n" + 
		    		"  Name varchar(30) not null,\r\n" + 
		    		"\r\n" + 
		    		"  Company varchar(30) not null\r\n" + 
		    		"  \r\n" + 
		    		");";
		    String sql5 = "CREATE TABLE Employment_History (\r\n" + 
		    		"\r\n" + 
		    		"  Employee_ID  varchar(6) not null,\r\n" + 
		    		"\r\n" + 
		    		"  Company varchar(30) not null,\r\n" + 
		    		"  \r\n" + 
		    		"  Position_ID varchar(6) primary key not null,\r\n" + 
		    		"  \r\n" + 
		    		"  Start Datetime,\r\n" + 
		    		"  \r\n" + 
		    		"  End Datetime\r\n" + 
		    		");";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.executeUpdate(sql5);
			//stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=1;");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public static void deleteTables() {

		Connection con = null;
		con = dbCon.getConnection();
		try {
			Statement stmt = con.createStatement();
			//stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=0;");
			stmt.executeUpdate("DROP TABLE Company;");
			stmt.executeUpdate("DROP TABLE Employee;");
			stmt.executeUpdate("DROP TABLE Employer;");
			stmt.executeUpdate("DROP TABLE Employment_History;");
			stmt.executeUpdate("DROP TABLE Position;");
			//stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=1;");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public static void load_data(String path) {

        final String dir = System.getProperty("user.dir");
        System.out.println("current dir = " + dir);
	    try
	    {
	        BufferedReader br = new BufferedReader(new FileReader(dir+"/"+path+"/employee.csv"));
			Connection con = null;
			con = dbCon.getConnection();
	        String line = null;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split(",");
	            String a = tmp[0];
	            String b = tmp[1];
	            Integer c = Integer.parseInt(tmp[2]);
	            Integer d = Integer.parseInt(tmp[3]);
	            String e = tmp[4];
				try {
		            String sql ="INSERT INTO Employee (Employee_ID,Name,Expected_Salary,Experience,Skills) values (?,?,?,?,?);";
					PreparedStatement stmt=con.prepareStatement(sql);  
					stmt.setString(1,a);
					stmt.setString(2,b);  
					stmt.setInt(3,c);
					stmt.setInt(4,d);
					stmt.setString(5,e);
					stmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }
	        br.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    try
	    {
	        BufferedReader br = new BufferedReader(new FileReader(dir+"/"+path+"/employer.csv"));
			Connection con = null;
			con = dbCon.getConnection();
	        String line = null;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split(",");
	            String a = tmp[0];
	            String b = tmp[1];
	            String c = tmp[2];
				try {
		            String sql ="INSERT INTO Employer (Employer_ID,Name,Company) values (?,?,?);";
					PreparedStatement stmt=con.prepareStatement(sql);  
					stmt.setString(1,a);
					stmt.setString(2,b);  
					stmt.setString(3,c);
					stmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }
	        br.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    try
	    {
	        BufferedReader br = new BufferedReader(new FileReader(dir+"/"+path+"/position.csv"));
			Connection con = null;
			con = dbCon.getConnection();
	        String line = null;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split(",");
	            String a = tmp[0];
	            String b = tmp[1];
	            Integer c = Integer.parseInt(tmp[2]);
	            Integer d = Integer.parseInt(tmp[3]);
	            String e = tmp[4];
	            String f = tmp[5];
				try {
		            String sql ="INSERT INTO Position (Position_ID,Position_Title,Salary,Experience,Employer_ID,Status) values (?,?,?,?,?,?);";
					PreparedStatement stmt=con.prepareStatement(sql);  
					stmt.setString(1,a);
					stmt.setString(2,b);  
					stmt.setInt(3,c);
					stmt.setInt(4,d);
					stmt.setString(5,e);
		            if (f.equals("True") || f.equals("true")) {
		            	stmt.setBoolean(6,true);
		            }
		            else {
		            	stmt.setBoolean(6,false);
		            }
					stmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }
	        br.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    try
	    {
	        BufferedReader br = new BufferedReader(new FileReader(dir+"/"+path+"/history.csv"));
			Connection con = null;
			con = dbCon.getConnection();
	        String line = null;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split(",");
	            String a = tmp[0];
	            String b = tmp[1];
	            String c = tmp[2];
	            String d = tmp[3];
	            String e = tmp[4];
				try {
		            String sql ="INSERT INTO Employment_History (Employee_ID,Company,Position_ID,Start,End) values (?,?,?,?,?);";
					PreparedStatement stmt=con.prepareStatement(sql);  
					stmt.setString(1,a);
					stmt.setString(2,b);  
					stmt.setString(3,c);
					stmt.setString(4,d);
					if (e.equals("NULL"))	
						stmt.setNull(5,java.sql.Types.DATE);
					else
						stmt.setString(5,e);
					stmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }
	        br.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }
	    try
	    {
	        BufferedReader br = new BufferedReader(new FileReader(dir+"/"+path+"/company.csv"));
			Connection con = null;
			con = dbCon.getConnection();
	        String line = null;
	        while ((line = br.readLine()) != null)
	        {
	            String tmp[] = line.split(",");
	            String a = tmp[0];
	            Integer b = Integer.parseInt(tmp[1]);
	            String c = tmp[2];
				try {
		            String sql ="INSERT INTO Company (Company,Size,Founded) values (?,?,?);";
					PreparedStatement stmt=con.prepareStatement(sql);  
					stmt.setString(1,a);
					stmt.setInt(2,b);
					stmt.setString(3,c);
					stmt.executeUpdate();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
	        }
	        br.close();

	    }
	    catch (IOException e)
	    {
	        e.printStackTrace();
	    }

	}
	public static void check_data() {
		Connection con = null;
		ResultSet rs = null;
		con = dbCon.getConnection();
		try {
			String sql1 = "SELECT COUNT(*) FROM Employee;";
			String sql2 = "SELECT COUNT(*) FROM Company;";
			String sql3 = "SELECT COUNT(*) FROM Employer;";
			String sql4 = "SELECT COUNT(*) FROM Position;";
			String sql5 = "SELECT COUNT(*) FROM Employment_History;";
			Statement stmt=con.createStatement();
			rs = stmt.executeQuery(sql1);rs.next();
			System.out.println("Employee: "+rs.getString(1));
			rs = stmt.executeQuery(sql2);rs.next();
			System.out.println("Company: "+rs.getString(1));
			rs = stmt.executeQuery(sql3);rs.next();
			System.out.println("Employer: "+rs.getString(1));
			rs = stmt.executeQuery(sql4);rs.next();
			System.out.println("Position: "+rs.getString(1));
			rs = stmt.executeQuery(sql5);rs.next();
			System.out.println("Employment_History: "+rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	

}
