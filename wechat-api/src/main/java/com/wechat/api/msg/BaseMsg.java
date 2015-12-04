package com.wechat.api.msg;

/**
 * 消息基类<br/>
 * <br/>
 * 
 * 包括“接收消息”+“发送消息”<br/>
 * 接收消息：普通消息+事件消息
 * 
 * @author Jun.L
 *
 */
public abstract class BaseMsg {
	private String ToUserName;// 开发者微信号
	private String FromUserName;// 发送方帐号（一个OpenID）
	private long CreateTime;// 消息创建时间 （整型）
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public long getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(long createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}

}
