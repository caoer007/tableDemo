package com.cc.ccspace.base.controller;

import com.cc.ccspace.base.dao.BaseDao;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @AUTHOR CF
 * @DATE Created on 2017/4/7 12:37.
 */

public abstract class BaseController {
    @Resource(name = "baseDao")
    protected BaseDao baseDao;
    public static final String SUCCESS_CODE="0";
    public static final String FAIL_CODE="1";
    public static final String FAILED_DESC="create failed!";

}
