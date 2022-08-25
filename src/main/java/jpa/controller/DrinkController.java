package jpa.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import jpa.entity.Drink;
import jpa.service.DrinkService;

@WebServlet("/jpa/drink/*")
public class DrinkController extends HttpServlet {
	
	private DrinkService drinkService = new DrinkService();
	private Gson gson = new Gson();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Drink> drinks = drinkService.findAll();
		// 將 drinks 集合物件轉 json 字串
		String jsonStr = gson.toJson(drinks);
		// 將 json 字串回應給前端
		resp.getWriter().print(jsonStr);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得表單參數
		String name = req.getParameter("name");
		String amount = req.getParameter("amount");
		String price = req.getParameter("price");
		// 新增程序
		boolean isSuccess = drinkService.append(name, amount, price);
		// 將 status 物件轉 json 字串
		Status status = new Status("append", isSuccess);
		String jsonStr = gson.toJson(status);
		// 將 json 字串回應給前端
		resp.getWriter().print(jsonStr);
	}
	
	// 狀態的物件回應
	class Status {
		String name;
		boolean isSuccess;
		public Status(String name, boolean isSuccess) {
			super();
			this.name = name;
			this.isSuccess = isSuccess;
		}
	}
	
}
