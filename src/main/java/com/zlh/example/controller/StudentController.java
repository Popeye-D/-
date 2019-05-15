package com.zlh.example.controller;


import com.alibaba.fastjson.JSONObject;
import com.zlh.example.service.ManagerService;
import com.zlh.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private ManagerService managerService;
    /**
     * 查询文章列表
     */
    @RequiresPermissions("student:select")
    @GetMapping("/getStuInfo")
    public JSONObject getStuInfo(HttpServletRequest request) {
        return managerService.getStuInfo(CommonUtil.request2Json(request));
    }
}
