package wiki;

import javax.servlet.http.HttpServletRequest;

public class RequestUtils {

	// メッセージ表示用関数
	public static void setMessage(HttpServletRequest request, String message){
		request.setAttribute("message", message);
	}

}
