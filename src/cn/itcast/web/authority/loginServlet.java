package cn.itcast.web.authority;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class loginServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");
		System.out.println(username);
		if(username.contains("itcast")){
			request.getSession().setAttribute("admin", username);
		} else{
			request.getSession().setAttribute("username", username);
		}
		request.getRequestDispatcher("/authority/index.jsp").forward(request, response);
	}

}
