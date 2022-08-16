package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servlet/bmi")
public class BMIServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 請求與回應文件編碼設定(中文支援)
		req.setCharacterEncoding("utf-8"); // req utf-8 編碼
		resp.setCharacterEncoding("utf-8"); // resp utf-8 編碼 
		resp.setContentType("text/html;charset=utf-8"); // 回應文件 utf-8 編碼 (給前端判斷使用)
		// 取得表單資料
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		// 資料整理/處理
		double h = Double.parseDouble(height);
		double w = Double.parseDouble(weight);
		// 商業邏輯處理(計算 bmi 值)
		double bmi = w / Math.pow(h/100, 2);
		// 回應結果
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("BMI 計算結果: ");
		out.println(String.format("%.2f", bmi));
		out.println("</html>");
	}
	
}
