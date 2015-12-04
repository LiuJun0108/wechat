package com.wechat.api;

import java.util.Arrays;

import com.wechat.api.util.EncryptUtil;

/**
 * ��֤��������ַ����Ч��
 * 
 * @author Jun.L
 *
 */
public class SignatureCheck {
	private String signature;

	public SignatureCheck(String signature) {
		this.signature = signature;
	}

	public boolean verify(String token, String timestamp, String nonce) {
		// 1. ��token��timestamp��nonce�������������ֵ�������
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr); // ��Ȼ����

		// 2. �����������ַ���ƴ�ӳ�һ���ַ�������sha1����
		StringBuilder sb = new StringBuilder();
		for (String str : arr) {
			sb.append(str);
		}

		String result = EncryptUtil.sha1(sb.toString());

		// 3. �����߻�ü��ܺ���ַ�������signature�Աȣ���ʶ��������Դ��΢��
		if (signature != null) {
			return signature.toUpperCase().equals(result);
		}
		return false;
	}
}
