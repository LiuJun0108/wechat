package com.wechat.api;

import net.sf.json.JSONObject;

import com.wechat.api.result.CallbackIpResult;
import com.wechat.api.util.HttpUtil;

/**
 * 获取微信服务器IP地址
 * 
 * @author Jun.L
 *
 */
public class CallbackIp {
	private static final String URL = "https://api.weixin.qq.com/cgi-bin/getcallbackip?access_token=ACCESS_TOKEN";

	public static CallbackIpResult getCallbackIp(String accessToken) {
		String url = URL.replace("ACCESS_TOKEN", accessToken);

		String json = HttpUtil.get(url); // "ip_list":["127.0.0.1","127.0.0.1"]
		JSONObject jsonObject = JSONObject.fromObject(json);
		CallbackIpResult result = (CallbackIpResult) JSONObject
				.toBean(jsonObject, CallbackIpResult.class);
		return result;
	}
	
	public static void main(String[] args) {
		CallbackIpResult result = getCallbackIp("lVNFaLM3omoNvuwjwTCwgdRRco_ykyOqYaESl3FfEzaqPJNOp8ziuMHvJTMk_DZP9b2XQ9kakSLxKCfulnTgX_9Q8ULLRdoVuMrF02G1GbMVGYhAGAPAS");
		for(String ip : result.getIp_list()) {
			System.out.println("ip = " + ip);
		}
	}
}
