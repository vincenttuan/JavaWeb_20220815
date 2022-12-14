package jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import jpa.entity.Drink;

public class DrinkDao {
	
	private static EntityManagerFactory emf;
	private EntityManager em;
	
	public DrinkDao() {
		if(emf == null) {
			emf = Persistence.createEntityManagerFactory("demo");
		}
		em = emf.createEntityManager();
	}
	
	// 新增
	public synchronized boolean add(Drink drink) {
		EntityTransaction etx = em.getTransaction(); // 取得交易環境進行新增,修改,刪除工作
		etx.begin(); // 交易開始
		em.persist(drink); // 將 drink 物件進行永續(將 drink 存放到資料表的紀錄中)
		etx.commit(); // 提交(交易結束)
		return true;
	}
	
	// 修改
	public synchronized boolean update(Drink drink) {
		// 先判斷有無此筆資料
		if(get(drink.getId()) == null) {
			return false;
		} else {
			EntityTransaction etx = em.getTransaction(); // 取得交易環境進行新增,修改,刪除工作
			etx.begin(); // 交易開始
			em.merge(drink); // 將 drink 物件進行永續(將 drink 存放到資料表的紀錄中)
			etx.commit(); // 提交(交易結束)
			return true;
		}
	}
	
	// 刪除
	public synchronized boolean delete(Integer id) {
		// 先判斷有無此筆資料
		Drink drink = get(id);
		if(drink == null) {
			return false;
		} else {
			EntityTransaction etx = em.getTransaction(); // 取得交易環境進行新增,修改,刪除工作
			etx.begin(); // 交易開始
			em.remove(drink); // 將 drink 紀錄移除
			etx.commit(); // 提交(交易結束)
			return true;
		}
	}
	
	// 單筆查詢
	public Drink get(Integer id) {
		return em.find(Drink.class, id);
	}
	
	// 全部查詢
	public List<Drink> query() {
		//Query query = em.createQuery("from Drink d", Drink.class); // JPQL
		Query query = em.createQuery("select d from Drink d"); // JPQL
		List<Drink> drinks = query.getResultList();
		return drinks;
	}
}
