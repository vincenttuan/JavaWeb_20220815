package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.LottoService;

@WebServlet("/servlet/lotto")
public class LottoServlet extends HttpServlet {
	
	private LottoService lottoService = new LottoService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 透過分派器將資料傳遞給 /WEB-INF/view/lotto_form.jsp 來呈現資訊
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/lotto_form.jsp");
		// 準備要傳送給 lotto_form.jsp 來呈現的資料
		req.setAttribute("lottos", lottoService.getLottos());
		// 執行內部重導
		rd.forward(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 取得表單傳來的使用者姓名
		String username = req.getParameter("username");
		// 透過 lottoService 取得 lotto 號碼
		List<Integer> nums = lottoService.getLotto();
		
		// 透過分派器將資料傳遞給 /WEB-INF/view/lotto_result.jsp 來呈現資訊
		RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/lotto_result.jsp");
		// 準備要傳送給 lotto_result.jsp 來呈現的資料
		req.setAttribute("username", username);
		req.setAttribute("nums", nums);
		req.setAttribute("lottos", lottoService.getLottos());
		// 執行內部重導
		rd.forward(req, resp); // 執行內部重導(重導到 /WEB-INF/view/lotto_result.jsp)
		
	}
	
}
