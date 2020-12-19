package com.dany.blog.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("index")
public class LoginController {
    @GetMapping("blog")
    public String login()
    {
        return "blogs";
    }
}
