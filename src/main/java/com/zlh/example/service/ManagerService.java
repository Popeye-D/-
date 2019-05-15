package com.zlh.example.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @author: zlh
 * @description: 宿舍管理员Service
 * @date: 2019/5/1
 */
public interface ManagerService {

    /**
     * 新增学生
     */
    JSONObject addStudent(JSONObject jsonObject);

    /**
     * 学生列表
     */
    JSONObject listStudent(JSONObject jsonObject);

    JSONObject getStuInfo(JSONObject jsonObject);

    /**
     * 更新学生信息
     */
    JSONObject updateStudent(JSONObject jsonObject);

    /**
     * 删除学生
     */
    JSONObject deleteStudent(JSONObject jsonObject);
}
