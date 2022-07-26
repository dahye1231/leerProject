package com.leer.product.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.leer.member.model.vo.Member;
import com.leer.product.model.service.ProductService;
import com.leer.product.model.vo.Inquiry;
import com.leer.product.model.vo.Product;

/**
 * Servlet implementation class ProductDetailController
 */
@WebServlet("/detail.pd")
public class ProductDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pCode = request.getParameter("pNo");
		
		HttpSession session = request.getSession();
		Member loginUser = (Member)session.getAttribute("loginUser");

		int memNo = 0;
		if(loginUser != null) {
			memNo = loginUser.getMemNo();
		}

		// 상품 상세조회
		Product p = new ProductService().selectProductDetail(pCode); 
		ArrayList<Inquiry> list = new ProductService().selectInquiryList(pCode);
		
		// 찜 여부 조회
		int scrapResult = new ProductService().scrapCheck(pCode, memNo);
				
		request.setAttribute("p", p);
		request.setAttribute("list", list);
		
		request.setAttribute("scrapResult", scrapResult);
		
		System.out.println(p);
		System.out.println(list);
		
		request.getRequestDispatcher("views/product/productDetail.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
