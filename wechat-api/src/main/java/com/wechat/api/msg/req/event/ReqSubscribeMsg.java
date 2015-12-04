package com.wechat.api.msg.req.event;

import com.wechat.api.msg.req.ReqEventMsg;

/**
 * 关注/取消关注事件
 * 
 * @author Jun.L
 *
 */
public class ReqSubscribeMsg extends ReqEventMsg {

	public void setEvent(String event) {
		if (!"subscribe".equals(event) && !"unsubscribe".equals(event)) {
			throw new IllegalArgumentException(
					"Event must be subscribe or unsubscribe");
		}
		super.setEvent(event);

	}

}
