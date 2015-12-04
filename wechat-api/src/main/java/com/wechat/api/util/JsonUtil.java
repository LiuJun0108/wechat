package com.wechat.api.util;

import net.sf.json.JSONObject;

public class JsonUtil {
	public static <T> T toBean(String json, Class<T> clazz) {
		JSONObject jsonObject = JSONObject.fromObject(json);
		@SuppressWarnings("unchecked")
		T result = (T) JSONObject.toBean(jsonObject, clazz);
		return result;
	}
}
