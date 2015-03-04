package input;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MethodServlet extends HttpServlet {

	public void doGet( HttpServletRequest request,
					   HttpServletResponse response) throws IOException, ServletException{

		System.out.println("doGet");
		perform(request, response);

	}

	public void doPost( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		System.out.println("doPost");
		perform(request, response);
	}

	private void perform( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		request.setCharacterEncoding("Windows-31J");

		String msg = request.getParameter("message");

		response.setContentType("text/plain; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("message=" + msg);
	}
}