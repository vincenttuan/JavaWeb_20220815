package mvc.service;

import java.math.BigInteger;
import java.security.MessageDigest;

// MD5 加密與比對
public class MD5DigestService {
	// 取得加密資料
	public static String getEncryptString(String input) {
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5"); // MD5, SHA1
			byte[] result = md5.digest(input.getBytes());
			// 16 進位字串格式(32個字不足補0)
			String output = String.format("%032X", new BigInteger(result));
			return output;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	// 比對加密資料
	public static boolean equals(String input, String encryptString) {
		String inputEncryptString = getEncryptString(input);
		return inputEncryptString.equals(encryptString);
	}
}
