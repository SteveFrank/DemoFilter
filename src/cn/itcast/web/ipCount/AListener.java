package cn.itcast.web.ipCount;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class AListener implements ServletContextListener {

    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println("监听器初始");
    	ServletContext application = sce.getServletContext();
    	Map<String,Integer> map = new LinkedHashMap<String,Integer>();
    	application.setAttribute("map", map);
    }

    public void contextDestroyed(ServletContextEvent sce) {
    	System.out.println("监听器消亡");
    }
	
}
