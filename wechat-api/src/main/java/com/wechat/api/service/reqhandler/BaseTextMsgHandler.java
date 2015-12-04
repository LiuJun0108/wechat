package com.wechat.api.service.reqhandler;

import com.wechat.api.msg.req.ReqMsgUtil;
import com.wechat.api.msg.req.normal.ReqTextMsg;
import com.wechat.api.msg.resp.RespMsg;

public abstract class BaseTextMsgHandler implements ReqMsgHandler {
	protected ReqTextMsg reqTextMsg;

	public BaseTextMsgHandler(String xml) {
		this.reqTextMsg = ReqMsgUtil.fromXml(xml, ReqTextMsg.class);
	}

	public RespMsg handle() {
		return getRespMsg();
	}

	public abstract RespMsg getRespMsg();
}
