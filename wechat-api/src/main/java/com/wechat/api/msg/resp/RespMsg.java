package com.wechat.api.msg.resp;

import com.thoughtworks.xstream.XStream;
import com.wechat.api.msg.BaseMsg;

/**
 * ������Ϣ<br/>
 * <br/>
 * ����toXml()������bean����ת��xml���ݰ�
 * 
 * @author Jun.L
 *
 */
public abstract class RespMsg extends BaseMsg {
	public String toXml() {
		XStream xstream = new XStream();
		xstream.alias("xml", this.getClass());
		return xstream.toXML(this);
	}
}
