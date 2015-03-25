package fw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBManager{

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
	 * �X�VSQL�𔭍s����
	 */
	public static int simpleUpdate(String sql) throws SQLException{
		Connection con = null;
		Statement smt = null;

		try{
			con = DBManager.getConnection();
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

	/**
	 * ����SQL�𔭍s���āA���ʂ��I�u�W�F�N�g��List�ɓ���ĕԂ�
	 */

	public static <T> List<T> simpleFind(String sql, ResultSetBeanMapping<T> mapping) throws SQLException{
		Connection con = null;
		Statement smt = null;

		try{
			con = DBManager.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			List<T> list = new ArrayList<T>();

			while(rs.next()){
				Object bean = mapping.createFromResultSet(rs);

				list.add((T) bean);
			}

			return list;

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