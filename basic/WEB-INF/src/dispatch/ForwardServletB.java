package dispatch;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServletB extends HttpServlet{

	public void doGet( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		// コンソールに出力
		System.out.println("call ForwardServletB");

		response.setContentType("text/plain; charset=Windows-31J");
		response.getWriter().println("ForwardServletBからこんにちは");
	}
}