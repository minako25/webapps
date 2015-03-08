package http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RedirectServlet extends HttpServlet{


	public void doGet(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{

		response.setContentType("text/html");

		//�X�e�[�^�X�R�[�h302 ���_�C���N�g����
		response.setStatus(HttpServletResponse.SC_MOVED_TEMPORARILY);
		response.setHeader("Location", "/");

	}

}
