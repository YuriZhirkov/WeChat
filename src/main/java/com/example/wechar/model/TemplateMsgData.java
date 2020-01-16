package com.example.wechar.model;

/**
 * @program: wechar
 * @description: 消息模板的数据部分
 * @author: zzg
 * @create: 2020-01-16 16:48
 **/


public class TemplateMsgData {


    private TemplateMsgValueColor  first;

    private TemplateMsgValueColor  keyword1;

    private TemplateMsgValueColor  keyword2;

    private TemplateMsgValueColor  keyword3;

    private TemplateMsgValueColor  keyword4;

    private TemplateMsgValueColor  remark;

    public TemplateMsgValueColor getFirst() {
        return first;
    }

    public void setFirst(TemplateMsgValueColor first) {
        this.first = first;
    }

    public TemplateMsgValueColor getKeyword1() {
        return keyword1;
    }

    public void setKeyword1(TemplateMsgValueColor keyword1) {
        this.keyword1 = keyword1;
    }

    public TemplateMsgValueColor getKeyword2() {
        return keyword2;
    }

    public void setKeyword2(TemplateMsgValueColor keyword2) {
        this.keyword2 = keyword2;
    }

    public TemplateMsgValueColor getKeyword3() {
        return keyword3;
    }

    public void setKeyword3(TemplateMsgValueColor keyword3) {
        this.keyword3 = keyword3;
    }

    public TemplateMsgValueColor getRemark() {
        return remark;
    }

    public void setRemark(TemplateMsgValueColor remark) {
        this.remark = remark;
    }

    public TemplateMsgValueColor getKeyword4() {
        return keyword4;
    }

    public void setKeyword4(TemplateMsgValueColor keyword4) {
        this.keyword4 = keyword4;
    }

    public TemplateMsgData(TemplateMsgValueColor first, TemplateMsgValueColor keyword1, TemplateMsgValueColor keyword2,
                           TemplateMsgValueColor keyword3, TemplateMsgValueColor keyword4, TemplateMsgValueColor remark) {
        this.first = first;
        this.keyword1 = keyword1;
        this.keyword2 = keyword2;
        this.keyword3 = keyword3;
        this.keyword4 = keyword4;
        this.remark = remark;
    }

    public TemplateMsgData() {}

}
