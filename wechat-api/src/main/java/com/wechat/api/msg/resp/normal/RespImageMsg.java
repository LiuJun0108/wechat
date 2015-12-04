package com.wechat.api.msg.resp.normal;

import com.wechat.api.msg.resp.RespMsg;

/**
 * 回复图片消息
 * 
 * @author Jun.L
 *
 */
public class RespImageMsg extends RespMsg {
	private String MediaId;// 通过素材管理接口上传多媒体文件，得到的id。

	public RespImageMsg() {
		this.setMsgType("image");
	}

	@Override
	public String toString() {
		return "ImageMsg [MediaId=" + MediaId + "]";
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
