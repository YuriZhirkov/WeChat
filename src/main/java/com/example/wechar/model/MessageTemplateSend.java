package com.example.wechar.model;

/**
 * @program: wechar
 * @description: 发送模板消息的数据结构
 * @author: zzg
 * @create: 2020-01-16 16:54
 **/

public class MessageTemplateSend {

    private String touser;

    private String template_id;

    private String url;

    private TemplateMsgMiniprogram miniprogram;

    private TemplateMsgData data;

    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
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

    public TemplateMsgMiniprogram getMiniprogram() {
        return miniprogram;
    }

    public void setMiniprogram(TemplateMsgMiniprogram miniprogram) {
        this.miniprogram = miniprogram;
    }

    public TemplateMsgData getData() {
        return data;
    }

    public void setData(TemplateMsgData data) {
        this.data = data;
    }

    public MessageTemplateSend(String touser, String template_id, String url, TemplateMsgMiniprogram miniprogram, TemplateMsgData data) {
        this.touser = touser;
        this.template_id = template_id;
        this.url = url;
        this.miniprogram = miniprogram;
        this.data = data;
    }

    public MessageTemplateSend() {

    }
}
