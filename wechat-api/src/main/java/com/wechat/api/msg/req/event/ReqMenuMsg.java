package com.wechat.api.msg.req.event;

import com.wechat.api.msg.req.ReqEventMsg;


/**
 * �Զ���˵��¼�:<br/>
 * 1.����˵���ȡ��Ϣʱ���¼�����<br/>
 * 2.����˵���ת����ʱ���¼�����
 * 
 * @author Jun.L
 */
public class ReqMenuMsg extends ReqEventMsg {
	private String EventKey; // �¼�KEYֵ

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
