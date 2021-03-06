package websample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBManager2{

	public static Connection getConnection(){
		try{
			Class.forName("org.hsqldb.jdbcDriver");
			Connection con = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "sa", "");

			return con;
		}
		catch(Exception e){
			throw new IllegalStateException(e);
		}
	}

	/**
	 * 更新SQLを発行する
	 */
	public static int simpleUpdate(String sql) throws SQLException{
		Connection con = null;
		Statement smt = null;

		try{
			con = DBManager2.getConnection();
			smt = con.createStatement();
			return smt.executeUpdate(sql);
		}
		finally{
			if(smt != null){
				try{
					smt.close();
				}
				catch(SQLException ignore){

				}
			}
			if(con != null){
				try{
					con.close();
				}
				catch(SQLException ignore){

				}
			}
		}
	}

	public static void main(String[] args) throws Exception{
		Connection con = getConnection();
		System.out.println("con=" + con );
		con.close();
	}
}