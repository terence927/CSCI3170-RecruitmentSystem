import java.sql.*;

public class backend {

	public backend() {
	}
	public static void check_position(String posid, String title, Integer salary) {
		Connection con = null;
		ResultSet rs = null;
		con = dbCon.getConnection();
		try {
			String sql = "SELECT * FROM Position WHERE Position_ID = ? AND Position_Title= ? AND Salary=?;";
			PreparedStatement stmt=con.prepareStatement(sql);  
			stmt.setString(1,posid);//1 specifies the first parameter in the query  
			stmt.setString(2,title);  
			stmt.setInt(3,salary);
			rs = stmt.executeQuery();
			while(rs.next())
			{
				System.out.println(rs.getString("Employer_ID")); //or rs.getString("column name");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		check_position("pidabf","teacher",5001);
	}

}
