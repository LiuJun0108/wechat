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
		
		// �ı���Ϣ
		if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_TEXT)) {
			return getReqMsgHandler(TEXTMSGHANDLER_NAME, xml);
		}
		// ͼƬ��Ϣ
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_IMAGE)) {
			System.out.println("�����͵���ͼƬ��Ϣ��");
			System.out.println(xml);
		}
		// ����λ����Ϣ
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_LOCATION)) {
			// respContent = "�����͵��ǵ���λ����Ϣ��";
		}
		// ������Ϣ
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_LINK)) {
			// respContent = "�����͵���������Ϣ��";
		}
		// ��Ƶ��Ϣ
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_VOICE)) {
			// respContent = "�����͵�����Ƶ��Ϣ��";
		}
		// �¼�����
		else if (msgType.equals(MsgUtil.REQ_MESSAGE_TYPE_EVENT)) {
			// �¼�����
			// String eventType = requestMap.get("Event");
			// // ����
			// if (eventType.equals(MsgUtil.EVENT_TYPE_SUBSCRIBE)) {
			// respContent = "лл���Ĺ�ע��";
			// }
			// // ȡ������
			// else if (eventType.equals(MsgUtil.EVENT_TYPE_UNSUBSCRIBE)) {
			// // TODO ȡ�����ĺ��û����ղ������ںŷ��͵���Ϣ����˲���Ҫ�ظ���Ϣ
			// }
			// // �Զ���˵�����¼�
			// else if (eventType.equals(MsgUtil.EVENT_TYPE_CLICK)) {
			// // TODO �Զ���˵�Ȩû�п��ţ��ݲ����������Ϣ
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
	 * ���÷������ɴ�����
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
