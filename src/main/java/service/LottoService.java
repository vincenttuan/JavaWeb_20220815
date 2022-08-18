package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class LottoService {
	
	private List<List<Integer>> lottos = new CopyOnWriteArrayList<>();
	
	// 四星採電腦選號
	public List<Integer> getLotto() {
		Random random = new Random();
		List<Integer> nums = new ArrayList<>();
		for(int i=0;i<4;i++) {
			nums.add(random.nextInt(10));  // 0~9
		}
		lottos.add(nums); // 將每一次的 nums 放入到 lottos 裡記錄起來
		return nums;
	}
	
	// 取得所有 lotts 紀錄
	public List<List<Integer>> getLottos() {
		return lottos;
	}

}
