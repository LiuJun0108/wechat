package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * ������Ϣ
 * 
 * @author Jun.L
 *
 */
public class ReqLinkMsg extends ReqNormalMsg {
	private String Title; // ��Ϣ����
	private String Description; // ��Ϣ����
	private String Url; // ��Ϣ����

	public ReqLinkMsg() {
		this.setMsgType("link");
	}

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getUrl() {
		return Url;
	}

	public void setUrl(String url) {
		Url = url;
	}

}
