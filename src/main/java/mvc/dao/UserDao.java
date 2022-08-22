package mvc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import mvc.entity.User;

public class UserDao {
	
	private static Connection conn;
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String db_url = "jdbc:mysql://localhost:3306/web?serverTimezone=Asia/Taipei&characterEncoding=utf-8&useUnicode=true";
			String db_username = "root";
			String db_password = "12345678";
			conn = DriverManager.getConnection(db_url, db_username, db_password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 新增
	public int add(User user) {
		int rowcount = 0;
		String sql = "insert into user(username, password, salary) values(?, ?, ?)";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setBytes(3, user.getSalary());
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 修改
	public int update(User user) {
		int rowcount = 0;
		String sql = "update user set username=?, salary=? where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, user.getUsername());
			pstmt.setBytes(2, user.getSalary());
			pstmt.setInt(3, user.getId());
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 修改密碼
	public int updatePassword(Integer id, String new_password) {
		int rowcount = 0;
		String sql = "update user set password=? where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, new_password);
			pstmt.setInt(2, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 刪除
	public int delete(Integer id) {
		int rowcount = 0;
		String sql = "delete from user where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			rowcount = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowcount;
	}
	
	// 查詢全部
	public List<User> queryAll() {
		List<User> users = new ArrayList<>();
		String sql = "select id, username, password, salary, createtime from user order by id";
		try(Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);) {
			
			while (rs.next()) {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSalary(rs.getBytes("salary"));
				user.setCreatetime(rs.getTimestamp("createtime"));
				// 將 user 紀錄注入到 users 集合中
				users.add(user);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return users;
	}
	
	// 查詢單筆(根據 id)
	public User get(Integer id) {
		User user = null;
		String sql = "select id, username, password, salary, createtime from user where id=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { // 是否有查到資料
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSalary(rs.getBytes("salary"));
				user.setCreatetime(rs.getTimestamp("createtime"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	// 查詢單筆(根據 username)
	public User get(String username) {
		User user = null;
		String sql = "select id, username, password, salary, createtime from user where username=?";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)) {
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) { // 是否有查到資料
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
				user.setSalary(rs.getBytes("salary"));
				user.setCreatetime(rs.getTimestamp("createtime"));
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
