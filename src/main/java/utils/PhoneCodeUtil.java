package utils;


import com.github.qcloudsms.SmsSingleSender;
import com.github.qcloudsms.SmsSingleSenderResult;
import com.github.qcloudsms.httpclient.HTTPException;
import org.json.JSONException;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public  class PhoneCodeUtil {

    //短信应用 SDK AppID  SDK AppID 以1400开头
    private static Integer SDKAppID = 1400243586;

    // 短信应用 SDK AppKey
    private static String AppKey = "d73289cb9ab3ce72ce272af1732bce47";

    // 需要发送短信的手机号码
    private static String[] phoneNumbers = {"15818735390", "13556859895", "15971069976"};

    // 注册短信模板 ID，需要在短信应用中申请
    // NOTE: 这里的模板 ID`7839`只是示例，真实的模板 ID 需要在短信控制台中申请
    private static int registerTemplateId = 397383;

    // 注册签名
    //NOTE: 签名参数使用的是`签名内容`，而不是`签名ID`。这里的签名"腾讯云"只是示例，真实的签名需要在短信控制台申请
    private static String registerSmsSign = "语过添晴社交平台"; //


    public static String sendSms(String phone, String validateCode){
        try {
            //验证码需要生产
            String[] params = {validateCode,"60"};
            SmsSingleSender ssender = new SmsSingleSender(SDKAppID, AppKey);
            SmsSingleSenderResult result = ssender.sendWithParam("86",phone,registerTemplateId, params,registerSmsSign,"","");
            System.out.println(result);
            return result.errMsg;
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
            return "HTTP响应码错误";
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
            return "JSON解析错误";
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
            return "网络IO错误";
        }

    }


    /**
     * 这个是用户认证的短信发送
     * @param setRegisterTemplateId 短信的id
     * @param phone 手机号
     * @param msg 发送短信使用的参数
     * @return
     */
    public static String sendSmsRegisterTemplateId(Integer setRegisterTemplateId,String phone, String msg){
        try {
            List<String> paramList = new ArrayList<>();
            if (setRegisterTemplateId==556613 || setRegisterTemplateId==556610) {
                paramList.add(msg);
            }
            String[] params = null;

            if (!CollectionUtils.isEmpty(paramList)) {
                params = paramList.toArray(new String[paramList.size()]);
            } else {
                params = new String[]{};
            }
            SmsSingleSender ssender = new SmsSingleSender(SDKAppID, AppKey);
            SmsSingleSenderResult result = ssender.sendWithParam("86",phone,setRegisterTemplateId, params,registerSmsSign,"","");
            System.out.println(result);
            return result.errMsg;
        } catch (HTTPException e) {
            // HTTP 响应码错误
            e.printStackTrace();
            return "HTTP响应码错误";
        } catch (JSONException e) {
            // JSON 解析错误
            e.printStackTrace();
            return "JSON解析错误";
        } catch (IOException e) {
            // 网络 IO 错误
            e.printStackTrace();
            return "网络IO错误";
        }

    }


}
