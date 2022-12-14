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
import mvc.service.BookService;
import mvc.service.CartService;

@WebServlet("/mvc/buy/book/")
public class BuyBookController extends HttpServlet {
	
	private BookService bookService = new BookService();
	private CartService cartService = new CartService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到指定頁面
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/buy_book.jsp");
		//req.setAttribute("books", bookService.queryAll()); // 查詢全部
		req.setAttribute("books", bookService.queryBookCart()); // 查詢全部 (book庫存數量扣除購物車數量)
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer bookId = Integer.parseInt(req.getParameter("book_id")); 
		Integer qty = Integer.parseInt(req.getParameter("qty"));
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		Integer userId= user.getId();
		
		cartService.add(userId, bookId, qty);
		//resp.getWriter().println("cart add ok");
		String contextName = req.getServletContext().getServletContextName(); // JavaWeb_20220815
		resp.sendRedirect("/" + contextName + "/mvc/cart/book/");  // 重導
	}
	
}
