package com.example.wechar.model;

/**
 * @program: wechar
 * @description: 获取消息模板的输入参数
 * @author: zzg
 * @create: 2020-01-16 16:01
 **/

public class GetTemplateIdInput {


    String template_id_short;

    public GetTemplateIdInput(String template_id_short) {
        this.template_id_short = template_id_short;
    }


    public GetTemplateIdInput() {
    }

    public String getTemplate_id_short() {
        return template_id_short;
    }

    public void setTemplate_id_short(String template_id_short) {
        this.template_id_short = template_id_short;
    }



}
