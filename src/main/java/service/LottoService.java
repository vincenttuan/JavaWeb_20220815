package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LottoService {
	
	// 四星採電腦選號
	public List<Integer> getLotto() {
		Random random = new Random();
		List<Integer> nums = new ArrayList<>();
		for(int i=0;i<4;i++) {
			nums.add(random.nextInt(10));  // 0~9
		}
		return nums;
	}

}
