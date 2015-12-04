package com.wechat.api.msg.req;

import com.thoughtworks.xstream.XStream;

public class ReqMsgUtil {
	private static XStream xstream = new XStream();

	public static <T> T fromXml(String xml, Class<T> clazz) {
		xstream.alias("xml", clazz);
		@SuppressWarnings("unchecked")
		T t = (T) xstream.fromXML(xml);
		return t;
	}

}
