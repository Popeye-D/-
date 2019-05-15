package com.zlh.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.Set;

/**
 * @author: zlh
 * @date: 2019/5/1
 */
public interface PermissionDao {
	/**
	 * 查询用户的角色 菜单 权限
	 */
	JSONObject getUserPermission(String username);

	/**
	 * 查询所有的菜单
	 */
	Set<String> getAllMenu();

	/**
	 * 查询所有的权限
	 */
	Set<String> getAllPermission();
}
