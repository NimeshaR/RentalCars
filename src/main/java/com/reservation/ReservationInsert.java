package com.reservation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ReservationInsert")
public class ReservationInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String plocation = request.getParameter("plocation");
		String dlocation = request.getParameter("dlocation");
		String pdate = request.getParameter("pdate");
		String ddate = request.getParameter("ddate");
		String ptime = request.getParameter("ptime");
		String vtype = request.getParameter("vtype");
		String uid = request.getParameter("uid");
		
		boolean isTrue;
		
		isTrue = ReservationDBUtil.insertreservation(plocation, dlocation, pdate, ddate, ptime, vtype, uid);
		
		if(isTrue == true) {
			RequestDispatcher dis = request.getRequestDispatcher("success.jsp");
			dis.forward(request, response);
			
		}else {
			RequestDispatcher dis2 = request.getRequestDispatcher("unsuccess.jsp");
			dis2.forward(request, response);
		}
	}

}
