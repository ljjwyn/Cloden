package com.example.gloden.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(value = "get", method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> helloGloden(){
        Map<String,Object> responseMap = new HashMap<>();
        responseMap.put("code",200);
        responseMap.put("message","成功");
        return responseMap;
    }

}
