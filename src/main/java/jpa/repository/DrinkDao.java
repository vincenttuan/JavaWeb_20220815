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
	
	// 全部查詢
	public List<Drink> query() {
		//Query query = em.createQuery("from Drink d", Drink.class); // JPQL
		Query query = em.createQuery("select d from Drink d"); // JPQL
		List<Drink> drinks = query.getResultList();
		return drinks;
	}
}
