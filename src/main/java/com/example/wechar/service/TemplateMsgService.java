package com.example.wechar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.wechar.model.*;
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


    /**
     * 发送模板消息
     * 1. 先获取ACCESS_TOKEN
     * 2. http请求方式: POST https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
     * 3. 0UvpP1wFp-gvLVGc8XxkxMn30TLjNueyiSlqftPiugU
     */
    public String messageTemplateSend(MessageTemplateSendInput messageTemplateSendInput) {
        //0UvpP1wFp-gvLVGc8XxkxMn30TLjNueyiSlqftPiugU 	报名成功通知	OPENTM413887043
        //      活动咨询电话：15818735390
        TemplateMsgValueColor remark = new TemplateMsgValueColor(messageTemplateSendInput.getRemark(),messageTemplateSendInput.getColor());
        //      "张志国"
        TemplateMsgValueColor keyword4 = new TemplateMsgValueColor(messageTemplateSendInput.getValue4(),messageTemplateSendInput.getColor());
        //      "唐山万达三层"
        TemplateMsgValueColor keyword3 = new TemplateMsgValueColor(messageTemplateSendInput.getValue3(),messageTemplateSendInput.getColor());
        //      "2020年01月16日下午2点"
        TemplateMsgValueColor keyword2 = new TemplateMsgValueColor(messageTemplateSendInput.getValue2(),messageTemplateSendInput.getColor());
        //      "狼人杀"
        TemplateMsgValueColor keyword1 = new TemplateMsgValueColor(messageTemplateSendInput.getValue1(),messageTemplateSendInput.getColor());
        //      "尊敬的VIP会员，您已成功报名"
        TemplateMsgValueColor first = new TemplateMsgValueColor(messageTemplateSendInput.getFirst(),messageTemplateSendInput.getColor());

        TemplateMsgData templateMsgData = new TemplateMsgData();
        templateMsgData.setFirst(first);
        templateMsgData.setKeyword1(keyword1);
        templateMsgData.setKeyword2(keyword2);
        templateMsgData.setKeyword3(keyword3);
        templateMsgData.setKeyword4(keyword4);
        templateMsgData.setRemark(remark);

        MessageTemplateSend messageTemplateSend = new MessageTemplateSend();
        //      o_MNmwjUgUt-C1LOCta-Q4hrEkL0
        messageTemplateSend.setTouser(messageTemplateSendInput.getOpenId());
        //      0UvpP1wFp-gvLVGc8XxkxMn30TLjNueyiSlqftPiugU
        messageTemplateSend.setTemplate_id(messageTemplateSendInput.getTemplate_id());
        //      https://www.baidu.com
        messageTemplateSend.setUrl(messageTemplateSendInput.getUrl());
        messageTemplateSend.setMiniprogram(null);
        messageTemplateSend.setData(templateMsgData);

        try {
            AccessToken token = WeixinUtil.getAccessToken();
            System.out.println("票据: "+token.getToken());
            System.out.println("有效时间: "+token.getExpiresIn());
            String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+token.getToken();



            String s = AuthUtil.doPost(url, JsonUtils.objectToJson(messageTemplateSend));
            System.out.println("获取消息模板的返回值:"+s);
            com.alibaba.fastjson.JSONObject jsonObject = com.alibaba.fastjson.JSONObject.parseObject(s);
            return jsonObject.getString("msgid");
        } catch (Exception e) {
            e.printStackTrace();
            return "01-获取消息模板失败"+e.getMessage();
        }
    }








}
