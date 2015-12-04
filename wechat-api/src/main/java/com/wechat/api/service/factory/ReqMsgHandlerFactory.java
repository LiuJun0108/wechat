package com.wechat.api.service.factory;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.wechat.api.msg.MsgUtil;
import com.wechat.api.service.reqhandler.ReqMsgHandler;
import com.wechat.api.util.PropertiesUtil;

public class ReqMsgHandlerFactory {
	private static final String TEXTMSGHANDLER_NAME = "TextMsgHandlerName";

	public static ReqMsgHandler getReqMsgHandler(String xml) {
		String msgType = getMsgType(xml);
		
		// 文本消息
		if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_TEXT)) {
			return getReqMsgHandler(TEXTMSGHANDLER_NAME, xml);
		}
		// 图片消息
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			System.out.println("您发送的是图片消息！");
			System.out.println(xml);
		}
		// 地理位置消息
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			// respContent = "您发送的是地理位置消息！";
		}
		// 链接消息
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_LINK)) {
			// respContent = "您发送的是链接消息！";
		}
		// 音频消息
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_VOICE)) {
			// respContent = "您发送的是音频消息！";
		}
		// 事件推送
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// 事件类型
			// String eventType = requestMap.get("Event");
			// // 订阅
			// if (eventType.equals(MsgUtil.EVENT_TYPE_SUBSCRIBE)) {
			// respContent = "谢谢您的关注！";
			// }
			// // 取消订阅
			// else if (eventType.equals(MsgUtil.EVENT_TYPE_UNSUBSCRIBE)) {
			// // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
			// }
			// // 自定义菜单点击事件
			// else if (eventType.equals(MsgUtil.EVENT_TYPE_CLICK)) {
			// // TODO 自定义菜单权没有开放，暂不处理该类消息
			// }
		}

		throw new IllegalArgumentException("msgType = " + msgType);
	}

	private static String getMsgType(String xml) {
		try {
			Document document = DocumentHelper.parseText(xml);
			Element root = document.getRootElement();
			Element mtElement = root.element("MsgType");
			return mtElement.getText();
		} catch (DocumentException e) {
			throw new RuntimeException();
		}
	}

	/**
	 * 利用反射生成处理类
	 * 
	 * @param key
	 * @param xml
	 * @return
	 */
	private static ReqMsgHandler getReqMsgHandler(String key, String xml) {
		String className = PropertiesUtil.get(key);
		try {
			return (ReqMsgHandler) Class.forName(className)
					.getConstructor(String.class).newInstance(xml);
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}

}
