package com.wechat.api.msg.req.event;

import com.wechat.api.msg.req.ReqEventMsg;


/**
 * ɨ���������ά���¼�:<br/>
 * 1. �û�δ��עʱ�����й�ע����¼�����
 * 2. �û��ѹ�עʱ���¼�����
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
