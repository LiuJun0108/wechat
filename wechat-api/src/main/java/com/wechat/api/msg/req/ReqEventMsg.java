package com.wechat.api.msg.req;

public abstract class ReqEventMsg extends ReqMsg {
	private String Event;// �¼�����

	public String getEvent() {
		return Event;
	}

	/**
	 * �������дsetEvent(String event)������Ӷ�Event������
	 * 
	 * @param event
	 */
	public void setEvent(String event) {
		Event = event;
	}

}
