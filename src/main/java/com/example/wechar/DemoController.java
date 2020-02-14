package com.example.wechar;
/**
 * @Author: zhangzhiguo
 * @Date: 2019/8/20 15:00
 * @Version 1.0
 */

import common.SimpleApiResponse;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import utils.ExcelUtil;
import utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
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

    private InputStream is;

    @GetMapping("/index")
    public String index(Map<String, Object> map) {
        map.put("name", "昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒");
        return "/index";
    }

//    @GetMapping("to_basic")
//    public String jumpToBasic(Map<String, Object> map) {
//        map.put("name", "昂首千秋远,笑傲风间,堪寻敌手共论剑,高处不胜寒");
//        return "/basic";
//    }

    @ResponseBody
    @RequestMapping(value = "/inputExcel",method = RequestMethod.POST)
    public SimpleApiResponse InputExcel(@RequestParam("file") MultipartFile file) throws IOException {
        SimpleApiResponse result = new SimpleApiResponse();
        if (!file.isEmpty()) {
            try {
                //获取原始的文件名
                String originalFilename = file.getOriginalFilename();
                String fileType = originalFilename.substring(originalFilename.lastIndexOf(".") + 1, originalFilename.length());
                //默认从第一行开始读取
                Integer startRows = 1;
                //获取输入流
                InputStream is = file.getInputStream();
                List<String[]> strings = ExcelUtil.readData(fileType, startRows, true, is);//这里使用输入流把数据拿到
                //遍历Excel表每一行的数据
                for (String[] str : strings) {//这里比较特殊，肯定有更简便的办法，暂时我就只有这个水平、、、尴尬

                    System.out.println("str=" + JsonUtils.objectToJson(str));
                }
            } catch (IOException e) {
                e.printStackTrace();
                result.setData("");
                result.setCode("200");
                result.setMessage("文件上传异常 : " + e.getMessage());
                return result;
            }
        }
        result.setCode("200");
        result.setMessage("文件上传成功");
        return result;
    }

}

