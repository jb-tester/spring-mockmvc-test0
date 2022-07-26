package com.mytests.spring.springmockmvctest0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(path = "/test3", method = RequestMethod.GET, produces = {"text/plain", "application/*"})
    public String test3(ModelMap model, @RequestParam(name = "param1",required = false,defaultValue = "def_p1") String p1) {
        model.addAttribute("test3_attr1", "test3");
        model.addAttribute("req_param1", p1);
        return "test3";
    }
    @GetMapping("/test4")
    public ModelAndView test4() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("test4");
        mav.addObject("attr1","attr1_value");
        return  mav;
    }
}
