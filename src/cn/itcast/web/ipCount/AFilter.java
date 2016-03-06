package cn.itcast.web.ipCount;

import java.io.IOException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class AFilter implements Filter {
	private FilterConfig fconfig = null;
	public void destroy() {
		System.out.println("拦截器消亡");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
			throws IOException, ServletException {
		String ip = request.getRemoteAddr();//先获取访问的ip
		ServletContext app = fconfig.getServletContext();
		Map<String,Integer> map = (Map<String, Integer>) app.getAttribute("map");//取出map对象
		if(map.containsKey(ip)){
			int count = map.get(ip);
			map.put(ip, count+1);
		}else{
			map.put(ip, 1);
		}
		app.setAttribute("map", map);
		chain.doFilter(request, response);//肯定放行
	}

	public void init(FilterConfig fConfig) throws ServletException {
		this.fconfig = fConfig;
		System.out.println("拦截器启动");
	}
}
