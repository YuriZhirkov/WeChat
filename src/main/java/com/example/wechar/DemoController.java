package com.example.wechar;
/**
 * @Author: zhangzhiguo
 * @Date: 2019/8/20 15:00
 * @Version 1.0
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

/**
 * @ClassName DemoController
 * @Desccription TODO
 * @Author ZhangZhiGuo
 * @Date 2019/8/20 15:00
 * @Version 1.0
 **/

@Controller
public class DemoController {

      @GetMapping("/index")
      public String index(Map<String,Object> map){
          map.put("name", "昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒");
          return "/index";
      }

//    @GetMapping("to_basic")
//    public String jumpToBasic(Map<String, Object> map) {
//        map.put("name", "昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒");
//        return "/basic";
//    }

}

