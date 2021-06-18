package edu.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.SanPhamDAO;
import edu.poly.dao.UserDAO;
import edu.poly.entity.Sanpham;
import edu.poly.entity.User;


@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String pageStr =  (request.getParameter("page")) ;
//		String limitStr = request.getParameter("limit");
//		int page = pageStr ==null? 1 : Integer.parseInt(pageStr);
//		int limit = limitStr ==null? 5 : Integer.parseInt(limitStr);
//		int offset = limit*(page-1);
//		List<Sanpham> list = dao.findByPage(page, offset);
//		request.setAttribute("page", page);
		
		
		SanPhamDAO dao = new SanPhamDAO();
		List<Sanpham> list = dao.findAll();
		request.getSession().setAttribute("listSP", list);	
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	} 

			
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tensanpham = request.getParameter("tensanpham"); 
		SanPhamDAO dao = new SanPhamDAO();
		List<Sanpham> list = dao.findByNameSP(tensanpham);
		request.getSession().setAttribute("listSP", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	
	}
		
	
}
