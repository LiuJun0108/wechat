package com.wechat.api.msg.resp.normal.vo;

public class Voice {
	private String MediaId;// ͨ���زĹ���ӿ��ϴ���ý���ļ����õ���id

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	@Override
	public String toString() {
		return "Voice [MediaId=" + MediaId + "]";
	}
}
