package cn.itcast.web.authority;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class AdminFilter implements Filter {

    public AdminFilter() {
    	
    }
    
	public void destroy() {
		
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
				throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		String name = (String)req.getSession().getAttribute("admin");
		if(name != null) {
			chain.doFilter(request, response);
		} else {
			req.setAttribute("msg", "您可能是个啥，但肯定不是管理员！");
			req.getRequestDispatcher("/authority/login.jsp").forward(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("=============================AdminFilter=============================");
	}

}
