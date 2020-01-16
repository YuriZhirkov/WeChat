package com.example.wechar;

import com.example.wechar.model.AccessToken;
import com.example.wechar.service.TemplateMsgService;
import net.sf.json.JSON;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
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
			System.out.println("票据: "+token.getToken());
			System.out.println("有效时间: "+token.getExpiresIn());


			//这是用来测试上传图片的
//			String path = "C:/data/hashiqi.jpg";
//			String mediaId = WeixinUtil.upload(path, token.getToken(), "image");
//			System.out.println(mediaId);
			//这是用来测试上传音乐图片的
//			String path = "C:/data/hashiqi.jpg";
//			String mediaId = WeixinUtil.upload(path, token.getToken(), "thumb");
//			System.out.println(mediaId);

			//创建菜单的测试
//			String menu = JSONObject.fromObject(WeixinUtil.initMenu()).toString();
//			int result = WeixinUtil.createMenu(token.getToken(),menu);
//			if (result == 0){
//				System.out.println("创建菜单成功");
//			} else {
//				System.out.println("创建菜单失败");
//			}
//			String result = WeixinUtil.translate("my name is laobi");
			//String result = WeixinUtil.translateFull("");
//			System.out.println(result);
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
}
