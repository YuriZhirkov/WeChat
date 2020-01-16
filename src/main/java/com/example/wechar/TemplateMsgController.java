package com.example.wechar;

import com.example.wechar.service.TemplateMsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: wechar
 * @description: 使用消息模板给指定用的用户发送信息
 * @author: zzg
 * @create: 2020-01-16 11:38
 *  0UvpP1wFp-gvLVGc8XxkxMn30TLjNueyiSlqftPiugU 	报名成功通知	OPENTM413887043
    尊敬的VIP会员，您已成功报名
    活动名称：转发有礼
    活动时间：2017年12月18日下午2点
    活动地点：唐山万达三层
    会员姓名：王雪松
    活动咨询电话：0315-8058736

    9iIMCN9ZgufKDdmR_FaHiva2qud2LctUpEAS5rK8QhI	 预约成功提醒	OPENTM207344049
    恭喜您，你已预约成功
    预约人昵称：路人甲
    预约活动：周年店庆狂欢
    预约成功时间：2015年8月18日 16:00
    感谢您的预约

    ThLieLG1DEYrox_fteIl0OFEKeFq9YSOPcrhxdPztvY		审核结果通知		OPENTM411367272

    【xxxx店】您反馈的3项商品配送差异审核通过！
    审核状态：配送差异审核通过
    审核内容：西瓜 12.45公斤、柳橙 11.23公斤。
    审核时间：2017年7月12日 12:08
    感谢您的使用！
 **/
@RestController
@RequestMapping(value = "/wechar")
public class TemplateMsgController {

    @Autowired
    private TemplateMsgService templateMsgService;


    /**
     * 获取消息模板的id
     * 1. 先获取ACCESS_TOKEN
     * 2. 调用post的接口http请求方式: POST https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN
     */
    @GetMapping(value = "/getTemplateId")
    public String   getTemplateId(@RequestParam(value = "templateIdShort") String templateIdShort){
        return templateMsgService.getTemplateId(templateIdShort);
    }


}
