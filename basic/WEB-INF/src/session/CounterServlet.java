package session;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CounterServlet extends HttpServlet{

	public void doGet( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{
		// セッションの取得
		HttpSession session = request.getSession();

		// セッションからオブジェクトを取得
		Integer count =(Integer)session.getAttribute("count");

		// カウンタを+1
		if(count == null){
			count = new Integer(0);
		}

		count = new Integer(count.intValue() + 1);

		// セッションにオブジェクトを格納
		session.setAttribute("count", count);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");

		// セッションIDの表示
		out.println("<P>sessionId =" + session.getId());

		// カウンタの表示
		out.println("<P>count =" + count);

		// このサーブレットへのリンクの表示
		String linkUrl = request.getRequestURI();
		out.println("<p><a href=\"" + linkUrl + "\">RELOAD</a>");
		out.println("</body></html>");
	}
}