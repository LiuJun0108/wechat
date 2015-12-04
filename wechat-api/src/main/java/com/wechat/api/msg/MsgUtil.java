package com.wechat.api.msg;

import java.util.Date;

import com.wechat.api.msg.req.ReqMsg;
import com.wechat.api.msg.resp.RespMsg;

public class MsgUtil {
	/**
	 * ������Ϣ���ͣ��ı�
	 */
	public static final String RESP_MESSAGE_TYPE_TEXT = "text";

	/**
	 * ������Ϣ���ͣ�����
	 */
	public static final String RESP_MESSAGE_TYPE_MUSIC = "music";

	/**
	 * ������Ϣ���ͣ�ͼ��
	 */
	public static final String RESP_MESSAGE_TYPE_NEWS = "news";

	/**
	 * ������Ϣ���ͣ��ı�
	 */
	public static final String REQ_MESSAGE_TYPE_TEXT = "text";

	/**
	 * ������Ϣ���ͣ�ͼƬ
	 */
	public static final String REQ_MESSAGE_TYPE_IMAGE = "image";

	/**
	 * ������Ϣ���ͣ�����
	 */
	public static final String REQ_MESSAGE_TYPE_LINK = "link";

	/**
	 * ������Ϣ���ͣ�����λ��
	 */
	public static final String REQ_MESSAGE_TYPE_LOCATION = "location";

	/**
	 * ������Ϣ���ͣ���Ƶ
	 */
	public static final String REQ_MESSAGE_TYPE_VOICE = "voice";

	/**
	 * ������Ϣ���ͣ�����
	 */
	public static final String REQ_MESSAGE_TYPE_EVENT = "event";

	/**
	 * �¼����ͣ�subscribe(����)
	 */
	public static final String EVENT_TYPE_SUBSCRIBE = "subscribe";

	/**
	 * �¼����ͣ�unsubscribe(ȡ������)
	 */
	public static final String EVENT_TYPE_UNSUBSCRIBE = "unsubscribe";

	/**
	 * �¼����ͣ�CLICK(�Զ���˵�����¼�)
	 */
	public static final String EVENT_TYPE_CLICK = "CLICK";

	/**
	 * ȡReqMsg���UserName��������CreateTime
	 * 
	 * @param from
	 * @param to
	 */
	public static void getRespMsgFromReqMsg(ReqMsg from, RespMsg to) {
		to.setCreateTime(new Date().getTime());
		to.setFromUserName(from.getToUserName());
		to.setToUserName(from.getFromUserName());
	}
}
