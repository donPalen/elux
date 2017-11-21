package com.test.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by prokale on 2017-11-21.
 */
@RestController
public class HomeController {

    @RequestMapping("/")
    public String home() {
        return "welcome";
    }
}
