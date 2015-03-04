package dispatch;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ForwardServletA extends HttpServlet{

	public void doGet( HttpServletRequest request,
			   HttpServletResponse response) throws IOException, ServletException{

		// コンソールに出力
		System.out.println("call ForwardServletA");

		// RequestDispatcherオブジェクトの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/ForwardServletB");

		//フォワードの実行
		dispatcher.forward(request, response);
	}
}