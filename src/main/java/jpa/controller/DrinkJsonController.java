package jpa.controller;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.google.gson.Gson;

import jpa.entity.Drink;
import jpa.service.DrinkService;

@WebServlet("/jpa/json/drink/*")
public class DrinkJsonController extends HttpServlet {
	
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
		// 取得 drink 物件
		Drink drink = getDrinkFromJson(req);
		// 建立回應資訊
		Status status = null;
		try {
			// 新增程序
			boolean isSuccess = drinkService.append(drink);
			// 將 status 物件轉 json 字串
			status = new Status("append", isSuccess);
			
		} catch (Exception e) {
			status = new Status("append", false);
			status.message = e.getMessage();
		}
		String jsonStr = gson.toJson(status);
		// 將 json 字串回應給前端
		resp.getWriter().print(jsonStr);
	}
	
	// 路徑範例: /jpa/drink/1
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = getPathVariable(req);
		// 取得 drink 物件
		Drink drink = getDrinkFromJson(req);
		Status status = null;
		try {
			// 修改程序
			boolean isSuccess = drinkService.modify(id, drink);
			// 將 status 物件轉 json 字串
			status = new Status("update", isSuccess);
		} catch (Exception e) {
			status = new Status("update", false);
			status.message = e.getMessage();
		}
		String jsonStr = gson.toJson(status);
		// 將 json 字串回應給前端
		resp.getWriter().print(jsonStr);
	}

	// 路徑範例: /jpa/drink/1
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = getPathVariable(req);
		// 刪除程序
		boolean isSuccess = drinkService.remove(id);
		// 將 status 物件轉 json 字串
		Status status = new Status("delete", isSuccess);
		String jsonStr = gson.toJson(status);
		// 將 json 字串回應給前端
		resp.getWriter().print(jsonStr);
	}

	// 狀態的物件回應
	class Status {
		String name;
		boolean isSuccess;
		String message;
		public Status(String name, boolean isSuccess) {
			this.name = name;
			this.isSuccess = isSuccess;
		}
	}
	
	private String getPathVariable(HttpServletRequest req) {
		// 取得 path info 資料
		String pathInfo = req.getPathInfo();
		// 去除 path info 的前導 "/" 變為 path variable
		String pathVariable = pathInfo.replace("/", "");
		// 去除 * 號
		pathVariable = pathVariable.replace("*", "");
		return pathVariable;
	}
	
	// 根據前端傳來的 json 資料轉為 drink 物件
	private Drink getDrinkFromJson(HttpServletRequest req) throws IOException {
		// 透過資料串流來取得 json 字串資料
		String jsonString = IOUtils.toString(req.getInputStream(), StandardCharsets.UTF_8);
		// 將 json 字串轉為 drink 物件
		Drink drink = gson.fromJson(jsonString, Drink.class);
		return drink;
	}
	
}
