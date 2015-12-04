package com.wechat.api.msg.resp.normal.vo;

public class Voice {
	private String MediaId;// 通过素材管理接口上传多媒体文件，得到的id

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
