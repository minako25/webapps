package websample;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.AccountException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class WhereSelectServlet extends HttpServlet{

	public void doGet(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{

		response.setContentType("text/plain; charset=Windows-31J");
		request.setCharacterEncoding("Windows-31J");
		PrintWriter out = response.getWriter();

		String keyword = request.getParameter("keyword");
		String sql = "SELECT * FROM ACCOUNT WHERE NAME LIKE '%" + keyword + "%'";

		Connection con = null;
		Statement smt = null;

		try{

			con = DBManager.getConnection();
			smt = con.createStatement();
			ResultSet rs = smt.executeQuery(sql);

			List<Account> list = new ArrayList<Account>();

			while(rs.next()){

				Account account = new Account();
				account.setId(rs.getInt("ID"));
				account.setName(rs.getString("NAME"));
				account.setMoney(rs.getInt("MONEY"));

				list.add(account);
			}

			request.setAttribute("list", list);
		}
		catch(SQLException e){
			throw new ServletException(e);
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

		request.getRequestDispatcher("/websample/select.jsp").forward(request, response);
	}
}