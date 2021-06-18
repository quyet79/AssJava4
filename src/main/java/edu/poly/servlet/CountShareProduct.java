package edu.poly.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.SanPhamDAO;
import edu.poly.entity.Report;

@WebServlet("/CountShareProduct")
public class CountShareProduct extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SanPhamDAO dao = new SanPhamDAO();
		List<Report> list = dao.countShareOfProduct();
		request.getSession().setAttribute("listSP2", list);
		request.getRequestDispatcher("/home/shares").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
