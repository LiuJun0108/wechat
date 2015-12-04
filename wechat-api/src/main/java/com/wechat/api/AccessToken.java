package com.wechat.api;

import net.sf.json.JSONObject;

import com.wechat.api.result.AccessTokenResult;
import com.wechat.api.util.HttpUtil;
import com.wechat.api.util.PropertiesUtil;

/**
 * ªÒ»°access token
 * 
 * @author Jun.L
 *
 */
public class AccessToken {
	private static String URL = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
	static {
		String appid = PropertiesUtil.get("appid");
		String secret = PropertiesUtil.get("secret");

		URL = URL.replace("APPID", appid).replace("APPSECRET", secret);
	}

	public static AccessTokenResult getAccessToken() {
		String json = HttpUtil.get(URL);
		AccessTokenResult result = toBean(json);
		return result;
	}

	private static AccessTokenResult toBean(String json) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		AccessTokenResult result = (AccessTokenResult) JSONObject.toBean(
				jsonObject, AccessTokenResult.class);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(getAccessToken());
	}
}
