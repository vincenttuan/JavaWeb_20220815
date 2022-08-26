package mvc.service;

import java.util.List;

import mvc.dao.BookDao;
import mvc.dao.CartDao;
import mvc.entity.Book;
import mvc.entity.Cart;

public class CartService {
	
	private CartDao cartDao = new CartDao(); // cart 資料表存取服務
	private BookDao bookDao = new BookDao(); // book 資料表存取服務
	
	// 新增 cart
	public int add(Integer userId, Integer bookId, Integer qty) {
		// 先取得書籍資訊(計算 subtotal 使用)
		Book book = bookDao.get(bookId);
		// 建構購物車資料
		Cart cart = new Cart();
		cart.setUserId(userId);
		cart.setBookId(bookId);
		cart.setQty(qty);
		cart.setSubtotal(qty * book.getPrice());
		return cartDao.add(cart);
	}
	
	// 刪除
	public int delete(Integer id) {
		Cart cart = cartDao.get(id);
		int bookId = cart.getBookId(); 
		int qty = cart.getQty();
		int rowcount = cartDao.delete(id);
		return rowcount;
	}
	
	// 查詢所有 cart by userId
	public List<Cart> queryAll(Integer userId) {
		return cartDao.queryAll(userId);
	}
	
}











