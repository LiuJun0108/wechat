package com.wechat.api.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.api.SignatureCheck;
import com.wechat.api.util.PropertiesUtil;

/**
 * 
 * “服务器地址的有效性验证”处理
 * 
 * @author Jun.L
 *
 */
public class GetMethodService {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public GetMethodService(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	/**
	 * 验证服务器地址的有效性
	 * 
	 * @throws IOException
	 * 
	 */
	public void service() throws IOException {
		String token = PropertiesUtil.get("token");

		String signature = request.getParameter("signature");
		String timestamp = request.getParameter("timestamp");
		String nonce = request.getParameter("nonce");
		String echostr = request.getParameter("echostr");

		SignatureCheck check = new SignatureCheck(signature);
		if (check.verify(token, timestamp, nonce)) {
			response.getWriter().write(echostr);
		}
	}

}
