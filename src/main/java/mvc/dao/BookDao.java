package mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.entity.Book;

public class BookDao extends BaseDao {
	
	// 新增
	public int add(Book book) {
		int rowcount = 0;
		String sql = "insert into book(name, amount, price, user_id) " +
				     "values(?, ?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, book.getName());
			pstmt.setInt(2, book.getAmount());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getUserId());
			rowcount = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 修改
	public int update(Book book) {
		int rowcount = 0;
		String sql = "update book set name=?, amount=?, price=? where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, book.getName());
			pstmt.setInt(2, book.getAmount());
			pstmt.setInt(3, book.getPrice());
			pstmt.setInt(4, book.getId());
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 刪除
	public int delete(Integer id) {
		int rowcount = 0;
		String sql = "delete from book where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 查詢全部
	public List<Book> queryAll() {
		List<Book> books = new ArrayList<>();
		String sql = "select id, name, amount, price, user_id from book order by id";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			// 進行 O/R Mapping
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAmount(rs.getInt("amount"));
				book.setPrice(rs.getInt("price"));
				book.setUserId(rs.getInt("user_id"));
				// 將 book 紀錄注入到 books 的集合中
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;		
	}
	
	// 查詢全部(book庫存數量扣除購物車數量)
	public List<Book> queryBookCart() {
		List<Book> books = new ArrayList<>();
		String sql = "select id, name, amount, qty, new_amount, price, user_id from book_cart order by id";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			// 進行 O/R Mapping
			while(rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				//book.setAmount(rs.getInt("amount"));
				book.setAmount(rs.getInt("new_amount"));
				book.setPrice(rs.getInt("price"));
				book.setUserId(rs.getInt("user_id"));
				// 將 book 紀錄注入到 books 的集合中
				books.add(book);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return books;		
	}
	
	// 查詢單筆(根據 id)
	public Book get(Integer id) {
		Book book = null;
		String sql = "select id, name, amount, price, user_id from book where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			// 進行 O/R Mapping
			if(rs.next()) {
				book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setAmount(rs.getInt("amount"));
				book.setPrice(rs.getInt("price"));
				book.setUserId(rs.getInt("user_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
}
























