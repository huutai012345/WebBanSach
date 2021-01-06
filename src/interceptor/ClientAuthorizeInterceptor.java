	package interceptor;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ClientAuthorizeInterceptor extends HandlerInterceptorAdapter {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
		HttpSession session = request.getSession();
		
		String email= (String)session.getAttribute("email");
		
		if( email == null ) {
			HttpSession session1=request.getSession();
			session1.setAttribute("url", request.getRequestURL().toString());
			
			response.sendRedirect(request.getContextPath()+"/login.htm");
			return false;
		}
		
		return true;
	}

}
