package com.wechat.api.msg.resp.normal.vo;

public class Music {
	private String Title;// ���ֱ���
	private String Description;// ��������
	private String MusicURL;// ��������
	private String HQMusicUrl;// �������������ӣ�WIFI��������ʹ�ø����Ӳ�������
	private String ThumbMediaId;// ����ͼ��ý��id��ͨ���زĹ���ӿ��ϴ���ý���ļ����õ���id

	public String getTitle() {
		return Title;
	}

	public void setTitle(String title) {
		Title = title;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getMusicURL() {
		return MusicURL;
	}

	public void setMusicURL(String musicURL) {
		MusicURL = musicURL;
	}

	public String getHQMusicUrl() {
		return HQMusicUrl;
	}

	public void setHQMusicUrl(String hQMusicUrl) {
		HQMusicUrl = hQMusicUrl;
	}

	public String getThumbMediaId() {
		return ThumbMediaId;
	}

	public void setThumbMediaId(String thumbMediaId) {
		ThumbMediaId = thumbMediaId;
	}

	@Override
	public String toString() {
		return "Music [Title=" + Title + ", Description=" + Description
				+ ", MusicURL=" + MusicURL + ", HQMusicUrl=" + HQMusicUrl
				+ ", ThumbMediaId=" + ThumbMediaId + "]";
	}

}
