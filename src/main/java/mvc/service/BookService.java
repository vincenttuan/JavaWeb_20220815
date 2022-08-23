package mvc.service;

import java.util.List;

import mvc.dao.BookDao;
import mvc.entity.Book;

public class BookService {
	
	private BookDao bookDao = new BookDao(); // book 資料表存取服務
	
	// 新增 book
	public int add(String name, Integer amount, Integer price, Integer user_id) {
		Book book = new Book();
		book.setName(name);
		book.setAmount(amount);
		book.setPrice(price);
		book.setUserId(user_id);
		return bookDao.add(book);
	}
	
	public int add(String name, String amount, String price, Integer user_id) {
		if (!amount.chars().allMatch(Character::isDigit) || 
			!price.chars().allMatch(Character::isDigit)) {
			return 0;
		}
		return add(name, Integer.parseInt(amount), Integer.parseInt(price), user_id);
	}
	
	// 修改
	public int update(Integer id, String name, Integer amount, Integer price) {
		Book book = new Book();
		book.setId(id);
		book.setName(name);
		book.setAmount(amount);
		book.setPrice(price);
		return bookDao.update(book);
	}
	
	public int update(Integer id, String name, String amount, String price) {
		if (!amount.chars().allMatch(Character::isDigit) || 
			!price.chars().allMatch(Character::isDigit)) {
				return 0;
		}
		return update(id, name, Integer.parseInt(amount), Integer.parseInt(price));
	}
	
	// 刪除
	public int delete(Integer id) {
		return bookDao.delete(id);
	}
	
	// 查詢所有 book
	public List<Book> queryAll() {
		return bookDao.queryAll();
	}
	
	// 查詢單筆 book
	public Book get(Integer id) {
		return bookDao.get(id);
	}
	
}











