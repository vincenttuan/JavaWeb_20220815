package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.entity.User;
import mvc.service.CartService;

@WebServlet("/mvc/cart/book/*")
public class CartBookController extends HttpServlet {
	
	private CartService cartService = new CartService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得登入 user
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		Integer userId = user.getId();
		
		// 重導到指定頁面
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/cart_book.jsp");
		req.setAttribute("carts", cartService.queryAll(userId));
		rd.forward(req, resp);
	}

	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer id = getId(req);
		cartService.delete(id);
		resp.getWriter().println("delete ok");
	}
	
	private Integer getId(HttpServletRequest req) {
		// 取得 path info 資料
		String pathInfo = req.getPathInfo();
		// 去除 path info 的前導 "/" 變為 path variable
		String pathVariable = pathInfo.replace("/", "");
		// 去除 * 號
		pathVariable = pathVariable.replace("*", "");
		return Integer.parseInt(pathVariable);
	}
	
}
