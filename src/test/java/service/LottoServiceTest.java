package service;

import org.junit.Test;

public class LottoServiceTest {
	
	@Test
	public void test() {
		LottoService service = new LottoService();
		System.out.println(service.getLotto());
		System.out.println(service.getLotto());
		System.out.println(service.getLotto());
		System.out.println(service.getLottos());
	}
	
}
