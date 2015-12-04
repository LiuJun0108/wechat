package com.wechat.api;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONObject;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicNameValuePair;

import com.wechat.api.result.ErrorResult;
import com.wechat.api.util.HttpUtil;
import com.wechat.api.util.JsonUtil;

/**
 * 客服帐号管理
 * 
 * @author Jun.L
 *
 */
public class KFAccount {
	private static final String ADD_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	private static final String UPDATE_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
	private static final String DEL_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
	// 设置客服帐号的头像URL
	private static final String UPLOAD_HEAD_IMG_URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
	// 获取所有客服账号URL
	private static final String GET_KFLIST = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	// 客服接口-发消息URL
	private static final String SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	/**
	 * 添加客服帐号
	 * 
	 * @param accessToken
	 * @param kfAccount
	 * @param nickname
	 * @param password
	 */
	public static void add(String accessToken, String kfAccount,
			String nickname, String password) {
		String url = ADD_URL.replace("ACCESS_TOKEN", accessToken);
		HttpPost post = new HttpPost(url);
		List<NameValuePair> pairs = getPairs(kfAccount, nickname, password);
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String json = HttpUtil.post(post);

		ErrorResult result = JsonUtil.toBean(json, ErrorResult.class);
		if (result.isSuccess()) {
			System.out.println("添加帐号成功。kfAccount = " + kfAccount);
		}
	}

	/**
	 * 修改客服帐号
	 * 
	 * @param accessToken
	 * @param kfAccount
	 * @param nickname
	 * @param password
	 */
	public static void update(String accessToken, String kfAccount,
			String nickname, String password) {
		String url = UPDATE_URL.replace("ACCESS_TOKEN", accessToken);
		HttpPost post = new HttpPost(url);
		List<NameValuePair> pairs = getPairs(kfAccount, nickname, password);
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String json = HttpUtil.post(post);

		ErrorResult result = JsonUtil.toBean(json, ErrorResult.class);
		if (result.isSuccess()) {
			System.out.println("修改帐号成功。kfAccount = " + kfAccount);
		}
	}

	/**
	 * 删除客服帐号
	 * 
	 * @param accessToken
	 * @param kfAccount
	 * @param nickname
	 * @param password
	 */
	public static void del(String accessToken, String kfAccount,
			String nickname, String password) {
		String url = DEL_URL.replace("ACCESS_TOKEN", accessToken);

		HttpPost post = new HttpPost(url);
		List<NameValuePair> pairs = getPairs(kfAccount, nickname, password);
		try {
			post.setEntity(new UrlEncodedFormEntity(pairs));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		String json = HttpUtil.post(post);

		ErrorResult result = JsonUtil.toBean(json, ErrorResult.class);
		if (result.isSuccess()) {
			System.out.println("删除帐号成功。kfAccount = " + kfAccount);
		}
	}

	/**
	 * 设置客服帐号的头像
	 * 
	 * @param accessToken
	 * @param kfAccount
	 * @param imgFile
	 */
	public static void uploadheadimg(String accessToken, String kfAccount,
			File imgFile) {
		String url = UPLOAD_HEAD_IMG_URL.replace("ACCESS_TOKEN", accessToken)
				.replace("KFACCOUNT", kfAccount);
		FileEntity entity = new FileEntity(imgFile);
		String json = HttpUtil.post(url, entity);

		ErrorResult result = JsonUtil.toBean(json, ErrorResult.class);
		if (result.isSuccess()) {
			System.out.println("设置客服帐号的头像成功。kfAccount = " + kfAccount);
		}
	}

	/**
	 * 获取所有客服账号
	 * 
	 * @param kfAccount
	 * @param nickname
	 * @param password
	 * @return
	 */
	public static JSONObject getKFList(String accessToken) {
		String url = GET_KFLIST.replace("ACCESS_TOKEN", accessToken);
		String json = HttpUtil.get(url);

		JSONObject jsonObject = JSONObject.fromObject(json);

		return jsonObject;
	}

	/**
	 * 客服接口-发消息
	 */
	public static void send(String accessToken, String jsonMsg) {
		String url = SEND_URL.replace("ACCESS_TOKEN", accessToken);
		try {
			StringEntity entity = new StringEntity(jsonMsg);
			HttpPost post = new HttpPost(url);
			post.setEntity(entity);

			HttpUtil.post(post);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	}

	private static List<NameValuePair> getPairs(String kfAccount,
			String nickname, String password) {
		List<NameValuePair> pairs = new ArrayList<NameValuePair>(3);
		pairs.add(new BasicNameValuePair("kf_account", kfAccount));
		pairs.add(new BasicNameValuePair("nickname", nickname));
		pairs.add(new BasicNameValuePair("password", password));

		return pairs;
	}

}
