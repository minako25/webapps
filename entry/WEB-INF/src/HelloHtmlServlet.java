import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HelloHtmlServlet extends HttpServlet {

	public void doGet( HttpServletRequest request,
					   HttpServletResponse response) throws IOException, ServletException{

		response.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>HTML�T�[�u���b�g</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("����ɂ���");
		out.println("</BODY>");
		out.println("</HTML>");

	}
}