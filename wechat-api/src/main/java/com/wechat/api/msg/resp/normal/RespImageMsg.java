package com.wechat.api.msg.resp.normal;

import com.wechat.api.msg.resp.RespMsg;

/**
 * �ظ�ͼƬ��Ϣ
 * 
 * @author Jun.L
 *
 */
public class RespImageMsg extends RespMsg {
	private String MediaId;// ͨ���زĹ���ӿ��ϴ���ý���ļ����õ���id��

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
