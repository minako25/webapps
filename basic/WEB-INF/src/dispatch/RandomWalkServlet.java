package dispatch;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RandomWalkServlet extends HttpServlet{

	final static String[] PATHS = new String[]{
		"/servlet/ForwardServletB",
		"/dispatch/forward_ok.jsp",
	};

	public void doGet( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		int index = new Random().nextInt(PATHS.length);
		String path = PATHS[index];

		// �R���\�[���ɏo��
		System.out.println("call RandomWalkServlet");

		// RequestDispatcher�I�u�W�F�N�g�̎擾
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		//�t�H���[�h�̎��s
		dispatcher.forward(request, response);
	}
}