package app;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RoughCounterServlet extends HttpServlet{


	private Integer counter = new Integer(0);

	public void doGet(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{

		// シングルインスタンス・マルチスレッド（同時アクセス未考慮)
		int count = counter.intValue();
		count = count + 1;

		try{
			// 5秒遅延
			Thread.sleep(5000);
		}
		catch(InterruptedException igore){

		}

		counter = new Integer(count);

		response.setContentType("text/plain; charset=Windows-31J");
		PrintWriter out = response.getWriter();
		out.println("count =" + count);
		out.println("thred =" + Thread.currentThread());
		out.println("instance=" + this);
	}

}
