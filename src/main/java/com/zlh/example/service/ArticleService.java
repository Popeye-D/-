package com.zlh.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: zlh
 * @date: 2019/5/1
 */
public interface ArticleService {
	/**
	 * 新增文章
	 */
	JSONObject addArticle(JSONObject jsonObject);

	/**
	 * 文章列表
	 */
	JSONObject listArticle(JSONObject jsonObject);

	/**
	 * 更新文章
	 */
	JSONObject updateArticle(JSONObject jsonObject);
}
