package dao;

import org.junit.Test;
import mvc.dao.UserDao;

public class UserDaoTest2 {
	@Test
	public void test() throws Exception {
		
		UserDao userDao = new UserDao();
		System.out.println(userDao.queryAll());
	}
}
