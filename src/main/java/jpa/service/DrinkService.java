package jpa.service;

import jpa.entity.Drink;
import jpa.repository.DrinkDao;

public class DrinkService {
	
	private DrinkDao drinkDao = new DrinkDao();
	
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
	
}
