package appsample;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

public class Mondai{

	// P376 ó˚èKñ‚ëË
	public static void main(String[] args) throws Exception{

		Connection con = DBManager.getConnection();
		Statement smt = con.createStatement();
		int count = smt.executeUpdate("INSERT INTO ACCOUNT(ID, NAME, MONEY) " + "VALUES(4, 'ÉCÉJÉãÉh', 5000)");
		System.out.println("update count :" + count);

		ResultSet rs = smt.executeQuery("SELECT * FROM ACCOUNT WHERE ID=4");

		if(rs.next()){
			System.out.println(
					"ID=" + rs.getInt("ID")
					+ ",TITLE=" + rs.getString("NAME")
					+ ",PRICE=" + rs.getInt("MONEY")
					);
		}

		smt.close();
		con.close();
	}
}