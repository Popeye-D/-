package com.zlh.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zlh.example.dao.StudentDao;
import com.zlh.example.service.StudentService;
import com.zlh.example.util.CommonUtil;
import com.zlh.example.util.constants.Constants;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;


    @Override
    public JSONObject getStuInfo(JSONObject jsonObject) {
//        CommonUtil.fillPageParam(jsonObject);
//        int count = studentDao.countStudent(jsonObject);
//        List<JSONObject> list = studentDao.listStudent(jsonObject);
//        return CommonUtil.successPage(jsonObject, list, count);
        //从session获取用户信息
        Session session = SecurityUtils.getSubject().getSession();
        JSONObject userInfo = (JSONObject) session.getAttribute(Constants.SESSION_USER_INFO);
        String username = userInfo.getString("username");
        studentDao.getStuInfo(username);
        return CommonUtil.successJson();
    }
}
