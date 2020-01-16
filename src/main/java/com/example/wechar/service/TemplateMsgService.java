package com.example.wechar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.wechar.model.AccessToken;
import com.example.wechar.model.GetTemplateIdInput;
import org.springframework.stereotype.Service;
import utils.AuthUtil;
import utils.JsonUtils;
import utils.WeixinUtil;

/**
 * @program: wechar
 * @description: 消息模板的服务
 * @author: zzg
 * @create: 2020-01-16 15:46
 **/

@Service
public class TemplateMsgService {

    /**
     * 获取消息模板的id
     * 1. 先获取ACCESS_TOKEN
     * 2. 调用post的接口http请求方式: POST https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN
     */
    public String getTemplateId(String templateIdShort){
        //先获取ACCESS_TOKEN
        try {
            AccessToken token = WeixinUtil.getAccessToken();
            System.out.println("票据: "+token.getToken());
            System.out.println("有效时间: "+token.getExpiresIn());
            String url = "https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token="+token.getToken();

            //GetTemplateIdInput getTemplateIdInput = new GetTemplateIdInput("OPENTM413887043");
            GetTemplateIdInput getTemplateIdInput = new GetTemplateIdInput(templateIdShort);

            String s = AuthUtil.doPost(url, JsonUtils.objectToJson(getTemplateIdInput));
            System.out.println("获取消息模板的返回值:"+s);
            JSONObject jsonObject = JSONObject.parseObject(s);
            return jsonObject.getString("template_id");
        } catch (Exception e) {
            e.printStackTrace();
            return "01-获取消息模板失败"+e.getMessage();
        }
    }
}
