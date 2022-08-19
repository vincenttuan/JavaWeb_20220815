package mvc.service;

import java.security.MessageDigest;

public class BaseService {
	protected String path; // 密鑰位置
	protected MessageDigest md5; // 建立 MD5 加密服務
	protected EncryptDESService des; // 建立 DES 加密服務
	
	public BaseService() {
		path = "src/main/java/mvc/key/user.key"; // 密鑰位置
		des = new EncryptDESService(); // 建立 DES 加密服務
		try {
			des.genKey(path); // 產生或使用密鑰
			md5 = MessageDigest.getInstance("MD5"); // 產生或使用密鑰
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
