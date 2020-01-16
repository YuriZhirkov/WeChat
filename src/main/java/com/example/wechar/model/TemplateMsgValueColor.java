package com.example.wechar.model;

/**
 * @program: wechar
 * @description: 发送模板消息中keyword对象
 * @author: zzg
 * @create: 2020-01-16 16:46
 **/

public class TemplateMsgValueColor {

    private  String value;

    private  String color;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public TemplateMsgValueColor(String value, String color) {
        this.value = value;
        this.color = color;
    }

    public TemplateMsgValueColor() {}
}
