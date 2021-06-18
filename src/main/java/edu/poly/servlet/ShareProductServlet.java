package edu.poly.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.poly.dao.ShareDAO;
import edu.poly.entity.Email;
import edu.poly.entity.EmailUtils;
import edu.poly.entity.Sanpham;
import edu.poly.entity.Share;
import edu.poly.entity.User;
import edu.poly.utils.SessionUtils;


@WebServlet("/ShareProduct")
public class ShareProductServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.isLogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		
		String productId = request.getParameter("id");
		if(productId ==null) {
			response.sendRedirect("/homeServlet");
			return;
		}
		request.setAttribute("productId", productId);
		request.getRequestDispatcher("/views/sendEmail.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String emailAddress = request.getParameter("email");
			String productId = request.getParameter("id");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			if(productId==null) {
				request.setAttribute("error", "ProductId is null !");
			} else {
			Email email = new Email();
			email.setFrom("");
			email.setFromPassword("");
			email.setTo(emailAddress);
			email.setSubject(subject);
			StringBuilder sb = new StringBuilder();
			sb.append(content +"<br>");
			sb.append("Click the link: ").append(String.format("<a href=''>View Product</a><br>", productId));
			email.setContent(sb.toString());
			EmailUtils.send(email);
			ShareDAO dao = new ShareDAO();
			Share share = new Share();
			share.setEmail(emailAddress);
			share.setSharedate(new Date());
			String uID = SessionUtils.getLoginedUsername(request);
			User user = new User();
			user.setId(uID);
			share.setUser(user);
			
			Sanpham sanpham = new Sanpham();
			sanpham.setId(productId);
			share.setSanpham(sanpham);
			dao.insert(share);
			request.setAttribute("message", "Thao tác thành công !");
			}
		} catch(Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		request.getRequestDispatcher("/views/sendEmail.jsp").forward(request, response);
	}

}
