package com.example.wechar;

import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.AuthUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * Created by zzg on 2019/8/19.
 */
@RestController
@RequestMapping(value = "/wxAuth")
public class LoginController {

    @GetMapping(value = "/wxLogin")
    public  void wxLogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String backUrl = "http://ygtq.natapp1.cc/wxAuth/callBack";
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
        urlBuffer.append(AuthUtil.APPID).append("&");
        urlBuffer.append("redirect_uri=").append(URLEncoder.encode(backUrl)).append("&");
        urlBuffer.append("response_type=code&");
        urlBuffer.append("scope=snsapi_userinfo&");
        urlBuffer.append("state=STATE#wechat_redirect");
        String url = urlBuffer.toString();
        System.out.println("url="+url);
        resp.sendRedirect(url);
    }

    @GetMapping(value = "/callBack")
    public  void callBack(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        String code = req.getParameter("code");
        System.out.println("code="+code);
        StringBuffer urlBuffer = new StringBuffer();
        urlBuffer.append("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
        urlBuffer.append(AuthUtil.APPID).append("&");
        urlBuffer.append("secret=").append(AuthUtil.APPSECRET).append("&");
        urlBuffer.append("code=").append(code).append("&");
        urlBuffer.append("grant_type=authorization_code");
        String url = urlBuffer.toString();
        System.out.println("url="+url);
        JSONObject jsonObject = AuthUtil.doGetStr(url);
        String openId = jsonObject.getString("openid");
        String token = jsonObject.getString("token");
        System.out.println("openId="+openId);
        System.out.println("token="+token);
        StringBuffer infoBuffer = new StringBuffer();
        infoBuffer.append("https://api.weixin.qq.com/sns/userinfo?access_token=");
        infoBuffer.append(token).append("&");
        infoBuffer.append("openid=").append(openId).append("&");
        infoBuffer.append("lang=zh_CN");
        String infoUrl=infoBuffer.toString();
        JSONObject userInfo = AuthUtil.doGetStr(infoUrl);
        //获取用户信息
        System.out.println(userInfo);
    }

}
