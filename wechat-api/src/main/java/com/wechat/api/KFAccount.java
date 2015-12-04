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
 * �ͷ��ʺŹ���
 * 
 * @author Jun.L
 *
 */
public class KFAccount {
	private static final String ADD_URL = "https://api.weixin.qq.com/customservice/kfaccount/add?access_token=ACCESS_TOKEN";
	private static final String UPDATE_URL = "https://api.weixin.qq.com/customservice/kfaccount/update?access_token=ACCESS_TOKEN";
	private static final String DEL_URL = "https://api.weixin.qq.com/customservice/kfaccount/del?access_token=ACCESS_TOKEN";
	// ���ÿͷ��ʺŵ�ͷ��URL
	private static final String UPLOAD_HEAD_IMG_URL = "http://api.weixin.qq.com/customservice/kfaccount/uploadheadimg?access_token=ACCESS_TOKEN&kf_account=KFACCOUNT";
	// ��ȡ���пͷ��˺�URL
	private static final String GET_KFLIST = "https://api.weixin.qq.com/cgi-bin/customservice/getkflist?access_token=ACCESS_TOKEN";
	// �ͷ��ӿ�-����ϢURL
	private static final String SEND_URL = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN";

	/**
	 * ��ӿͷ��ʺ�
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
			System.out.println("����ʺųɹ���kfAccount = " + kfAccount);
		}
	}

	/**
	 * �޸Ŀͷ��ʺ�
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
			System.out.println("�޸��ʺųɹ���kfAccount = " + kfAccount);
		}
	}

	/**
	 * ɾ���ͷ��ʺ�
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
			System.out.println("ɾ���ʺųɹ���kfAccount = " + kfAccount);
		}
	}

	/**
	 * ���ÿͷ��ʺŵ�ͷ��
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
			System.out.println("���ÿͷ��ʺŵ�ͷ��ɹ���kfAccount = " + kfAccount);
		}
	}

	/**
	 * ��ȡ���пͷ��˺�
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
	 * �ͷ��ӿ�-����Ϣ
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
