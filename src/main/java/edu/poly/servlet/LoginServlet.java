package edu.poly.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.dao.UserDAO;
import edu.poly.entity.LoginForm;
import edu.poly.entity.User;
import edu.poly.utils.CookieUtils;
import edu.poly.utils.SessionUtils;

@WebServlet("/Login")
public class LoginServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// lấy tt cookie khi ng dùng remember
		String id = CookieUtils.get("id", request);
		if (id == null) {
			request.getRequestDispatcher("/login_signup/login.jsp").forward(request, response);
			return;
		}
		// lưu tt cookie id trong session
		SessionUtils.add(request, "id", id);
		request.getRequestDispatcher("/homeServlet").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// HttpSession session = request.getSession();
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDAO dao = new UserDAO();
			User user = dao.findById(form.getId());
			if (user != null && user.getPassword().equals(form.getPassword())) {
				SessionUtils.add(request, "id", user.getId());
				if (form.isRemember()) {
					CookieUtils.add("id", form.getId(), 72, response);
				} else {
					CookieUtils.add("id", form.getId(), 0, response);
				}
				request.setAttribute("isLogin", true);
				request.getSession().setAttribute("name", user.getFullname());
				request.getSession().setAttribute("role", user.isRole());
				// request.getRequestDispatcher("/homeServlet").forward(request, response);
				if (user.isRole() == false) {
					response.sendRedirect("/Assignment/homeServlet");
				} else {
					response.sendRedirect("/Assignment/ProductServlet");
				}
				return;
			}
			request.setAttribute("error", "Invalid Username or Password !");

		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/login_signup/login.jsp").forward(request, response);
	}

}
