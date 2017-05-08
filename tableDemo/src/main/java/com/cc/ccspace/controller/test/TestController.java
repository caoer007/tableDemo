package com.cc.ccspace.controller.test;
import com.alibaba.fastjson.JSON;
import com.cc.ccspace.base.controller.BaseController;
import com.cc.ccspace.service.test.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/2/26 16:42.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
@Resource(name="testService")
TestService testService;
    /**  * describe: 根据传入表名 找到具有对应注解的实体Bean 返回JSON格式的创表语句
    	 * @author CAI.F
    	 * @date:  日期:2017/5/7 时间:11:57
    	 * @param
    	 */
    @ResponseBody
    @RequestMapping(value = "/bnnDemo",produces="application/json;charset=utf-8")
     public   String  bnnDemo(HttpServletRequest req) {
        String beanName=req.getParameter("tableName");
        String tableSql = testService.createTableSql(beanName);
        String result=StringUtils.isEmpty(tableSql)?FAILED_DESC:tableSql;
        Map<String,Object> res=new HashMap();
        res.put("result",result);
        return JSON.toJSONString(res);
    }


}
