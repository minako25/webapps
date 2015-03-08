package http;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// �������X�g�̕ۑ����W�b�N��ǉ�����
public class BBSServlet3 extends HttpServlet{

	private List<BBSMessage> chatList;
	final static String FILE_PATH = "/WEB-INF/bbs3.dat";

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
		out.println("���O<input type=\"text\" name=\"user\"><br>");
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
			out.println("<td>:" + cm.getIpAddr());
			out.println("<td>:" + cm.getUserAgent());
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
