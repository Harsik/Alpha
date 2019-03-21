package com.example.Alpha.controller;

import com.example.Alpha.posts.SampleVO;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    @GetMapping
    public String Home() {
        SampleVO vo = new SampleVO();
        vo.setVal1("lombok setter");
        System.out.println(vo.getVal1());
        return "index";
    }
}