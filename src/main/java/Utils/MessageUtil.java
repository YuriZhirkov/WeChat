package Utils;

import com.example.wechar.model.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zzg on 2018/2/4.
 */
public class MessageUtil {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";


    /**
     * xml转map对象
     * @param request
     * @return
     */
    public static Map<String, String> xmlToMap(HttpServletRequest request) throws Exception{

        // 新建Map对象，用来存储信息
        Map<String, String> map = new HashMap<>();
        // 获取输入流
        InputStream inputStream = request.getInputStream();
        System.out.println(inputStream.toString());
        // 将输入流转为Dom对象
        SAXReader reader = new SAXReader();
        Document document = reader.read(inputStream);

        // 得到xml根元素
        Element root = document.getRootElement();
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();

        // 遍历所有子节点
        for (Element e : elementList)
            map.put(e.getName(), e.getText());

        // 释放资源
        inputStream.close();
        return map;
    }

    /**
     * 对象转文本xml
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream();
        xStream.alias("xml",textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    public static String initText(String toUserName,String fromUserName,String content){
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtil.MESSAGE_TEXT);
        text.setCreateTime(new Date().getTime());
        text.setContent(content);
        return textMessageToXml(text);
    }
    /**
     * 主菜单
     *
     * @return
     */
    public static String menuText() {
        StringBuffer sb = new StringBuffer();
        sb.append("欢迎你的关注，请按照菜单提示操作：\n\n");
        sb.append("1、课程介绍\n");
        sb.append("2、慕课网介绍\n");
        sb.append("回复？调出此菜单。");
        return sb.toString();
    }

    public static String firstMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("本套教程介绍微信公众号开发，主要涉及微信公众号介绍，编辑模式介绍，开发模式介绍等");
        return sb.toString();
    }

    public static String secondMenu(){
        StringBuffer sb = new StringBuffer();
        sb.append("慕课网是垂直的互联网IT技能免费学习网站。以独家视频教程、在线编程工具、学习计划、问答社区为核心特色。在这里，你可以找到最好的互联网技术牛人，" +
                "也可以通过免费的在线公开视频课程学习国内领先的互联网IT技术。");
        return sb.toString();
    }
}
