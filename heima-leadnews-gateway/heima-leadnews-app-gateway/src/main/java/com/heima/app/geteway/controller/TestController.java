package com.heima.app.geteway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author FF
 * @date 2022/1/31
 * @TIME:21:32
 */
@RestController
@RequestMapping
public class TestController {

    @GetMapping("/test")
    public void  test(){
        System.out.println("true = " + "xxxxxx");
    }
}
