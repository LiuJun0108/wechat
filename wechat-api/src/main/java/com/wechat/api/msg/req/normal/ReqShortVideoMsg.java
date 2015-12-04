package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * С��Ƶ��Ϣ
 * 
 * @author Jun.L
 *
 */
public class ReqShortVideoMsg extends ReqNormalMsg {
	private String MediaId; // ��Ƶ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�
	private String ThumbMediaId; // ��Ƶ��Ϣ����ͼ��ý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�

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
