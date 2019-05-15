package com.zlh.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zlh.example.dao.ManagerDao;
import com.zlh.example.dao.UserDao;
import com.zlh.example.service.ManagerService;
import com.zlh.example.util.CommonUtil;
import com.zlh.example.util.constants.Constants;
import com.zlh.example.util.constants.ErrorEnum;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: zlh
 * @description: 管理员ServiceImpl
 * @date: 2019/5/1
 */
@Service
public class ManagerServiceImpl implements ManagerService {

    @Autowired
    private ManagerDao managerDao;
    @Autowired
    private UserDao userDao;
    /**
     * 新增学生
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject addStudent(JSONObject jsonObject) {
        int exist = userDao.queryExistUserID(jsonObject);
        System.out.println(exist);
        if (exist == 0) {
            return CommonUtil.errorJson(ErrorEnum.E_90002);
        }
        managerDao.addStudent(jsonObject);
        return CommonUtil.successJson();
    }
    /**
     * 学生列表
     */
    @Override
    public JSONObject listStudent(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        int count = managerDao.countStudent(jsonObject);
        List<JSONObject> list = managerDao.listStudent(jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }

    @Override
    public JSONObject getStuInfo(JSONObject jsonObject) {
        CommonUtil.fillPageParam(jsonObject);
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        int count = managerDao.countStudentInfo(username);
        System.out.println(count);
        System.out.println(username);
        List<JSONObject> list = managerDao.getStuInfo(username,jsonObject);
        return CommonUtil.successPage(jsonObject, list, count);
    }
    /**
     * 更新学生信息
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject updateStudent(JSONObject jsonObject) {
        managerDao.updateStudent(jsonObject);
        return CommonUtil.successJson();
    }
    /**
     * 删除学生
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public JSONObject deleteStudent(JSONObject jsonObject){
        managerDao.deleteStudent(jsonObject);
        return CommonUtil.successJson();
    }
}
