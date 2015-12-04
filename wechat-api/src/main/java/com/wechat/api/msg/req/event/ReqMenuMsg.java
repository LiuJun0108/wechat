package com.wechat.api.msg.req.event;

import com.wechat.api.msg.req.ReqEventMsg;


/**
 * 自定义菜单事件:<br/>
 * 1.点击菜单拉取消息时的事件推送<br/>
 * 2.点击菜单跳转链接时的事件推送
 * 
 * @author Jun.L
 */
public class ReqMenuMsg extends ReqEventMsg {
	private String EventKey; // 事件KEY值

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	@Override
	public void setEvent(String event) {
		if (!"CLICK".equals(event) && !"VIEW".equals(event)) {
			throw new IllegalArgumentException("Event must be CLICK or VIEW");
		}
		super.setEvent(event);
	}

}
