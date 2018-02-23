package com.example.blog.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/error_status")
public class ErrorController {
    public String error() throws Exception {
        throw new Exception("发生错误");
    }
}
