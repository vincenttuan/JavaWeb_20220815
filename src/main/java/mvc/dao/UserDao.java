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
	
	
}
