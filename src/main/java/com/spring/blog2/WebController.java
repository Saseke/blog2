package com.spring.blog2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/demo")
    public String demo() {
        return "index";
    }
}
