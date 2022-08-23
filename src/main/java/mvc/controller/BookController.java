package mvc.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/mvc/book/*")
public class BookController extends HttpServlet {
	
	private String getPathVariable(HttpServletRequest req) {
		// 取得 path info 資料
		String pathInfo = req.getPathInfo();
		// 去除 path info 的前導 "/" 變為 path variable
		String pathVariable = pathInfo.replace("/", "");
		return pathVariable;
	}
	
	/*
	 * 查詢全部: /mvc/book/ 或 /mvc/book/*
	 * 查詢單筆: /mvc/book/1
	 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().println("do get 查詢資料用 ");
		String pathVar = getPathVariable(req);
		resp.getWriter().println("pathVar: " + pathVar);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("do post 新增資料用");
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("do put 修改資料用");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.getWriter().print("do delete 刪除資料用");
	}
	
}
