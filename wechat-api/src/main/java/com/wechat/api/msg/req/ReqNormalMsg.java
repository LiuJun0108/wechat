package com.wechat.api.msg.req;



/**
 * 普通消息:<br/>
 * <br/>
 * 包含：文本消息、图片消息、主意消息、视频消息、小视频消息、地理位置消息、链接消息<br/>
 * 以MsgType区分
 * 
 * @author Jun.L
 *
 */
public abstract class ReqNormalMsg extends ReqMsg {
	private long MsgId;// 消息id，64位整型

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

}
