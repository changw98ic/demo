package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class BaseController {
    @RequestMapping("/get")
    public String GetIndex(Model model)
    {
        model.addAttribute("msg","你好");
        return "Hello";
    }
}
