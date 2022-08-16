package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/program")
public class ProgramServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 請求與回應文件編碼設定(中文支援)
		req.setCharacterEncoding("utf-8"); // req utf-8 編碼
		resp.setCharacterEncoding("utf-8"); // resp utf-8 編碼 
		resp.setContentType("text/html;charset=utf-8"); // 回應文件 utf-8 編碼 (給前端判斷使用)
		
		// 取得表單資料
		String username = req.getParameter("username");
		String[] programs = req.getParameterValues("program");
		
		// 回應結果
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("姓名: " + username);
		out.println("<p />");
		out.println("程式: " + Arrays.toString(programs));
		out.println("<p />");
		out.println("</html>");
	}
	
}
