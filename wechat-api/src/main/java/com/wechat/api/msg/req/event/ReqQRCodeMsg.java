package com.wechat.api.msg.req.event;

import com.wechat.api.msg.req.ReqEventMsg;


/**
 * 扫描带参数二维码事件:<br/>
 * 1. 用户未关注时，进行关注后的事件推送
 * 2. 用户已关注时的事件推送
 * 
 * @author Jun.L
 *
 */
public class ReqQRCodeMsg extends ReqEventMsg {
	private String EventKey;
	private String Ticket;

	@Override
	public void setEvent(String event) {
		if (!"subscribe".equals(event) && !"SCAN".equals(event)) {
			throw new IllegalArgumentException(
					"Event must be subscribe or SCAN");
		}
		super.setEvent(event);
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		if ("subscribe".equals(this.getEvent())
				&& !eventKey.startsWith("qrscene_")) {
			throw new IllegalArgumentException(
					"eventKey must startsWith qrscene_");
		}
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}

}
