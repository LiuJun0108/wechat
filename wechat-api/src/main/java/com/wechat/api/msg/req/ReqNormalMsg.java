package com.wechat.api.msg.req;



/**
 * ��ͨ��Ϣ:<br/>
 * <br/>
 * �������ı���Ϣ��ͼƬ��Ϣ��������Ϣ����Ƶ��Ϣ��С��Ƶ��Ϣ������λ����Ϣ��������Ϣ<br/>
 * ��MsgType����
 * 
 * @author Jun.L
 *
 */
public abstract class ReqNormalMsg extends ReqMsg {
	private long MsgId;// ��Ϣid��64λ����

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

}
