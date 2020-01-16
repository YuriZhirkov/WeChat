package com.example.wechar.model;

/**
 * @program: wechar
 * @description: 消息模板的输入参数
 * @author: zzg
 * @create: 2020-01-16 17:25
 **/

public class MessageTemplateSendInput {

    private String value1;

    private String value2;

    private String value3;

    private String value4;

    private String color;

    private String remark;

    private String first;

    private String openId;

    private String template_id;

    private String url;

    public MessageTemplateSendInput(String value1, String value2, String value3,
                                    String value4, String color, String remark,
                                    String first, String openId, String template_id, String url) {
        this.value1 = value1;
        this.value2 = value2;
        this.value3 = value3;
        this.value4 = value4;
        this.color = color;
        this.remark = remark;
        this.first = first;
        this.openId = openId;
        this.template_id = template_id;
        this.url = url;
    }

    public String getValue1() {
        return value1;
    }

    public void setValue1(String value1) {
        this.value1 = value1;
    }

    public String getValue2() {
        return value2;
    }

    public void setValue2(String value2) {
        this.value2 = value2;
    }

    public String getValue3() {
        return value3;
    }

    public void setValue3(String value3) {
        this.value3 = value3;
    }

    public String getValue4() {
        return value4;
    }

    public void setValue4(String value4) {
        this.value4 = value4;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public MessageTemplateSendInput() {}
}
