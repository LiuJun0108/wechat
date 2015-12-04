package com.wechat.api.msg.resp.normal;

import com.wechat.api.msg.resp.RespMsg;
import com.wechat.api.msg.resp.normal.vo.Video;

/**
 * 回复视频消息
 * 
 * @author Jun.L
 *
 */
public class RespVideoMsg extends RespMsg {
	private Video video;

	public RespVideoMsg() {
		this.setMsgType("video");
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	@Override
	public String toString() {
		return "VideoMsg [video=" + video + "]";
	}

	public static void main(String[] args) {
		Video video = new Video();
		video.setDescription("description");
		video.setMediaId("mediaId");
		video.setTitle("title");
		
		RespVideoMsg msg = new RespVideoMsg();
		msg.setFromUserName("fromUserName");
		msg.setToUserName("toUserName");
		msg.setVideo(video);
		
		System.out.println(msg.toXml());
	}
}
