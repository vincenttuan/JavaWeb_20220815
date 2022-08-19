package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.service.UserService;

@WebServlet("/mvc/user")
public class UserController extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user.jsp");
		req.setAttribute("users", userService.queryAll());
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String salary = req.getParameter("salary");
		
		try {
			userService.add(username, password, salary);
		} catch (Exception e) {
			e.printStackTrace();
			resp.sendError(500, e.getMessage());
			return;
		}
		
		resp.sendRedirect("./user");  // 重導到首頁
	}
	
}
