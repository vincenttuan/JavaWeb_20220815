package service;

import org.junit.Test;

import mvc.service.UserService;

public class UserServiceTest {
	
	@Test
	public void test() throws Exception {
		UserService userService = new UserService();
		int rowcount = userService.add("Helen", "1111", "60000");
		if(rowcount == 1) {
			System.out.println("新增成功");
		} else {
			throw new RuntimeException("新增失敗");
		}
	}
}
