package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

public class LottoService {
	
	private static List<List<Integer>> lottos = new CopyOnWriteArrayList<>();
	
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
	
	// 修改 lotto 資料
	public void updateLotto(int index) {
		// 重新產生一組號碼
		Random random = new Random();
		List<Integer> nums = new ArrayList<>();
		for(int i=0;i<4;i++) {
			nums.add(random.nextInt(10));  // 0~9
		}
		// 置換資料
		// 將 lottos 位於 index 位置的資料置換成新資料 nums
		lottos.set(index, nums);
	}
	
	// 刪除 lotto 資料
	public void deleteLotto(int index) {
		// 刪除指定位置資料
		lottos.remove(index);
	}
	

}
