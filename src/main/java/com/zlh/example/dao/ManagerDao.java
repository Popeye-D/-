package com.zlh.example.dao;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

/**
 * @author: zlh
 * @description: 文章Dao层
 * @date: 2019/5/1
 */
public interface ManagerDao {

    /**
     * 新增学生
     */
    int addStudent(JSONObject jsonObject);

    /**
     * 统计学生总数
     */
    int countStudent(JSONObject jsonObject);
    int countStudentInfo(String username);
    /**
     * 学生列表
     */
    List<JSONObject> listStudent(JSONObject jsonObject);
    List<JSONObject> getStuInfo(String username,JSONObject jsonObject);
    /**
     * 更新学生信息
     */
    int updateStudent(JSONObject jsonObject);

    /**
     * 删除学生信息
     */
    int deleteStudent(JSONObject jsonObject);

    /**
     * 查询某角色的全部数据
     * 在删除和修改角色时调用
     */
    JSONObject getStudentAllInfo(JSONObject jsonObject);
}
