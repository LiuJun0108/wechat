package com.wechat.api;

import java.util.Arrays;

import com.wechat.api.util.EncryptUtil;

/**
 * 验证服务器地址的有效性
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
		// 1. 将token、timestamp、nonce三个参数进行字典序排序
		String[] arr = new String[] { token, timestamp, nonce };
		Arrays.sort(arr); // 自然排序

		// 2. 将三个参数字符串拼接成一个字符串进行sha1加密
		StringBuilder sb = new StringBuilder();
		for (String str : arr) {
			sb.append(str);
		}

		String result = EncryptUtil.sha1(sb.toString());

		// 3. 开发者获得加密后的字符串可与signature对比，标识该请求来源于微信
		if (signature != null) {
			return signature.toUpperCase().equals(result);
		}
		return false;
	}
}
