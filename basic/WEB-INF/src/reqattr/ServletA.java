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

		// リクエストスコープに登録
		request.setAttribute("message", "儲かってまっか？");

		// RequestDispatcherオブジェクトの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher("/servlet/ServletB");

		//フォワードの実行
		dispatcher.forward(request, response);
	}
}