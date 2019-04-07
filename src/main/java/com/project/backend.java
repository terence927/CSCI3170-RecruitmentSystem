package com.project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.*;
import java.util.Random;
import java.util.Scanner;

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
		    String sql6 = "CREATE TABLE Marked (\r\n" + 
		    		"\r\n" + 
		    		"  Position_ID  varchar(6) not null,\r\n" + 
		    		"  \r\n" + 
		    		"  Employee_ID varchar(6) not null,\r\n" + 
		    		"  \r\n" + 
		    		"  Status BOOLEAN\r\n" + 
		    		"  \r\n" + 
		    		");";
			stmt.executeUpdate(sql1);
			stmt.executeUpdate(sql2);
			stmt.executeUpdate(sql3);
			stmt.executeUpdate(sql4);
			stmt.executeUpdate(sql5);
			stmt.executeUpdate(sql6);
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
			stmt.executeUpdate("DROP TABLE Marked;");
			//stmt.executeUpdate("SET FOREIGN_KEY_CHECKS=1;");
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	public static void load_data(String path) {

        final String dir = System.getProperty("user.dir");
        //System.out.println("current dir = " + dir);
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
			String sql6 = "SELECT COUNT(*) FROM Marked;";
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
			rs = stmt.executeQuery(sql6);rs.next();
			System.out.println("Marked: "+rs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	public static void show_pos(String id) {
		Connection con = null;
		con = dbCon.getConnection();
		ResultSet rs = null;
		try {
			String sql1 = "SELECT Skills FROM Employee WHERE Employee_ID = ?;";
			PreparedStatement stmt=con.prepareStatement(sql1);  
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			String skills = "";
			while(rs.next())
				 skills = rs.getString(1);
			String tmp[] = skills.split(";");
			String tmp2 = "";
			for (int i = 0;i<tmp.length;i++)
            	tmp2+="?,";
			tmp2 = tmp2.substring(0,tmp2.length()-1);
			//System.out.println(tmp2);
			String sql2 = "SELECT Position_ID, Position_Title, Salary, C.Company, Size, Founded \r\n" + 
					"FROM Position P, Employer E, Company C, Employee A\r\n" + 
					"WHERE A.Employee_ID = ? AND " +
					"P.Employer_ID=E.Employer_ID AND \r\n" + 
					"E.Company=C.Company AND \r\n" + 
					"P.Status=TRUE AND \r\n" + 
					"P.Position_Title IN ("+ tmp2 + ") AND\r\n" + 
					"P.Salary>=A.Expected_Salary AND \r\n" + 
					"A.Experience >= P.Experience;";
			stmt=con.prepareStatement(sql2);  
			stmt.setString(1,id);
			for (int i = 0;i<tmp.length;i++)
				stmt.setString(i+2,tmp[i]);
			rs = stmt.executeQuery();
			System.out.println("Position_ID, Position_Title, Salary, Company, Size, Founded");
			while (rs.next()) {
				for (int i=1;i<7;i++)
					System.out.print(rs.getString(i)+" ");
				System.out.println();
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}		
	public static void check_avgtime(String id) {
		Connection con = null;
		con = dbCon.getConnection();
		ResultSet rs = null;
		try {
			String sql1 = "SELECT datediff(EH.end, EH.start) AS worktime\r\n" + 
					"FROM Employment_History EH\r\n" + 
					"WHERE EH.Employee_ID = ? AND EH.End > \"0000-00-00\"\r\n" + 
					"ORDER BY EH.End DESC limit 3;";
			PreparedStatement stmt=con.prepareStatement(sql1);  
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			int count =0;
			int days = 0;
			while (rs.next()) {
				count+=1;
				days += rs.getInt(1);
			}
			if (count<3)
				System.out.println("Less than 3 records.");
			else
				System.out.println("Your average working time is: "+days/3+" days.");
		} catch (SQLException e) {
			e.printStackTrace();
		}			
	}
	public static void mark_pos(String id) {
		Connection con = null;
		con = dbCon.getConnection();
		ResultSet rs = null;
		try {
			String sql1 = "SELECT Skills FROM Employee WHERE Employee_ID = ?;";
			PreparedStatement stmt=con.prepareStatement(sql1);  
			stmt.setString(1,id);
			rs = stmt.executeQuery();
			String skills= "";
			while(rs.next())
				skills = rs.getString(1);
			String tmp[] = skills.split(";");
			String tmp2 = "";
			for (int i = 0;i<tmp.length;i++)
            	tmp2+="?,";
			tmp2 = tmp2.substring(0,tmp2.length()-1);
			//System.out.println(tmp2);
			String sql2 = "SELECT Position_ID, Position_Title, Salary, C.Company, Size, Founded \r\n" + 
					"FROM Position P, Employer E, Company C, Employee A\r\n" + 
					"WHERE A.Employee_ID = ? AND " +
					"E.Company NOT IN (SELECT Company FROM Employment_History WHERE Employee_ID = ?) AND "+
					"P.Employer_ID=E.Employer_ID AND \r\n" + 
					"E.Company=C.Company AND \r\n" + 
					"P.Status=TRUE AND \r\n" + 
					"P.Position_Title NOT IN ("+ tmp2 + ") AND\r\n" + 
					"P.Salary>=A.Expected_Salary AND \r\n" + 
					"A.Experience >= P.Experience;";
			stmt=con.prepareStatement(sql2);  
			stmt.setString(1,id);
			stmt.setString(2,id);
			for (int i = 0;i<tmp.length;i++)
				stmt.setString(i+3,tmp[i]);
			rs = stmt.executeQuery();
			System.out.println("Position_ID, Position_Title, Salary, Company, Size, Founded");
			while (rs.next()) {
				for (int i=1;i<7;i++)
					System.out.print(rs.getString(i)+" ");
				System.out.println();
			}
			System.out.println("Please enter one interested Position_ID.");
			Scanner scanner = new Scanner(System.in);
	        String input2 = scanner.next();
	      
	        String sql3 = "INSERT INTO Marked(Position_ID,Employee_ID,Status) VALUES (?,?,0)";
	        stmt=con.prepareStatement(sql3);  
			stmt.setString(1,input2);
			stmt.setString(2,id);
			stmt.executeUpdate();
	        //scanner.close();
				
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	public static void post_pos(String id,String title,Integer salary,Integer Exp) {
		Connection con = null;
		con = dbCon.getConnection();
		ResultSet rs = null;
		try {
			String sql1 = "SELECT COUNT(*) FROM Employee A\r\n" + 
					"WHERE A.Expected_Salary<=? AND A.Experience >= ? AND\r\n" + 
					"A.Employee_ID NOT IN (SELECT Employee_ID FROM Employment_History WHERE End IS NULL)";
			PreparedStatement stmt=con.prepareStatement(sql1);  
			stmt.setInt(1,salary);
			stmt.setInt(2,Exp);
			rs = stmt.executeQuery();
			Integer num = 0;
			while(rs.next())
				 num = rs.getInt(1);
			if (num<1)
				System.out.println("No potential employees are found. The position recruitment is not posted.");
			else {
				System.out.println(num.toString() + " potential employees are found. The position recruitment is posted.");
		        int n=6;
				int lowerLimit = 97; 
		        int upperLimit = 122; 
		        Random random = new Random(); 
		        StringBuffer r = new StringBuffer(n); 
		  
		        for (int i = 0; i < n; i++) { 
		            int nextRandomChar = lowerLimit 
		                                 + (int)(random.nextFloat() 
		                                         * (upperLimit - lowerLimit + 1)); 
		            r.append((char)nextRandomChar); 
		        } 
		        String rnd = r.toString(); 
				String sql2 ="INSERT INTO Position (Position_ID,Position_Title,Salary,Experience,Employer_ID,Status) values (?,?,?,?,?,?);";
				stmt=con.prepareStatement(sql2);  
				stmt.setString(1,rnd);
				stmt.setString(2,title);  
				stmt.setInt(3,salary);
				stmt.setInt(4,Exp);
				stmt.setString(5,id);
	            stmt.setBoolean(6,true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}				
	}
}
