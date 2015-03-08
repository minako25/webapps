package cookie;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// ���[�U�[�����N�b�L�[�ŕۑ�����
public class BBSServlet4 extends HttpServlet{

	private List<BBSMessage> chatList;
	final static String FILE_PATH = "/WEB-INF/bbs4.dat";

	public void init() throws ServletException{

		chatList = new Vector<BBSMessage>();

		// private �֐��Ăяo��
		File file = getDataFile();

		// �t�@�C�������݂��邩�𔻒�
		if(file.exists()){
			try{
				InputStream in = new FileInputStream(file);
				//XMLDecoder�𗘗p�����ǂݍ���
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

		// ���̓p�����[�^�̎擾
		String user = request.getParameter("user");
		String message = request.getParameter("message");

		Cookie[] cookies = request.getCookies();
		// ���[�U�[�������邩�ǂ����𔻕�
		if(user == null || user.length() ==0){

			if(cookies != null){
				for(int i=0; i<cookies.length; i++){
					Cookie cookie = cookies[i];
					if(cookie.getName().equals("user")){
						String value = cookie.getValue();
						user = URLDecoder.decode(value, "Windows-31J");
						break;
					}
				}
			}
		}
		else{
			// �Ȃ��ꍇ�̓N�b�L�[�ŕۑ�(�ۑ�����5����)
			String value = URLEncoder.encode(user, "Windows-31J");
			Cookie cookie = new Cookie("user", value);
			cookie.setMaxAge(60 * 60 * 24 * 5);
			response.addCookie(cookie);
		}


		if(cookies != null){
			for(int i =0; i< cookies.length; i++){
				Cookie cookie = cookies[i];
				if(cookie.getName().equals("user")){
					String value = cookie.getValue();
					break;
				}
			}
		}

		// ���͂��������Ƃ��́AchatList�ɓ��͂̔�����ǉ�
		if(message != null){
			BBSMessage newBM = new BBSMessage();
			newBM.setUser(user);
			newBM.setMessage(message);
			// IP�A�h���X�ƃu���E�U����ǉ�
			newBM.setIpAddr(request.getRemoteAddr());
			newBM.setUserAgent(request.getHeader("USER-AGENT"));
			chatList.add(newBM);
		}

		//�o��
		out.println("<html><body>");

		String uri = request.getRequestURI();
		out.println("<a href=\"" + uri + "\">�����[�h</a>");
		out.println("<form action=\"" + uri + "\">");
		out.println("���O<input type=\"text\" name=\"user\"" + "value=\"" + (user != null ? user : "") +"\"><br>");
		out.println("���b�Z�[�W<input type=\"text\" name=\"message\" size=\"60\">");
		out.println("<input type=\"submit\" value=\"����\">");
		out.println("</form>");

		// chatList�̈ꗗ���e�[�u���o��
		out.println("<table>");
		for(int i= chatList.size()-1; i>=0; i--){
			BBSMessage cm = chatList.get(i);
			out.println("<tr>");
			out.println("<td>" + cm.getUser());
			out.println("<td>:" + cm.getMessage());
		}

		out.println("</table>");
		out.println("</body></html>");
	}

	// Tomcat�I�����Ƀt�@�C���֕ۑ�����
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
		// �����p�X�̎擾
		String path = getServletContext().getRealPath(FILE_PATH);
		return new File(path);
	}

}
