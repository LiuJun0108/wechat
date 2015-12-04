package com.wechat.api.msg.req;

public abstract class ReqEventMsg extends ReqMsg {
	private String Event;// 事件类型

	public String getEvent() {
		return Event;
	}

	/**
	 * 子类可重写setEvent(String event)方法添加对Event的限制
	 * 
	 * @param event
	 */
	public void setEvent(String event) {
		Event = event;
	}

}
