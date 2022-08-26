package mvc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import mvc.entity.Cart;

public class CartDao extends BaseDao {
	
	// 新增
	public int add(Cart cart) {
		int rowcount = 0;
		String sql = "insert into cart(user_id, book_id, qty, subtotal) " +
				     "values(?, ?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getBookId());
			pstmt.setInt(3, cart.getQty());
			pstmt.setInt(4, cart.getSubtotal());
			rowcount = pstmt.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 修改
	public int update(Cart cart) {
		int rowcount = 0;
		String sql = "update cart set user_id=?, book_id=?, qty=?, subtotal=? where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, cart.getUserId());
			pstmt.setInt(2, cart.getBookId());
			pstmt.setInt(3, cart.getQty());
			pstmt.setInt(4, cart.getSubtotal());
			pstmt.setInt(5, cart.getId());
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 刪除
	public int delete(Integer id) {
		int rowcount = 0;
		String sql = "delete from cart where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 查詢全部 I
	public List<Cart> queryAll() {
		List<Cart> carts = new ArrayList<>();
		String sql = "select id, user_id, book_id, qty, subtotal, createtime from cart order by id";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			// 進行 O/R Mapping
			while(rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("user_id"));
				cart.setBookId(rs.getInt("book_id"));
				cart.setQty(rs.getInt("qty"));
				cart.setSubtotal(rs.getInt("subtotal"));
				cart.setCreatetime(rs.getTimestamp("createtime"));
				// 將 cart 紀錄注入到 carts 的集合中
				carts.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;		
	}
	
	// 查詢全部 II
	public List<Cart> queryAll(Integer userId) {
		List<Cart> carts = new ArrayList<>();
		String sql = "select id, user_id, book_id, qty, subtotal, createtime from cart where user_id=? order by id";
		System.out.println(sql);
		System.out.println(userId);
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, userId);
			ResultSet rs = pstmt.executeQuery();
			// 進行 O/R Mapping
			while(rs.next()) {
				Cart cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("user_id"));
				cart.setBookId(rs.getInt("book_id"));
				cart.setQty(rs.getInt("qty"));
				cart.setSubtotal(rs.getInt("subtotal"));
				cart.setCreatetime(rs.getTimestamp("createtime"));
				// 將 cart 紀錄注入到 carts 的集合中
				carts.add(cart);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return carts;		
	}
	
	// 查詢單筆(根據 id)
	public Cart get(Integer id) {
		Cart cart = null;
		String sql = "select id, user_id, book_id, qty, subtotal, createtime from cart where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			// 進行 O/R Mapping
			if(rs.next()) {
				cart = new Cart();
				cart.setId(rs.getInt("id"));
				cart.setUserId(rs.getInt("user_id"));
				cart.setBookId(rs.getInt("book_id"));
				cart.setQty(rs.getInt("qty"));
				cart.setSubtotal(rs.getInt("subtotal"));
				cart.setCreatetime(rs.getTimestamp("createtime"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cart;
	}
	
}
