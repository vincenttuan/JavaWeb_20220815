package security;

import java.math.BigInteger;
import java.util.Arrays;

import mvc.service.EncryptDESService;

public class EncrypDESServiceTest {
	public static void main(String[] args) throws Exception {
		String path = "src/main/java/mvc/key/user.key"; // 密鑰位置
		EncryptDESService de1 = new EncryptDESService(); // 建立 DES 加密服務
		de1.genKey(path); // 產生或使用密鑰
		
		// 明文
		String msg = "巨匠電腦 Java 課程";
		System.out.println("明文是:" + msg);
		
		// 加密
		byte[] encontent = de1.encrytor(msg); // 將明文進行加密 , encontent 會存放在資料表欄位中
		System.out.println("加密後:" + Arrays.toString(encontent));
		System.out.println("加密後(16進位):" + String.format("%X", new BigInteger(encontent)));
		
		// 解密
		byte[] decontent = de1.decryptor(encontent); // 將加密的內容進行解密
		System.out.println("解密後:" + new String(decontent));
	}
}
