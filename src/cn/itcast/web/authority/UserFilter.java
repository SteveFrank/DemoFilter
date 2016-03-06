package cn.itcast.web.authority;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class UserFilter implements Filter {

    public UserFilter() {
    	
    }
    
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String name = (String)req.getSession().getAttribute("admin");
		if(name != null) {
			chain.doFilter(request, response);
			return;
		}
		
		name = (String)req.getSession().getAttribute("username");
		if(name != null) {
			chain.doFilter(request, response);
			req.getSession().removeAttribute("username");
			return;
		} else {
			req.setAttribute("msg", "您啥都不是，不要瞎溜达！");
			req.getRequestDispatcher("/authority/login.jsp").forward(request, response);
		}
	}
	
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("=============================UserFilter=============================");
	}

}
