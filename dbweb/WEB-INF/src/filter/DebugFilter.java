package filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class DebugFilter implements Filter{

	private String encode;

	public void init(FilterConfig filterConfig) throws ServletException {
		// �������Ȃ�
	}

	public void doFilter(ServletRequest request,
						ServletResponse response,
						FilterChain chain) throws IOException, ServletException {
		System.out.println("calls DebugFilter#doFilter()");

		Enumeration<String> names = request.getParameterNames();

		while(names.hasMoreElements()){
			String name = names.nextElement();
			String[] values = request.getParameterValues(name);
			for(int i=0; i<values.length; i++){
				System.out.println(name + "=" + values[i]);
			}
		}

		// ���̃t�B���^�A�������̓N���C�A���g���烊�N�G�X�g���ꂽ���\�[�X�֏�������
		chain.doFilter(request, response);
	}

	public void destroy(){
		// �������Ȃ�
	}
}