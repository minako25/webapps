package reqattr;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GuessServlet extends HttpServlet{

	public void doGet( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		String msg = request.getParameter("number");
		String error = null;
		int number = 0;


		//���̓`�F�b�N
		if(msg == null || msg.length() == 0){
			error = "��������Ă�";
		}

		if(error == null){
			try{
				//�^�`�F�b�N
				number = Integer.parseInt(msg);

				// �͈̓`�F�b�N
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

		String path ="/reqattr/guess_hit.jsp";

		if(error != null){
			request.setAttribute("message", error);
			path = "/reqattr/guess.jsp";
		}
		else{
			// �Z�b�V�������瓖����̐������擾���Ȃ��ꍇ�����_������
			// �Z�b�V�����̎擾
			HttpSession session = request.getSession();
			Integer hit =(Integer)session.getAttribute("hit");
			if(hit == null){
				hit = new Integer(new Random().nextInt(10));
				session.setAttribute("hit", hit);
			}
			if(hit.intValue() == number){
				request.setAttribute("message", "������B����=" + number);

				// ���������琔�����N���A
				session.removeAttribute("hit");

			}
			else{
				request.setAttribute("message", "�͂���B����=" + number);
				path = "/reqattr/guess.jsp";
			}
		}

		// RequestDispatcher�I�u�W�F�N�g�̎擾
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		//�t�H���[�h�̎��s
		dispatcher.forward(request, response);
	}
}