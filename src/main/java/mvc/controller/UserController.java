package mvc.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.service.UserService;
/*
 * 設計路徑:
 * Read   Get  /mvc/user/              全部查詢(首頁)
 * Read   Get  /mvc/user/2             單筆查詢(查詢id=2的資料)
 * Delete Get  /mvc/user/5?mode=delete 單筆刪除(刪除id=5的資料)
 * Create Post /mvc/user/              新增
 * Update Post /mvc/user/3             修改(修改id=3的資料)
 * */

@WebServlet("/mvc/user/*")
public class UserController extends HttpServlet {
	
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		System.out.println("pathInfo: " + pathInfo);
		
		if(pathInfo.equals("/")) { // 全部查詢
			System.out.println("全部查詢模式");
			req.setAttribute("buttonName", "新增");
		} else { // 單筆查詢
			// 將 / 去除後轉 int (Ex: /2 變成 2)
			Integer id = Integer.parseInt(pathInfo.replace("/", ""));
			System.out.print("id: " + id + ", ");
			// 判斷是否有 mode 參數傳入
			String mode = req.getParameter("mode");
			if(mode != null && mode.equals("delete")) {
				System.out.println("刪除模式");
				
			} else {
				System.out.println("單筆查詢模式");
				req.setAttribute("buttonName", "修改");
			}
		}
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
