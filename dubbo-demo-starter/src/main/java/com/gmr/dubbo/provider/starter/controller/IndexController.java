package com.gmr.dubbo.provider.starter.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author guomeiran
 * @since 2019/4/17 17:17
 */
@RestController
public class IndexController {

    @RequestMapping(value = {"/", "/hello"})
    public String sample(){
        return "hello";
    }

}
