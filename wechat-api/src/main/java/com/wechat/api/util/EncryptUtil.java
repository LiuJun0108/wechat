package com.wechat.api.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * ���ܹ���
 * 
 * @author Jun.L
 *
 */
public class EncryptUtil {
	public static String sha1(String strSrc) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			// �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
			byte[] digest = md.digest(strSrc.getBytes());
			return byteToStr(digest);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * ���ֽ�����ת��Ϊʮ�������ַ���
	 * 
	 * @param byteArray
	 * @return
	 */
	private static String byteToStr(byte[] byteArray) {
		String strDigest = "";
		for (int i = 0; i < byteArray.length; i++) {
			strDigest += byteToHexStr(byteArray[i]);
		}
		return strDigest;
	}

	/**
	 * ���ֽ�ת��Ϊʮ�������ַ���
	 * 
	 * @param mByte
	 * @return
	 */
	private static String byteToHexStr(byte mByte) {
		char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
				'B', 'C', 'D', 'E', 'F' };
		char[] tempArr = new char[2];
		tempArr[0] = Digit[(mByte >>> 4) & 0X0F];
		tempArr[1] = Digit[mByte & 0X0F];

		String s = new String(tempArr);
		return s;
	}

	public static void main(String[] args) {
		String str = sha1("abc");
		System.out.println(str);
	}
}