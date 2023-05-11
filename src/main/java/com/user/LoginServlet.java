package com.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("uid");
		String password = request.getParameter("pass");
		
		//HttpSession session = request.getSession();
		//RequestDispatcher dispatcher = null;
		
		try {		
		List<User> useDetails = UserDBUtil.validate(username, password);
		request.setAttribute("useDetails",useDetails);			
		}
	
		catch(Exception e){
			e.printStackTrace();
			
		}
		/*if(session.getAttribute("name").equals("Admin")){
			dispatcher = request.getRequestDispatcher("adminhome.jsp"); 
			
		}else {
			dispatcher = request.getRequestDispatcher("home.jsp");
		}*/
		RequestDispatcher dis = request.getRequestDispatcher("adminhome.jsp");
		dis.forward(request, response);
	}

}
