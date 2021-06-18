package edu.poly.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.beanutils.BeanUtils;

import edu.poly.dao.SanPhamDAO;
import edu.poly.entity.Sanpham;
import edu.poly.utils.UploadUtils;


@MultipartConfig
@WebServlet({"/ProductServlet","/ProductServlet/insert","/ProductServlet/update","/ProductServlet/edit",
	"/ProductServlet/delete","/ProductServlet/reset"})
public class ProductServlet extends HttpServlet {
	
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		Sanpham sanpham=null; 
		if(uri.contains("delete")) {
			delete(request, response);
			sanpham = new Sanpham();
			request.setAttribute("sanphams", sanpham);
		}else if(uri.contains("edit")) {
			edit(request, response);
		}else if(uri.contains("reset")) {
			sanpham = new Sanpham();
			request.setAttribute("sanphams", sanpham);
		}
		
		findAll(request, response);
		request.getRequestDispatcher("/home/products").forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf8");
		response.setCharacterEncoding("utf8");	
		String uri = request.getRequestURI();
		if(uri.contains("insert")) {
			insert(request, response);
		} else if(uri.contains("delete")) {
			delete(request, response);
			request.setAttribute("sanphams", new Sanpham());
		}else if(uri.contains("update")) {
			update(request, response);
		}else if(uri.contains("reset")) {
			request.setAttribute("sanphams", new Sanpham());
		}
		
		findAll(request, response);
		request.getRequestDispatcher("/home/products").forward(request, response);
	
	}
	
	protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {	
//			File directory = new File(request.getServletContext().getRealPath("/files"));
//			Part photo = request.getPart("hinhanh");
//			File photoFile = new File(directory,photo.getSubmittedFileName());
//			photo.write(photoFile.getAbsolutePath());
			//sanpham.setHinhanh(photoFile.getName());
				Sanpham sanpham = new Sanpham();
				BeanUtils.populate(sanpham, request.getParameterMap());
				sanpham.setHinhanh(UploadUtils.processUploadField("hinhanh", request, "",sanpham.getHinhanh() ) );
				SanPhamDAO dao = new SanPhamDAO();
				dao.insert(sanpham);
				request.setAttribute("message", "Thêm mới thành công !"); 
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error: " +e.getMessage());
			}
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {			
				SanPhamDAO dao = new SanPhamDAO();
				List<Sanpham> list = dao.findAll();
				request.getSession().setAttribute("lists", list);
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error: " +e.getMessage());
			}
	}
	
	protected void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {				
				String id = request.getParameter("id");
				SanPhamDAO dao = new SanPhamDAO();
				Sanpham sanpham = dao.findById(id);
				request.setAttribute("sanphams", sanpham); 
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error: " +e.getMessage());
			}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {	
				
				Sanpham sanpham = new Sanpham();
				BeanUtils.populate(sanpham, request.getParameterMap());
				sanpham.setHinhanh(UploadUtils.processUploadField("hinhanh", request, "",sanpham.getHinhanh() ) );
				SanPhamDAO dao = new SanPhamDAO();
				dao.update(sanpham); 
				request.setAttribute("sanphams", sanpham); 
				request.setAttribute("message", "Sửa thành công !"); 
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error: " +e.getMessage());
			}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		try {	
			String id = request.getParameter("id");
				SanPhamDAO dao = new SanPhamDAO();
				dao.delete(id);
				request.setAttribute("message", "Xóa thành công !");
			} catch(Exception e) {
				e.printStackTrace();
				request.setAttribute("error", "Error: " +e.getMessage());
			}
	}
	
	

}
