package foo;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class OmojanServlet extends HttpServlet {

	public void doGet( HttpServletRequest request,
					   HttpServletResponse response) throws IOException, ServletException{

		response.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("<HTML>");
		out.println("<HEAD>");
		out.println("<TITLE>AIñ êù</TITLE>");
		out.println("</HEAD>");
		out.println("<BODY>");
		out.println("<H2>" + new Omojan().getWord() + "</H2>");
		out.println("</BODY>");
		out.println("</HTML>");

	}
	
}