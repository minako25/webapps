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

		// コンソールに出力
		System.out.println("call RandomWalkServlet");

		// RequestDispatcherオブジェクトの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		//フォワードの実行
		dispatcher.forward(request, response);
	}
}