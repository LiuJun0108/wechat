package com.wechat.app.serlvet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wechat.api.service.GetMethodService;
import com.wechat.api.service.PostMethodService;
import com.wechat.api.util.PropertiesUtil;

@WebServlet("/wechat")
public class WeChatServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8872983939022816189L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		GetMethodService service = new GetMethodService(req, resp);
		service.service();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
//		System.out.println("WeChatServlet.doPost()");
//
//		BufferedReader reader = new BufferedReader(new InputStreamReader(
//				req.getInputStream()));
//
//		StringBuffer sb = new StringBuffer();
//		String temp = null;
//		while ((temp = reader.readLine()) != null) {
//			sb.append(temp);
//		}
//
//		System.out.println(sb.toString());
		
		new PostMethodService(req, resp).service();

	}

	public static void main(String[] args) {
		PropertiesUtil.get("token");
	}

}
