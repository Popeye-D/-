package com.zlh.example.controller;

import com.alibaba.fastjson.JSONObject;
import com.zlh.example.service.ManagerService;
import com.zlh.example.util.CommonUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: zlh
 * @description: 宿舍管理员Controller
 * @date: 2019/5/1
 */
@RestController
@RequestMapping("/manager")
public class ManagerController {

  @Autowired
  private ManagerService managerService;

  /**
   * 新增学生
   */
  @RequiresPermissions("student:add")
  @PostMapping("/addStudent")
  public JSONObject addStudent(@RequestBody JSONObject jsonObject){
    CommonUtil.hasAllRequired(jsonObject, "dormID,dormClean");
    return managerService.addStudent(jsonObject);
  }

  /**
   * 学生列表
   */
  @RequiresPermissions("student:list")
  @GetMapping("/listStudent")
  public JSONObject listStudent(HttpServletRequest request) {
      return managerService.listStudent(CommonUtil.request2Json(request));
  }

  /**
   * 更新学生信息
   */
  @RequiresPermissions("student:update")
  @PostMapping("/updateStudent")
  public JSONObject updateStudent(@RequestBody JSONObject jsonObject){
    CommonUtil.hasAllRequired(jsonObject, "dormID,dormClean");
    return managerService.updateStudent(jsonObject);
  }

  /**
   * 删除学生信息
   */
  @RequiresPermissions("student:delete")
  @PostMapping("/deleteStudent")
  public JSONObject deleteStudent(@RequestBody JSONObject jsonObject){
    CommonUtil.hasAllRequired(jsonObject, "id");
    return managerService.deleteStudent(jsonObject);
  }
}
