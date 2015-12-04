package com.wechat.api.service.reqhandler;

import com.wechat.api.msg.MsgUtil;
import com.wechat.api.msg.resp.RespMsg;
import com.wechat.api.msg.resp.normal.RespTextMsg;

public class DefaultTextMsgHandler extends BaseTextMsgHandler {

	public DefaultTextMsgHandler(String xml) {
		super(xml);
	}

	public RespMsg getRespMsg() {
		RespTextMsg result = new RespTextMsg();
		MsgUtil.getRespMsgFromReqMsg(reqTextMsg, result);
		result.setContent("测试文本消息测试文本消息测试文本消息测试文本消息测试文本消息");

		System.out.println(result.toXml());
		return result;
	}

}
