package com.wechat.api.msg.req.normal;

import com.wechat.api.msg.req.ReqNormalMsg;

/**
 * ����λ����Ϣ
 * 
 * @author Jun.L
 *
 */
public class ReqLocationMsg extends ReqNormalMsg {
	private String Location_X; // ����λ��ά��
	private String Location_Y; // ����λ�þ���
	private int Scale; // ��ͼ���Ŵ�С
	private String Label; // ����λ����Ϣ

	public ReqLocationMsg() {
		this.setMsgType("location");
	}

	public String getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(String location_X) {
		Location_X = location_X;
	}

	public String getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(String location_Y) {
		Location_Y = location_Y;
	}

	public int getScale() {
		return Scale;
	}

	public void setScale(int scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

}
