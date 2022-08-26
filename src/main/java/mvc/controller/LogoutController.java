package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/mvc/logout")
public class LogoutController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session.setAttribute("user", null);
		session.invalidate(); // session 失效
		String contextName = req.getServletContext().getServletContextName(); // JavaWeb_20220815
		resp.sendRedirect("/" + contextName + "/mvc/user/");  // 重導
	}
	
}
