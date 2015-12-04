package com.wechat.api.msg.resp.normal;

import com.wechat.api.msg.resp.RespMsg;
import com.wechat.api.msg.resp.normal.vo.Voice;

/**
 * ªÿ∏¥”Ô“Ùœ˚œ¢
 * 
 * @author Jun.L
 *
 */
public class RespVoiceMsg extends RespMsg {
	private Voice voice;
	
	public Voice getVoice() {
		return voice;
	}

	public void setVoice(Voice voice) {
		this.voice = voice;
	}

	

	public RespVoiceMsg() {
		this.setMsgType("voice");
	}


	@Override
	public String toString() {
		return "VoiceMsg [voice=" + voice + "]";
	}

	public static void main(String[] args) {
		RespVoiceMsg msg = new RespVoiceMsg();
		msg.setFromUserName("fromUserName");
		Voice v = new Voice();
		v.setMediaId("mediaId");
		msg.setVoice(v);
		msg.setToUserName("toUserName");

		System.out.println(msg.toXml());
	}

}
