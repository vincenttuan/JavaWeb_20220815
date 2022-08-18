package service;

import org.junit.Test;

public class TestLottoService {
	
	@Test
	public void test() {
		LottoService service = new LottoService();
		System.out.println(service.getLotto());
	}
	
}
