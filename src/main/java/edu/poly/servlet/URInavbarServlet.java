package edu.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/home/products", "/home/users", "/home/favorites", "/home/shares" })
public class URInavbarServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		if (uri.contains("products")) {
			request.getSession().setAttribute("view", "/views/products.jsp");
		} else if (uri.contains("users")) {
			request.getSession().setAttribute("view", "/views/users.jsp");
		} else if (uri.contains("favorites")) {
			request.getSession().setAttribute("view", "/views/favorites.jsp");
		} else if (uri.contains("shares")) {
			request.getSession().setAttribute("view", "/views/shares.jsp");
		}

		request.getRequestDispatcher("/homeServlet").forward(request, response);
	}

}
