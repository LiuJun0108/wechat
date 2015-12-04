package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * ͼƬ��Ϣ
 * 
 * @author Jun.L
 *
 */
public class ReqImageMsg extends ReqNormalMsg {
	private String PicUrl;// ͼƬ����
	private String MediaId;// ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�

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
