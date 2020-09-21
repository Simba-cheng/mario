package org.mario.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author CYX
 * @create 2019-02-14-23:14
 */
@Controller
public class MarioHomeController {

    @RequestMapping(value = "/")
    public ModelAndView showMarioHome(ModelAndView modelAndView) {
        modelAndView.setViewName("mario");
        return modelAndView;
    }

    @GetMapping(value = "/showHome.do")
    public ModelAndView showMarioHome(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response) {
        modelAndView.setViewName("mario");
        return modelAndView;
    }

}
