package com.wechat.api.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.api.msg.resp.RespMsg;
import com.wechat.api.service.factory.ReqMsgHandlerFactory;
import com.wechat.api.service.reqhandler.ReqMsgHandler;

/**
 * 默认作“消息处理”
 * 
 * @author Jun.L
 *
 */
public class PostMethodService {
	private HttpServletRequest request;
	private HttpServletResponse response;

	public PostMethodService(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;

	}

	public void service() throws IOException {
		String xml = this.parseRequest();
		ReqMsgHandler reqMsgHandler = ReqMsgHandlerFactory.getReqMsgHandler(xml);
		RespMsg respMsg = reqMsgHandler.handle();
		
		PrintWriter writer = this.response.getWriter();
		writer.print(respMsg.toXml());
		writer.close();
	}

	private String parseRequest() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					request.getInputStream()));

			StringBuffer sb = new StringBuffer();
			String temp = null;
			while ((temp = reader.readLine()) != null) {
				sb.append(temp);
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
