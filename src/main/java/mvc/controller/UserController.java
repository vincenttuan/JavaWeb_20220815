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
 * Update Post /mvc/user/              修改(判斷表單傳來的id欄位是否有資料)
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
			// 刪除 ?
			if(mode != null && mode.equals("delete")) {
				System.out.println("刪除模式");
				userService.delete(id);
				req.setAttribute("buttonName", "新增");
			} else {
				System.out.println("單筆查詢模式");
				req.setAttribute("buttonName", "修改");
				req.setAttribute("user", userService.get(id));
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/user.jsp");
		req.setAttribute("users", userService.queryAll());
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得表單資料
		String id = req.getParameter("id").trim();
		String username = req.getParameter("username").trim();
		String password = req.getParameter("password") == null ? "" : req.getParameter("password").trim();
		String salary = req.getParameter("salary").trim();
		
		// 利用 id 是否有資料來判定是修改還是新增 ?
		if(id == null || id.trim().length() == 0) { // 新增模式
			System.out.println("新增模式");
			try {
				userService.add(username, password, salary);
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendError(500, e.getMessage());
				return;
			}
		} else {
			System.out.println("修改模式");
			try {
				userService.update(id, username, salary);
			} catch (Exception e) {
				e.printStackTrace();
				resp.sendError(500, e.getMessage());
				return;
			}
			
		}
		
		String contextName = req.getServletContext().getServletContextName(); // JavaWeb_20220815
		resp.sendRedirect("/" + contextName + "/mvc/user/");  // 重導到首頁
	}
	
}
