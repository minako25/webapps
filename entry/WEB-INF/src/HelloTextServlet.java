import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HelloTextServlet extends HttpServlet {

	public void doGet( HttpServletRequest request,
					   HttpServletResponse response) throws IOException, ServletException{

		response.setContentType("text/plain; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("‚¨‚Í‚æ‚¤");
		out.println("‚±‚ñ‚É‚¿‚Í");
		out.println("‚±‚ñ‚Î‚ñ‚í");

	}
}