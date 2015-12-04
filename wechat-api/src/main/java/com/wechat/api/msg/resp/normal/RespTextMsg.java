package com.wechat.api.msg.resp.normal;

import com.wechat.api.msg.resp.RespMsg;

/**
 * �ظ��ı���Ϣ
 * 
 * @author Jun.L
 *
 */
public class RespTextMsg extends RespMsg {
	private String Content; // �ı���Ϣ����

	public RespTextMsg() {
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
	
	public static void main(String[] args) {
		RespTextMsg msg = new RespTextMsg();
		msg.setContent("content");
		msg.setFromUserName("fromUserName");
		msg.setToUserName("toUserName");
		System.out.println(msg.toXml());
	}

}
