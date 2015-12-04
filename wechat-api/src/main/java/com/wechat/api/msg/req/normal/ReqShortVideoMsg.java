package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * 小视频消息
 * 
 * @author Jun.L
 *
 */
public class ReqShortVideoMsg extends ReqNormalMsg {
	private String MediaId; // 视频消息媒体id，可以调用多媒体文件下载接口拉取数据。
	private String ThumbMediaId; // 视频消息缩略图的媒体id，可以调用多媒体文件下载接口拉取数据。

	public ReqShortVideoMsg() {
		this.setMsgType("shortvideo");
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	@Override
	public String toString() {
		return "VideoMsg [MediaId=" + MediaId + ", ThumbMediaId="
				+ ThumbMediaId + "]";
	}

}
