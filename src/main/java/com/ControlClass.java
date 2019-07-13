package com;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControlClass {
   @GetMapping("/")
   @ResponseBody
    public String getHome()
    {
        return "hello home";
    }
}
