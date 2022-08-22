package filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 過濾器: 定要要管控的路徑
@WebFilter(urlPatterns = {"/mvc/user/*", "/servlet/*", "/form/*"})
public class MyFilter extends HttpFilter {
	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		
		//res.getWriter().print("Stop");
		chain.doFilter(req, res); // 通過 filter
		
	}
}
