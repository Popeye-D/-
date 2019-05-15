package com.zlh.example.dao;


import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: zlh
 * @description: 学生Dao层
 * @date: 2019/5/1
 */
public interface StudentDao {
    JSONObject getStuInfo(String username);

    /**
     * 统计学生信息总数
     */
    int countStudent(String username);

    /**
     * 学生信息列表
     */
    List<JSONObject> listStudent(String username);
}
