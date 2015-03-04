package validate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EtoServlet extends HttpServlet {

	final static String[] ETOS = new String[]{
		"子（ね）",
		"丑（うし）",
		"寅（とら）",
		"卯（う）",
		"辰（たつ）",
		"巳（み）",
		"午（うま）",
		"未（ひつじ）",
		"申（さる）",
		"酉（とり）",
		"戌（いぬ）",
		"亥（い）",
	};

	public void doGet( HttpServletRequest request,
					   HttpServletResponse response) throws IOException, ServletException{


		String yearStr = request.getParameter("year");
		int year = Integer.parseInt(yearStr);

		int index = (year + 8) % 12;
		String etoText = ETOS[index];


		response.setContentType("text/plain; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("あなたの干支:" + etoText);


	}

}