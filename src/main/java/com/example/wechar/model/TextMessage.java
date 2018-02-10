package com.example.wechar.model;

/**
 * Created by zzg on 2018/2/5.
 */
public class TextMessage extends BaseMessage{
    // 文本消息内容
    private String Content;

    // 消息id，64位整型
    private long MsgId;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public long getMsgId() {
        return MsgId;
    }

    public void setMsgId(long msgId) {
        MsgId = msgId;
    }
}
