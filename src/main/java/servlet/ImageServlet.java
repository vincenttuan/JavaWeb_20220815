package servlet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 將放在 C:\Users\MB-207\Pictures\f18.jpg 的圖片透過 ImageServlet 顯示給前端
 * 將放在 C:\Users\MB-207\Pictures\f16.jpg 的圖片透過 ImageServlet 顯示給前端
 * 瀏覽器可以透過 http://../servlet/image?name=f18 路徑得到此圖
 * 瀏覽器可以透過 http://../servlet/image?name=f16 路徑得到此圖
 * */
@WebServlet("/servlet/image")
public class ImageServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("image/jpg");
		
		String name = req.getParameter("name");
		if(name == null || name.trim().length() == 0) { // 若網址上沒有給定 name 參數
			name = "f18"; // 預設
		}
		
		String imagePath = "C:/Users/MB-207/Pictures/%s.jpg";
		imagePath = String.format(imagePath, name);
		
		Path path = Paths.get(imagePath);
		ServletOutputStream out = resp.getOutputStream();
		Files.copy(path, out); // (path 來源端,  out 目的端)
		out.close();
	}
	
	
	
}
