package input;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuessServlet extends HttpServlet {

	// 当たりの数字

	public void doGet( HttpServletRequest request,
					   HttpServletResponse response) throws IOException, ServletException{

		String msg = request.getParameter("number");
		String error = null;
		int number = 0;

		//P146 必須チェック
		if(msg == null || msg.length() == 0){
			error = "何か入れてね";
		}

		if(error == null){
			try{
				//P147 型チェック
				number = Integer.parseInt(msg);

				// P147 範囲チェック
				if(number < 0 || number > 9){
					error = "0から9までの数字を入れてください";
				}
				else{

				}
			}
			catch(NumberFormatException e){
				error = "数字をいれてください";
			}
		}

		request.setCharacterEncoding("Windows-31J");
		response.setContentType("text/plain; charset=Windows-31J");
		PrintWriter out = response.getWriter();

		if(error != null){
			out.println(error);
		}
		else{
			out.println("数字:" + number);

			if(number == 9){
				out.println("当たり");
			}
			else{
				out.println("はずれ");
			}
		}

	}

}