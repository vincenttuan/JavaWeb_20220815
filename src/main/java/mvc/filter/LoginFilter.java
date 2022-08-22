package mvc.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 登入驗證與管理
@WebFilter(urlPatterns = {"/mvc/user/*"})
public class LoginFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		res.getWriter().print("Please login !!");
		// 重導到 login 畫面
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/login.jsp");
		rd.forward(req, res);
	}
	
}
