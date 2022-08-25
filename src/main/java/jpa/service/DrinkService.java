package jpa.service;

import java.util.List;

import jpa.entity.Drink;
import jpa.repository.DrinkDao;

public class DrinkService {
	
	private DrinkDao drinkDao = new DrinkDao();
	
	// 新增 I
	public boolean append(String name, String amount, String price) {
		// 資料驗證
		if(name == null || name.length() == 0 || 
			amount == null || price == null || 
			!amount.chars().allMatch(Character::isDigit) || 
			!price.chars().allMatch(Character::isDigit)) {
			return false;
		}
		// 建立 drink 物件
		Drink drink = new Drink();
		drink.setName(name);
		drink.setAmount(Integer.parseInt(amount));
		drink.setPrice(Integer.parseInt(price));
		// 進行儲存 (isSuccess 是否成功 ?)
		boolean isSuccess = drinkDao.add(drink);
		return isSuccess;
	}
	
	// 新增 II
	public boolean append(Drink drink) {
		// 進行儲存 (isSuccess 是否成功 ?)
		boolean isSuccess = drinkDao.add(drink);
		return isSuccess;
	}
	
	// 修改 I
	public boolean modify(String id, String name, String amount, String price) {
		// 資料驗證
		if(id == null || name == null || name.length() == 0 || 
			amount == null || price == null || 
			!id.chars().allMatch(Character::isDigit) || 
			!amount.chars().allMatch(Character::isDigit) || 
			!price.chars().allMatch(Character::isDigit)) {
			return false;
		}
		// 建立 drink 物件
		Drink drink = new Drink();
		drink.setId(Integer.parseInt(id)); // 需要放入 id
		drink.setName(name);
		drink.setAmount(Integer.parseInt(amount));
		drink.setPrice(Integer.parseInt(price));
		// 進行修改 (isSuccess 是否成功 ?)
		boolean isSuccess = drinkDao.update(drink);
		return isSuccess;
	}
	
	// 修改 II
	public boolean modify(Drink drink) {
		// 進行修改 (isSuccess 是否成功 ?)
		boolean isSuccess = drinkDao.update(drink);
		return isSuccess;
	}
	
	// 刪除
	public boolean remove(String id) {
		// 資料驗證
		if(id == null || !id.chars().allMatch(Character::isDigit)) {
			return false;
		}
		// 進行移除 (isSuccess 是否成功 ?)
		boolean isSuccess = drinkDao.delete(Integer.parseInt(id));
		return isSuccess;
	}
	
	// 查詢全部
	public List<Drink> findAll() {
		return drinkDao.query();
	}
	
}
