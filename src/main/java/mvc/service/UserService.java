package mvc.service;

import java.math.BigInteger;
import java.security.MessageDigest;

import mvc.dao.UserDao;
import mvc.entity.User;

public class UserService extends BaseService {
	
	private UserDao userDao = new UserDao(); // User 資料庫存取服務
	
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
		UserDao userDao = new UserDao();
		int rowcount =  userDao.add(user);
		return rowcount;
	}
	
}
