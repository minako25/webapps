package input;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GuessServlet extends HttpServlet {

	// ������̐���

	public void doGet( HttpServletRequest request,
					   HttpServletResponse response) throws IOException, ServletException{

		String msg = request.getParameter("number");
		String error = null;
		int number = 0;

		//P146 �K�{�`�F�b�N
		if(msg == null || msg.length() == 0){
			error = "��������Ă�";
		}

		if(error == null){
			try{
				//P147 �^�`�F�b�N
				number = Integer.parseInt(msg);

				// P147 �͈̓`�F�b�N
				if(number < 0 || number > 9){
					error = "0����9�܂ł̐��������Ă�������";
				}
				else{

				}
			}
			catch(NumberFormatException e){
				error = "����������Ă�������";
			}
		}

		request.setCharacterEncoding("Windows-31J");
		response.setContentType("text/plain; charset=Windows-31J");
		PrintWriter out = response.getWriter();

		if(error != null){
			out.println(error);
		}
		else{
			out.println("����:" + number);

			if(number == 9){
				out.println("������");
			}
			else{
				out.println("�͂���");
			}
		}

	}

}