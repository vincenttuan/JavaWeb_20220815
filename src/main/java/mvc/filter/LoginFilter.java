package mvc.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.entity.User;
import mvc.service.UserService;

// 登入驗證與管理
@WebFilter(urlPatterns = {"/mvc/user/*"})
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		UserService userService = new UserService();
		
		// 確認使用者是否已登入?
		// 利用 session 變數來存放特定資料
		HttpSession session = req.getSession();
		// 查找是否在 session 變數中有 user 這個參數?
		if(session.getAttribute("user") != null) {
			chain.doFilter(req, res); // 放行
		} else {
			// 檢查是否有從表單傳來 username 與 password
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			User user = userService.checkLogin(username, password);
			if(user != null) { // 是否登入成功
				session.setAttribute("user", user); // 將 user(登入者) 物件存放在 session 變數(每一頁(servlet, jsp)都可以使用)中
				String contextName = req.getServletContext().getServletContextName();
				res.sendRedirect("/" + contextName + "/mvc/user/");  // 重導到首頁
			} else {
				// 重導到 login 畫面
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
				rd.forward(req, res);
			}
		}
		
	}
	
}
