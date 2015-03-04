package reqattr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletA extends HttpServlet{

	public void doGet( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		// ���N�G�X�g�X�R�[�v�ɓo�^
		request.setAttribute("message", "�ׂ����Ă܂����H");

		// RequestDispatcher�I�u�W�F�N�g�̎擾
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/ServletB");

		//�t�H���[�h�̎��s
		dispatcher.forward(request, response);
	}
}