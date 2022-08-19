package security;

import org.junit.Test;

import mvc.service.MD5DigestService;

public class MD5DigestServiceTest {
	
	@Test
	public void test() {
		String input = "168"; // 使用者輸入的密碼
		// 假設 encryptString 是存放在資料欄位中的密碼
		String encryptString = "006F52E9102A8D3BE2FE5614F42BA989";
		// 資料比對
		System.out.println(MD5DigestService.equals(input, encryptString));
	}
	
}
