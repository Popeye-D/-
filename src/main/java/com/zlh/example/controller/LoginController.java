package com.zlh.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlh.example.service.LoginService;
import com.zlh.example.util.CommonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: zlh
 * @description: 登录相关Controller
 * @date: 2019/5/1
 */
@RestController
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	/**
	 * 登录
	 */
	@PostMapping("/auth")
	public JSONObject authLogin(@RequestBody JSONObject requestJson) {
		CommonUtil.hasAllRequired(requestJson, "username,password");
		return loginService.authLogin(requestJson);
	}

	/**
	 * 查询当前登录用户的信息
	 */
	@PostMapping("/getInfo")
	public JSONObject getInfo() {
		return loginService.getInfo();
	}

	/**
	 * 登出
	 */
	@PostMapping("/logout")
	public JSONObject logout() {
		return loginService.logout();
	}
}