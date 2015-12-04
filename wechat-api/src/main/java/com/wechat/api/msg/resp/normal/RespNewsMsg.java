package com.wechat.api.msg.resp.normal;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.wechat.api.msg.resp.RespMsg;
import com.wechat.api.msg.resp.normal.vo.Article;

public class RespNewsMsg extends RespMsg {
	private List<Article> articles;
	private int ArticleCount;

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		if (articleCount > 10) {
			throw new IllegalArgumentException("articleCount ±ØÐëÐ¡ÓÚ10");
		}
		ArticleCount = articleCount;
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	@Override
	public String toXml() {
		XStream xstream = new XStream();
		xstream.alias("xml", this.getClass());
		xstream.alias("item", Article.class);
		return xstream.toXML(this);
	}

	public static void main(String[] args) {
		Article a = new Article();
		a.setDescription("description");
		a.setPicUrl("picUrl");
		a.setTitle("title");
		a.setUrl("url");
		Article b = new Article();
		b.setDescription("description");
		b.setPicUrl("picUrl");
		b.setTitle("title");
		b.setUrl("url");

		List<Article> list = new ArrayList<Article>();
		list.add(a);
		list.add(b);

		RespNewsMsg msg = new RespNewsMsg();
		msg.setArticles(list);
		msg.setArticleCount(list.size());
		msg.setFromUserName("fromUserName");
		msg.setToUserName("toUserName");

		System.out.println(msg.toXml());
	}
}
