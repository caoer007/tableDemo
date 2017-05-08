package com.cc.ccspace.controller.test;

import com.alibaba.fastjson.JSON;

import com.cc.ccspace.base.controller.BaseController;
import com.cc.ccspace.base.dao.NameSpace;
import com.cc.ccspace.common.util.FileUploadUtil;
import com.cc.ccspace.service.test.TestService;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

/**当Ajax以application/x-www-form-urlencoded格式上传即使用JSON对象，
 * 后台需要使用@RequestParam 或者Servlet获取。
 *  当Ajax以application/json格式上传即使用JSON字符串，
 *  后台需要使用@RquestBody获取。
 * @AUTHOR CF
 * @DATE Created on 2017/2/26 16:42.
 */
@Controller
@RequestMapping("/test")
public class TestController extends BaseController{
@Resource(name="testService")
TestService testService;
    /**  * describe: 根据传入表名 找到对应的实体Bean 返回JSON格式的创表语句
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
