package edu.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.SanPhamDAO;
import edu.poly.entity.Sanpham;

/**
 * Servlet implementation class SearchByName
 */
@WebServlet("/SearchByName")
public class SearchByName extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String tensanpham = request.getParameter("tensanpham");
		SanPhamDAO dao = new SanPhamDAO();
		List<Sanpham> list = dao.findByNameSP(tensanpham);
		request.getSession().setAttribute("listSP", list);
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
