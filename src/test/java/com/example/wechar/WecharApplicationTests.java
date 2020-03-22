package com.example.wechar;

import com.example.wechar.model.*;
import com.example.wechar.service.TemplateMsgService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import utils.AuthUtil;
import utils.JsonUtils;
import utils.WeixinUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WecharApplicationTests {

	@Autowired
	TemplateMsgService templateMsgService;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testWeChar(){
		try {
			//这个是用来获取token的测试代码
			AccessToken token = WeixinUtil.getAccessToken();
			if (token != null && !StringUtils.isEmpty(token.getToken())) {
				System.out.println("票据: "+token.getToken());
				System.out.println("有效时间: "+token.getExpiresIn());
				//这是用来测试上传图片的
				//String path = "C:/data/hashiqi.jpg";
				//String mediaId = WeixinUtil.upload(path, token.getToken(), "image");
				//System.out.println(mediaId);
				//这是用来测试上传音乐图片的
				//String path = "C:/data/hashiqi.jpg";
				//String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
				//System.out.println(mediaId);
				//创建菜单的测试
				String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
				int result = WeixinUtil.createMenu(token.getToken(),menu);
				//if (result == 0){
				//	System.out.println("创建菜单成功");
				//} else {
				//	System.out.println("创建菜单失败");
				//}
				//String result = WeixinUtil.translate("my name is laobi");
								//String result = WeixinUtil.translateFull("");
				//System.out.println(result);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void  getTemplateId(){
		String templateIdShort = "OPENTM413887043";
		String templateId = templateMsgService.getTemplateId(templateIdShort);
		System.out.println("templateId="+templateId);
	}

    /**
     * 给指定的用户发送模板消息
     * 0UvpP1wFp-gvLVGc8XxkxMn30TLjNueyiSlqftPiugU 	报名成功通知	OPENTM413887043
     */
	@Test
	public void messageTemplateSend(){
		MessageTemplateSendInput messageTemplateSendInput = new MessageTemplateSendInput();
		messageTemplateSendInput.setFirst("尊敬的VIP会员，您已成功报名");
		messageTemplateSendInput.setRemark("活动咨询电话：13556859895");
		messageTemplateSendInput.setColor("#173177");

		messageTemplateSendInput.setValue1("单身主题密室");
		messageTemplateSendInput.setValue2("2020年01月24日下午2点");
		messageTemplateSendInput.setValue3("深圳龙华区上塘地跌站A出口");

		messageTemplateSendInput.setValue4("哈哈哈");
		messageTemplateSendInput.setOpenId("oDZ8O1CT18NISlqmtRTwXq89aJ8M");
//		messageTemplateSendInput.setOpenId("oDZ8O1M9IRvoA4rV8gsGJvOzh1tU");
		messageTemplateSendInput.setTemplate_id("0UvpP1wFp-gvLVGc8XxkxMn30TLjNueyiSlqftPiugU");

		messageTemplateSendInput.setUrl("https://www.baidu.com");
		String  messageTemplateSend= templateMsgService.messageTemplateSend(messageTemplateSendInput);

		System.out.println("messageTemplateSend="+messageTemplateSend);

	}


    /**
     * 给指定的用户发送模板消息
     * 9iIMCN9ZgufKDdmR_FaHiva2qud2LctUpEAS5rK8QhI	 预约成功提醒	OPENTM207344049
     */
    @Test
    public void messageTemplateSendOPENTM207344049(){
        MessageTemplateSendInput messageTemplateSendInput = new MessageTemplateSendInput();
        messageTemplateSendInput.setFirst("恭喜您，你已预约成功");
        messageTemplateSendInput.setRemark("感谢您的预约");
        messageTemplateSendInput.setColor("#173177");

        messageTemplateSendInput.setValue1("路人甲");
        messageTemplateSendInput.setValue2("周年店庆狂欢");
        messageTemplateSendInput.setValue3("2015年8月18日 16:00");

        messageTemplateSendInput.setValue4("");
        messageTemplateSendInput.setOpenId("oDZ8O1NV_Z3Og2jX-5_WtHZtu5ls");
        messageTemplateSendInput.setTemplate_id("9iIMCN9ZgufKDdmR_FaHiva2qud2LctUpEAS5rK8QhI");

        messageTemplateSendInput.setUrl("https://www.baidu.com");
        String  messageTemplateSend= templateMsgService.messageTemplateSend(messageTemplateSendInput);
        System.out.println("messageTemplateSend="+messageTemplateSend);

    }


    /**
     * 给指定的用户发送模板消息
     * ThLieLG1DEYrox_fteIl0OFEKeFq9YSOPcrhxdPztvY		审核结果通知		OPENTM411367272
     */
    @Test
    public void messageTemplateSendOPENTM411367272(){
        MessageTemplateSendInput messageTemplateSendInput = new MessageTemplateSendInput();
        messageTemplateSendInput.setFirst("【哈士奇店】您反馈的3项商品配送差异审核通过！");
        messageTemplateSendInput.setRemark("感谢您的使用！");
        messageTemplateSendInput.setColor("#173177");

        messageTemplateSendInput.setValue1("配送差异审核通过");
        messageTemplateSendInput.setValue2("西瓜 12.45公斤、柳橙 11.23公斤。");
        messageTemplateSendInput.setValue3("2017年7月12日 12:08");

        messageTemplateSendInput.setValue4("");
        messageTemplateSendInput.setOpenId("oDZ8O1NV_Z3Og2jX-5_WtHZtu5ls");
        messageTemplateSendInput.setTemplate_id("9iIMCN9ZgufKDdmR_FaHiva2qud2LctUpEAS5rK8QhI");

        messageTemplateSendInput.setUrl("https://www.baidu.com");
        String  messageTemplateSend= templateMsgService.messageTemplateSend(messageTemplateSendInput);
        System.out.println("messageTemplateSend="+messageTemplateSend);

    }

	@Test
	public void testUserId() {
		String str = "A1179007829860712449";
		String zim = str.substring(0,1);
		System.out.println("zim="+zim);

		String userId = str.substring(1,str.length());
		System.out.println("userId="+userId);
	}
}
