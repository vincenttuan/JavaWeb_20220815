package security;

import java.math.BigInteger;
import java.util.Arrays;

import mvc.service.EncryptDESService;

public class EncrypDESServiceTest {
	public static void main(String[] args) throws Exception {
		String path = "src/main/java/mvc/key/user.key";
		EncryptDESService de1 = new EncryptDESService();
		de1.genKey(path);

		String msg = "巨匠電腦 Java 課程";
		byte[] encontent = de1.encrytor(msg); // 加密
		byte[] decontent = de1.decryptor(encontent); // 解密
		System.out.println("明文是:" + msg);
		System.out.println("加密後:" + Arrays.toString(encontent));
		System.out.println("加密後(16進位):" + String.format("%X", new BigInteger(encontent)));
		System.out.println("解密後:" + new String(decontent));
	}
}
