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

@WebServlet("/mvc/buy/book/")
public class BuyBookController extends HttpServlet {
	
	private BookService bookService = new BookService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 重導到指定頁面
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/buy_book.jsp");
		req.setAttribute("books", bookService.queryAll());
		rd.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer book_id = Integer.parseInt(req.getParameter("book_id")); 
		Integer qty = Integer.parseInt(req.getParameter("qty"));
		HttpSession session = req.getSession(false);
		User user = (User)session.getAttribute("user");
		Integer user_id = user.getId();
		
		
	}
	
}
