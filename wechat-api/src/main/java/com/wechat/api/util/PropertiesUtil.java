package com.wechat.api.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

public class PropertiesUtil {
	private static final String DEFAULT_PROPERTIES = "/default_config.properties";
	private static final String USER_PROPERTIES = "/config.properties";
	private static Properties default_prop;
	private static Properties prop;

	static {
		// º”‘ÿƒ¨»œ≈‰÷√
		default_prop = loadConfig(DEFAULT_PROPERTIES);
		prop = loadConfig(USER_PROPERTIES);
	}

	private static Properties loadConfig(String path) {
		URL url = PropertiesUtil.class.getResource(path);
		if (url != null) {
			try {
				InputStream is = url.openStream();
				Properties prop = new Properties();
				prop.load(is);
				is.close();

				return prop;
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	public static String get(String key) {
		if (key == null)
			throw new NullPointerException("key is null");

		String value = null;
		if (prop != null)
			value = prop.getProperty(key);

		if (value == null)
			value = default_prop.getProperty(key);

		return value;
	}

	public static void main(String[] args) {
		String s = get("secret");
		System.out.println(s);
	}
}
