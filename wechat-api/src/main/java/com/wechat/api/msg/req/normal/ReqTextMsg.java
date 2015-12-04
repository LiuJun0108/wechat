package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * 文本消息
 * 
 * @author Jun.L
 *
 */
public class ReqTextMsg extends ReqNormalMsg {
	private String Content; // 文本消息内容

	public ReqTextMsg() {
		this.setMsgType("text");
	}

	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}

	@Override
	public String toString() {
		return "TextMsg [Content=" + Content + "]";
	}

}
