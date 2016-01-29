package com.zpy.yy.controller;

import com.zpy.yy.base.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
@Controller
public class IndexController extends BaseController {

    @RequestMapping("/")
    public String index() {
        return "login";
    }
}
