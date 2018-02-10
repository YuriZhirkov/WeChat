package com.example.wechar;

import utils.CheckUtil;
import utils.MessageUtil;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by zzg on 2018/2/4.
 */
@RestController
@RequestMapping(value = "/wechar")
public class CheckOutController {

    @GetMapping(value = "/checkout")
    public String checkout(@RequestParam(value = "signature", required = false, defaultValue = "1") String signature,
                           @RequestParam(value = "timestamp", required = false, defaultValue = "1") String timestamp,
                           @RequestParam(value = "nonce", required = false, defaultValue = "1") String nonce,
                           @RequestParam(value = "echostr", required = false, defaultValue = "1") String echostr) {

        if (CheckUtil.checkSignature(signature, timestamp, nonce)) {
            System.out.println("接入成功");
            return echostr;
        } else {
            System.out.println("接入失败");
            return "fall";
        }
    }

    /**
     * 处理微信请求信息
     * @param request
     * @return
     */
    @PostMapping(value = "/checkout")
    public String handleMessage(HttpServletRequest request) {

        try {
            Map<String, String> map = MessageUtil.xmlToMap(request);
            String fromUserName = map.get("FromUserName");
            String toUserName = map.get("ToUserName");
            String msgType = map.get("MsgType");
            String content = map.get("Content");
            String s=null;
            if (MessageUtil.MESSAGE_TEXT.equals(msgType)){
                  if ("1".equals(content)) {
                      s = MessageUtil.initText(toUserName,fromUserName,MessageUtil.firstMenu());
                  } else if ("2".equals(content)) {
//                      s = MessageUtil.initText(toUserName,fromUserName,MessageUtil.secondMenu());
                      s = MessageUtil.initNewsMessage(toUserName,fromUserName);
                  } else if ("3".equals(content)) {
//                      s = MessageUtil.initText(toUserName,fromUserName,MessageUtil.secondMenu());
                      s = MessageUtil.initImageMessage(toUserName,fromUserName);
                  }else if ("4".equals(content)) {
//                      s = MessageUtil.initText(toUserName,fromUserName,MessageUtil.secondMenu());
                      s = MessageUtil.initMusicMessage(toUserName,fromUserName);
                  }else if ("?".equals(content) || "？".equals(content)) {
                      s = MessageUtil.initText(toUserName,fromUserName,MessageUtil.menuText());
                  }
//                 TextMessage textMessage = new TextMessage();
//                 textMessage.setToUserName(fromUserName);
//                 textMessage.setFromUserName(toUserName);
//                 textMessage.setMsgType("text");
//                 textMessage.setCreateTime(new Date().getTime());
//                 textMessage.setContent("您发送的消息为:"+content);
//                 s = MessageUtil.textMessageToXml(textMessage);
             } else if (MessageUtil.MESSAGE_EVENT.equals(msgType)){
                String evenType = map.get("Event");
                if (MessageUtil.MESSAGE_SUBSCRIBE.equals(evenType)){
                    s = MessageUtil.initText(toUserName,fromUserName,MessageUtil.menuText());
                }
            }
            System.out.println(s);
            return s;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


}
