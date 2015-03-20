package appsample;

import java.sql.Statement;
import java.sql.Connection;

public class TransactionSample{

	public static void main(String[] args) throws Exception{

		Connection con = DBManager.getConnection();
		con.setAutoCommit(false); // �I�[�g�R�~�b�g��off��
		Statement smt = con.createStatement();

		smt.executeUpdate("UPDATE ACCOUNT " + "SET MONEY=MONEY-1000 WHERE ID=1");
		smt.executeUpdate("UPDATE ACCOUNT " + "SET MONEY=MONEY+1000 WHERE ID=2");

		smt.close();
		con.commit();
		con.close();
	}
}