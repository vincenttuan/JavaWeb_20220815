package mvc.service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;

import org.apache.el.stream.Stream;

import mvc.dao.UserDao;
import mvc.entity.User;

public class UserService extends BaseService {
	
	private UserDao userDao = new UserDao(); // User 資料庫存取服務
	
	public int changePassword(String id, String password, String new_password) {
		// 根據 id 得到 user 物件 
		User user = get(Integer.parseInt(id));
		if(user == null) return 0;
		// 驗證 password
		byte[] result = md5.digest(password.getBytes());
		String encryptPassword = String.format("%032X", new BigInteger(result));
		if(!user.getPassword().equals(encryptPassword)) { // 舊密碼不相同
			return 0;
		}
		// 將 new_password 取代舊有的 password並將新密碼加密
		result = md5.digest(new_password.getBytes());
		encryptPassword = String.format("%032X", new BigInteger(result));
		return userDao.updatePassword(user.getId(), encryptPassword);
	}
	
	// 新增 user (含加密資料)
	public int add(String username, String password, String salary) throws Exception {
		User user = new User();
		// 1. 放入明文 username
		user.setUsername(username);
		
		// 2. 放入加密過後的 password
		byte[] result = md5.digest(password.getBytes());
		String encryptPassword = String.format("%032X", new BigInteger(result));
		user.setPassword(encryptPassword);
		
		// 3. 放入加密過後的 salary
		byte[] encryptSalary = des.encrytor(salary);
		user.setSalary(encryptSalary);
		
		// 4. 加入到資料庫中
		int rowcount =  userDao.add(user);
		return rowcount;
	}
	
	// 修改 user (含加密資料)
	public int update(String id, String username, String salary) throws Exception {
		User user = new User();
		user.setId(Integer.parseInt(id)); // 轉型要修改的 id
		
		// 1. 放入明文 username
		user.setUsername(username);
			
		// 2. 放入加密過後的 salary
		byte[] encryptSalary = des.encrytor(salary);
		user.setSalary(encryptSalary);
			
		// 3. 修改程序
		int rowcount =  userDao.update(user); // 修改
		return rowcount;
	}
	
	// 刪除
	public int delete(Integer id) {
		int rowcount =  userDao.delete(id);
		return rowcount;
	}
	
	// 刪除
	public int delete(String id) {
		int rowcount =  delete(Integer.parseInt(id));
		return rowcount;
	}
	
	// 查詢所有 user
	public List<User> queryAll() {
		List<User> users = userDao.queryAll();
		// 將 salary 內容解密
		for(User user : users) {
			try {
				byte[] decrypt = des.decryptor(user.getSalary()); // 解密
				user.setSalaryDecrypt(new String(decrypt)); // 轉字串後設定
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	// 查詢單筆 user
	public User get(Integer id) {
		User user = userDao.get(id);
		if(user != null) {
			// 將 salary 內容解密
			try {
				byte[] decrypt = des.decryptor(user.getSalary()); // 解密
				user.setSalaryDecrypt(new String(decrypt)); // 轉字串後設定
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return user;
	}
	
	// checkLogin
	public User checkLogin(String usename, String password) {
		if(usename == null || password == null || usename.trim().length() == 0 || password.trim().length() == 0) {
			return null;
		}
		User user = userDao.get(usename);
		if(user == null) {
			return null;
		}
		
		// 比對表單輸入的密碼加密之後是否等於資料表中密碼欄位的加密資料
		byte[] result = md5.digest(password.getBytes());
		String encryptPassword = String.format("%032X", new BigInteger(result));
		
		return encryptPassword.equals(user.getPassword()) ? user : null;
		
	}
}
