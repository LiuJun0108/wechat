package com.wechat.api.msg.req.event;

import com.wechat.api.msg.req.ReqEventMsg;


/**
 * �ϱ�����λ���¼�
 * 
 * @author Jun.L
 *
 */
public class ReqLocationMsg extends ReqEventMsg {
	private String Latitude; // ����λ��γ��
	private String Longitude;// ����λ�þ���
	private String Precision; // ����λ�þ���

	public ReqLocationMsg() {
		this.setEvent("LOCATION");
	}

	public String getLatitude() {
		return Latitude;
	}

	public void setLatitude(String latitude) {
		Latitude = latitude;
	}

	public String getLongitude() {
		return Longitude;
	}

	public void setLongitude(String longitude) {
		Longitude = longitude;
	}

	public String getPrecision() {
		return Precision;
	}

	public void setPrecision(String precision) {
		Precision = precision;
	}

}
