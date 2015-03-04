package reqattr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet3A extends HttpServlet{

	public void doGet( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		SampleBean bean = new SampleBean();
		bean.setMessage("�����ł���");
		request.setAttribute("bean", bean);

		// RequestDispatcher�I�u�W�F�N�g�̎擾
		RequestDispatcher dispatcher = request.getRequestDispatcher("/reqattr/result.jsp");

		//�t�H���[�h�̎��s
		dispatcher.forward(request, response);
	}
}