package com.ezequiel.kafkasample.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class SwaggerController
{
    @RequestMapping("/")
    public String home()
    {
        return "redirect:swagger-ui.html";
    }
}