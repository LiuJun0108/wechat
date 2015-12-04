package com.wechat.api.util;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class HttpUtil {
	private static CloseableHttpClient defaultClient = HttpClients
			.createDefault();

	public static String get(String url) {
		if (url == null) {
			throw new NullPointerException("url is null");
		}
		return get(new HttpGet(url));
	}

	public static String get(HttpGet get) {
		return execute(get);
	}

	public static String post(HttpPost post) {
		return execute(post);
	}

	public static String post(String url, HttpEntity entity) {
		if (url == null) {
			throw new NullPointerException("url is null");
		}

		HttpPost post = new HttpPost(url);
		post.setEntity(entity);

		return execute(post);
	}

	public static String execute(HttpUriRequest request) {
		return execute(null, request);
	}

	public static String execute(CloseableHttpClient client,
			HttpUriRequest request) {
		if (client == null) {
			client = defaultClient;
		}
		if (request == null) {
			throw new NullPointerException("method is null");
		}

		try {
			CloseableHttpResponse httpResponse = client.execute(request);
			int code = httpResponse.getStatusLine().getStatusCode();
			if (code == HttpStatus.SC_OK) {
				try {
					HttpEntity entity = httpResponse.getEntity();
					String result = EntityUtils.toString(entity);
					return result;
				} finally {
					httpResponse.close();
				}
			}
			System.out.println("httpcode = " + code);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
