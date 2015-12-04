package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * 图片消息
 * 
 * @author Jun.L
 *
 */
public class ReqImageMsg extends ReqNormalMsg {
	private String PicUrl;// 图片链接
	private String MediaId;// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

	public ReqImageMsg() {
		this.setMsgType("image");
	}

	@Override
	public String toString() {
		return "ImageMsg [PicUrl=" + PicUrl + ", MediaId=" + MediaId + "]";
	}

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

}
