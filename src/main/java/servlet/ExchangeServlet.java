package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import yahoofinance.YahooFinance;

@WebServlet("/servlet/exchange")
public class ExchangeServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int amount = Integer.parseInt(req.getParameter("amount"));
		String currency = req.getParameter("currency");
		
		System.out.println(amount);
		System.out.println(currency);
		
		// 得到匯率(使用 YahooFinance Java API)
		String symbol = "TWD" + currency + "=x"; // 例如: TWDUSD=x, TWDJPY=x ...
		System.out.println(symbol);
		
		double rate = YahooFinance.get(symbol).getQuote().getPrice().doubleValue();
		System.out.println(rate);
		
		// 計算結果
		double result = amount * rate;
		System.out.println(result);
		
		// 透過分派器將資料傳遞給 /form/exchange_form.jsp
		// 1. 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/form/exchange_form.jsp");
		// 2. 新增要傳遞的參數
		req.setAttribute("amount", amount);
		req.setAttribute("currency", currency);
		req.setAttribute("result", result);
		// 3. 重導到指定頁面
		rd.forward(req, resp);
	}
	
}
