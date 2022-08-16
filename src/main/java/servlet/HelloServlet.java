package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

//@WebServlet(urlPatterns = {"/servlet/hello", "/aaa/bbb/ccc", "/mypage/hello.asp"})
//@WebServlet(urlPatterns = "/servlet/hello") // 設定 HelloServlet 相關資訊
@WebServlet("/servlet/hello")
public class HelloServlet extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// 請求與回應文件編碼設定(中文支援)
		req.setCharacterEncoding("utf-8"); // res utf-8 編碼
		res.setCharacterEncoding("utf-8"); // res utf-8 編碼 
		res.setContentType("text/html;charset=utf-8"); // 回應文件 utf-8 編碼 (給前端判斷使用)
		
		// 請求相關程式 (取得使用者所帶入的參數)
		//String user = "John";
		String user = req.getParameter("username");

		// 回應相關程式 (回應使用者網頁,文字,檔案 etc...)
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.print("Hello ");
		out.print(user);
		out.print("<p />");
		out.println(new Date());
		out.println("</html>");
	}
	
}
