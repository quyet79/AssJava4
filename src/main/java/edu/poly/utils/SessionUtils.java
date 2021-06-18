package edu.poly.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionUtils {
	// lưu các thuộc tính vào session
	public static void add(HttpServletRequest request, String name, Object value) {
		HttpSession session = request.getSession();
		session.setAttribute(name, value);
	}

	// lấy giá trị của thuộc tính dc truyền vào trong session
	public static Object get(HttpServletRequest request, String name) {
		HttpSession session = request.getSession();
		return session.getAttribute(name);
	}

	// hủy bỏ session
	public static void invalidate(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("id");
		session.invalidate();
	}

	// kiểm tra đăng nhập
	public static boolean isLogin(HttpServletRequest request) {
		return get(request, "id") != null;
	}

	// lấy thông tin đăng nhập của user dc lưu trong session
	public static String getLoginedUsername(HttpServletRequest request) {
		Object id = get(request, "id");
		return id == null ? null : id.toString();
	}

}
