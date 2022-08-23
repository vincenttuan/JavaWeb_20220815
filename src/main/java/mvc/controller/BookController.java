package mvc.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

@WebServlet("/mvc/book/*")
public class BookController extends HttpServlet {
	
	private String getPathVariable(HttpServletRequest req) {
		// 取得 path info 資料
		String pathInfo = req.getPathInfo();
		// 去除 path info 的前導 "/" 變為 path variable
		String pathVariable = pathInfo.replace("/", "");
		// 去除 * 號
		pathVariable = pathVariable.replace("*", "");
		return pathVariable;
	}
	
	/*
	 * 查詢全部: /mvc/book/ 或 /mvc/book/*
	 * 查詢單筆: /mvc/book/1
	 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathVar = getPathVariable(req);
		if(pathVar.length() == 0) {
			resp.getWriter().println("doGet() 全部查詢資料用 <br />");
		} else {
			// 利用 allMatch(Character::isDigit) 檢查字串是否是一個數字
			boolean isNumeric = pathVar.chars().allMatch(Character::isDigit);
			if(isNumeric) {
				Integer id = Integer.parseInt(pathVar);
				resp.getWriter().println("doGet() 單筆查詢資料用, id = " + id  + "<br />");
			} else {
				resp.getWriter().println("請輸入要查詢的 id (必須是數字) <br />");
			}
		}
	}
	
	/*
	 * 新增: /mvc/book/
	 * 資料由表單帶入
	 * */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得表單資料
		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String amount = req.getParameter("amount");
		String price = req.getParameter("price");
		resp.getWriter().print("doPost() 新增資料用 <br />");
		resp.getWriter().print("id: " +  id + "<br />");
		resp.getWriter().print("name: " +  name + "<br />");
		resp.getWriter().print("amount: " +  amount + "<br />");
		resp.getWriter().print("price: " +  price + "<br />");
	}
	
	/*
	 * 修改: /mvc/book/1 或 /mvc/book/
	 * 資料由表單帶入
	 * */
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathVar = getPathVariable(req);
		boolean isNumeric = pathVar.chars().allMatch(Character::isDigit);
		if(pathVar.length() > 0 && isNumeric) {
			Integer id = Integer.parseInt(pathVar);
			resp.getWriter().println("doPut() 修改資料用, id = " + id  + "<br />");
			// doPut() 無法透過 req.getParameter() 取得表單資料
			String formData = IOUtils.toString(req.getInputStream(), StandardCharsets.UTF_8);
			resp.getWriter().println("formData: " + formData  + "<br />");
			// formData: id=3&name=Java8&amount=200&price=750
			// 透過 & 切成陣列: ["id=3", "name=Java8", "amount=200", "price=750"]
			// 轉成 map 格式 {"id":"3", "name":"Java8", "amount":"200", "price":"750"}
			Map<String, String> map = new LinkedHashMap<>();			
			String[] array = formData.split("&");
			for(String row: array) {
				String[] entry = row.split("=");
				String key = entry[0];
				String value = entry[1];
				map.put(key, value);
			}
			String name = map.get("name");
			String amount = map.get("amount");
			String price = map.get("price");
			resp.getWriter().print("name: " +  name + "<br />");
			resp.getWriter().print("amount: " +  amount + "<br />");
			resp.getWriter().print("price: " +  price + "<br />");
			
		} else {
			resp.getWriter().println("請輸入要修改的 id (必須是數字) <br />");
		}
	}
	
	/*
	 * 刪除單筆: /mvc/book/1
	 * */
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathVar = getPathVariable(req);
		boolean isNumeric = pathVar.chars().allMatch(Character::isDigit);
		if(pathVar.length() > 0 && isNumeric) {
			Integer id = Integer.parseInt(pathVar);
			resp.getWriter().println("doDelete() 單筆刪除資料用, id = " + id  + "<br />");
		} else {
			resp.getWriter().println("請輸入要刪除的 id (必須是數字) <br />");
		}
	}
	
}
