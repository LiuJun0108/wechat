package com.wechat.api.msg.resp.normal;

import com.wechat.api.msg.resp.RespMsg;
import com.wechat.api.msg.resp.normal.vo.Music;

/**
 * ªÿ∏¥“Ù¿÷œ˚œ¢
 * 
 * @author Jun.L
 *
 */
public class RespMusicMsg extends RespMsg {

	private Music music;

	public RespMusicMsg() {
		this.setMsgType("music");
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	@Override
	public String toString() {
		return "MusicMsg [music=" + music + "]";
	}

	public static void main(String[] args) {
		Music m = new Music();
		m.setDescription("description");
		m.setHQMusicUrl("hQMusicUrl");
		m.setMusicURL("musicURL");
		m.setThumbMediaId("thumbMediaId");
		m.setTitle("title");
		RespMusicMsg msg = new RespMusicMsg();
		msg.setMusic(m);

		System.out.println(msg.toXml());
	}
}
