package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * ������Ϣ
 * 
 * @author Jun.L
 *
 */
public class ReqVoiceMsg extends ReqNormalMsg {
	private String Format;// ������ʽ����amr��speex��
	private String Recognition; // ��ע�⣬��ͨ����ʶ����û�ÿ�η������������ں�ʱ��΢�Ż������͵�������ϢXML���ݰ��У�����һ��Recongnition�ֶ�
	private String MediaId;// ͼƬ��Ϣý��id�����Ե��ö�ý���ļ����ؽӿ���ȡ���ݡ�

	public ReqVoiceMsg() {
		this.setMsgType("voice");
	}

	@Override
	public String toString() {
		return "VoiceMsg [Format=" + Format + ", MediaId=" + MediaId + "]";
	}

	public String getFormat() {
		return Format;
	}

	public void setFormat(String format) {
		Format = format;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public String getRecognition() {
		return Recognition;
	}

	public void setRecognition(String recognition) {
		Recognition = recognition;
	}

}
