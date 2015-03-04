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


		//入力チェック
		if(msg == null || msg.length() == 0){
			error = "何か入れてね";
		}

		if(error == null){
			try{
				//型チェック
				number = Integer.parseInt(msg);

				// 範囲チェック
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

		String path ="/reqattr/guess_hit.jsp";

		if(error != null){
			request.setAttribute("message", error);
			path = "/reqattr/guess.jsp";
		}
		else{
			// セッションから当たりの数字を取得しない場合ランダム生成
			// セッションの取得
			HttpSession session = request.getSession();
			Integer hit =(Integer)session.getAttribute("hit");
			if(hit == null){
				hit = new Integer(new Random().nextInt(10));
				session.setAttribute("hit", hit);
			}
			if(hit.intValue() == number){
				request.setAttribute("message", "当たり。数字=" + number);

				// 正解したら数字をクリア
				session.removeAttribute("hit");

			}
			else{
				request.setAttribute("message", "はずれ。数字=" + number);
				path = "/reqattr/guess.jsp";
			}
		}

		// RequestDispatcherオブジェクトの取得
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);

		//フォワードの実行
		dispatcher.forward(request, response);
	}
}