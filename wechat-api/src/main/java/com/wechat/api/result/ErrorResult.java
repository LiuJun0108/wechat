package com.wechat.api.result;

/**
 * 错误时微信会返回错误码<br/>
 * <br/>
 * 
 * 参考http://mp.weixin.qq.com/wiki/0/2e2239fa5f49388d5b5136ecc8e0e440.html
 * 
 * @author Jun.L
 *
 */
public class ErrorResult {
	private int errcode; // 错误代码:0为正确
	private String errmsg;

	public int getErrcode() {
		return errcode;
	}

	public void setErrcode(int errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
	public boolean isSuccess() {
		return errcode == 0 || "ok".equals(errmsg);
	}
	@Override
	public String toString() {
		return "ErrorResult [errcode=" + errcode + ", errmsg=" + errmsg + "]";
	}

}
