package com.leer.mypage.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leer.mypage.model.service.MypageService;
import com.leer.mypage.model.vo.Point;

/**
 * Servlet implementation class MyPagePointController
 */
@WebServlet("/point.me")
public class MyPagePointController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPagePointController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		int memNo = Integer.parseInt(request.getParameter("memNo"));
		

		
		if(session.getAttribute("loginUser") == null) {
			response.sendRedirect(request.getContextPath());
		}else {
			
			ArrayList<Point> list  = new MypageService().PointList(memNo);
			request.setAttribute("list", list);
			RequestDispatcher view = request.getRequestDispatcher("views/mypage/mypage_point.jsp");
			view.forward(request, response);
		}	
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
