package interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthorizeInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		HttpSession session = request.getSession();
		
		String email= (String)session.getAttribute("email");
		String role= (String)session.getAttribute("role");
		
		if( email == null ) {
			response.sendRedirect(request.getContextPath()+"/admin/login.htm");
			return false;
		}
		
		if( role.equals("guest") ) {
			response.sendRedirect(request.getContextPath()+"/index.htm");
			return false;
		}
		
		return true;
	}

}
