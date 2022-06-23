package com.example.jwt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class XSSTestController {

    @GetMapping("/xss")
    public String test() {
        return "test";
    }

    @PostMapping("/css")
    public String test2(@RequestParam(required = false) String test,Model model) {
        model.addAttribute("test",test);
        System.out.println(test);
        return "test3";
    }
    @GetMapping(value = "/responseXss")
    public String responseXss(Model model){
        model.addAttribute("test","<script>alert('test')</script>");

        return "test";
    }


}
