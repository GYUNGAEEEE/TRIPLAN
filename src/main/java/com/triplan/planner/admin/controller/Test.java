package com.triplan.planner.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class Test {

    @GetMapping("/index")
    public String main(){
        return "/main/index";
    }
}
