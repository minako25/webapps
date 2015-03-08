package http;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 発言リストの保存ロジックを追加する
public class BBSServlet3 extends HttpServlet{

	private List<BBSMessage> chatList;
	final static String FILE_PATH = "/WEB-INF/bbs3.dat";

	public void init() throws ServletException{

		chatList = new Vector<BBSMessage>();

		// private 関数呼び出し
		File file = getDataFile();

		// ファイルが存在するかを判定
		if(file.exists()){
			try{
				InputStream in = new FileInputStream(file);
				//XMLDecoderを利用した読み込み
				XMLDecoder decoder = new XMLDecoder(in);
				chatList = (List<BBSMessage>)decoder.readObject();
				decoder.close();
			}
			catch(FileNotFoundException e){
				throw new ServletException(e);
			}
		}

	}

	public void doGet(HttpServletRequest request,
					HttpServletResponse response) throws ServletException, IOException{

		response.setContentType("text/html; charset=Windows-31J");
		PrintWriter out = response.getWriter();

		// 入力パラメータの取得
		String user = request.getParameter("user");
		String message = request.getParameter("message");

		// 入力があったときは、chatListに入力の発言を追加
		if(message != null){
			BBSMessage newBM = new BBSMessage();
			newBM.setUser(user);
			newBM.setMessage(message);
			// IPアドレスとブラウザ情報を追加
			newBM.setIpAddr(request.getRemoteAddr());
			newBM.setUserAgent(request.getHeader("USER-AGENT"));
			chatList.add(newBM);
		}

		//出力
		out.println("<html><body>");

		String uri = request.getRequestURI();
		out.println("<a href=\"" + uri + "\">リロード</a>");
		out.println("<form action=\"" + uri + "\">");
		out.println("名前<input type=\"text\" name=\"user\"><br>");
		out.println("メッセージ<input type=\"text\" name=\"message\" size=\"60\">");
		out.println("<input type=\"submit\" value=\"発言\">");
		out.println("</form>");

		// chatListの一覧をテーブル出力
		out.println("<table>");
		for(int i= chatList.size()-1; i>=0; i--){
			BBSMessage cm = chatList.get(i);
			out.println("<tr>");
			out.println("<td>" + cm.getUser());
			out.println("<td>:" + cm.getMessage());
			out.println("<td>:" + cm.getIpAddr());
			out.println("<td>:" + cm.getUserAgent());
		}

		out.println("</table>");
		out.println("</body></html>");
	}

	// Tomcat終了時にファイルへ保存する
	public void destroy(){
		File file = getDataFile();

		try{
			OutputStream out = new FileOutputStream(file);
			XMLEncoder encoder = new XMLEncoder(out);
			encoder.writeObject(chatList);
			encoder.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}

	}

	private File getDataFile(){
		// 物理パスの取得
		String path = getServletContext().getRealPath(FILE_PATH);
		return new File(path);
	}

}
