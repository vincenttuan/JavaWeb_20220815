package jpa.entity;

import java.io.Serializable;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "drink")  // 對應的資料表名稱
public class Drink implements Serializable {

	// 序列化的版號
	private static final long serialVersionUID = 1L;
	
	@Id // 主鍵欄位
	@GeneratedValue(strategy = GenerationType.AUTO) // 設定自動序號更新
	private Integer id; // 序號
	
	@Column(name = "name", length = 50, nullable = false, unique = true) // 資料欄位
	private String name; // 飲料名稱
	
	@Column(name = "amount", nullable = false) // 資料欄位
	private Integer amount; // 飲料數量
	
	@Column(name = "price", nullable = false) // 資料欄位
	private Integer price; // 飲料價格

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Drink [id=" + id + ", name=" + name + ", amount=" + amount + ", price=" + price + "]";
	}
	
}
