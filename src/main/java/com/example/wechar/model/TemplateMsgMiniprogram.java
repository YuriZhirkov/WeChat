package com.example.wechar.model;

/**
 * @program: wechar
 * @description: 消息模板中与小程序所需数据
 * @author: zzg
 * @create: 2020-01-16 16:52
 **/

public class TemplateMsgMiniprogram {

    private  String  appid;

    private  String  pagepath;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }

    public TemplateMsgMiniprogram(String appid, String pagepath) {
        this.appid = appid;
        this.pagepath = pagepath;
    }

    public TemplateMsgMiniprogram() {

    }
}
