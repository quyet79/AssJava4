package edu.poly.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.FavoriteDAO;
import edu.poly.entity.Favorite;
import edu.poly.entity.Sanpham;
import edu.poly.entity.User;
import edu.poly.utils.SessionUtils;

@WebServlet("/LikeProduct")
public class LikeProductServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		// String page = request.getParameter("page");
		String productId = request.getParameter("id");
		if (productId == null) {
			response.sendRedirect("/homeServlet");
			return;
		}

		try {
			FavoriteDAO dao = new FavoriteDAO();
			Favorite favorite = new Favorite();
			Sanpham sanpham = new Sanpham();
			sanpham.setId(productId);
			favorite.setSanpham(sanpham);

			String userId = SessionUtils.getLoginedUsername(request);
			User user = new User();
			user.setId(userId);
			favorite.setUser(user);

			favorite.setLikedate(new Date());
			dao.insert(favorite);
			request.setAttribute("message", "Sản phẩm đã được thêm vào yêu thích !");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

//		if(page==null) {
//			page = "/homeServlet";
//		}
//		request.getRequestDispatcher(page).forward(request, response);
		request.getRequestDispatcher("/homeServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
