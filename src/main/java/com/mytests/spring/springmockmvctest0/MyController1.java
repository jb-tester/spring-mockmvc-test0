package com.mytests.spring.springmockmvctest0;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * *
 * <p>Created by irina on 05.11.2020.</p>
 * <p>Project: spring-mockmvc-test0</p>
 * *
 */

@Controller
@RequestMapping("/controller1")
public class MyController1 {

    @RequestMapping("/test1")
    public String test1(ModelMap model) {
        model.addAttribute("test1_attr1", "test1");
        return "test1";
    }

    @RequestMapping("/test2/{pv1}_{pv2}/start")
    public String test2(ModelMap model, @PathVariable String pv1, @PathVariable String pv2) {
        model.addAttribute("test2_attr1", "test2");
        model.addAttribute("pv1", pv1);
        model.addAttribute("pv2", pv2);
        return "test2";
    }

    @RequestMapping("/test3")
    public String test3(ModelMap model, @RequestParam("param1") String p1) {
        model.addAttribute("test3_attr1", "test3");
        model.addAttribute("req_param1", p1);
        return "test3";
    }
}