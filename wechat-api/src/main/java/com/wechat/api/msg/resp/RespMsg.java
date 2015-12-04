package com.wechat.api.msg.resp;

import com.thoughtworks.xstream.XStream;
import com.wechat.api.msg.BaseMsg;

/**
 * 发送消息<br/>
 * <br/>
 * 调用toXml()方法将bean对象转成xml数据包
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
