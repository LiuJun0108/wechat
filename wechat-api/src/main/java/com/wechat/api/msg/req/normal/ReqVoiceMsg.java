package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * 语音消息
 * 
 * @author Jun.L
 *
 */
public class ReqVoiceMsg extends ReqNormalMsg {
	private String Format;// 语音格式，如amr，speex等
	private String Recognition; // 请注意，开通语音识别后，用户每次发送语音给公众号时，微信会在推送的语音消息XML数据包中，增加一个Recongnition字段
	private String MediaId;// 图片消息媒体id，可以调用多媒体文件下载接口拉取数据。

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
