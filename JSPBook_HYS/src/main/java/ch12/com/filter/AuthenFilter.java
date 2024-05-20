package ch12.com.filter;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AuthenFilter implements Filter {

	public AuthenFilter() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws IOException, ServletException {
		System.out.println("Filter01.jsp 수행...");
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		
		if(name==null || name.equals("")) {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter writer = response.getWriter();
			String message = "입력된 name 값은 null입니다.";
			writer.println(message);
			return;
		}
		filterChain.doFilter(request,  response);
	}

	public void destroy() {
		System.out.println("Filter01 해제...");
	}
}