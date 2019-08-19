package utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

/**
 * Created by zzg on 2019/8/19.
 */
public class AuthUtil {

    //AppID wx3c158b6246f56fbd
    private static final String APPID = "wx3c158b6246f56fbd";

    //AppSecret  cb1f46b5c994ad17b9805b1b7b6b75ef
    private static final String APPSECRET = "cb1f46b5c994ad17b9805b1b7b6b75ef";

    public static JSONObject doGetStr(String url) throws Exception{
        JSONObject jsonObject = null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet = new HttpGet(url);
        HttpResponse httpResponse = client.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();
        if(entity != null){
            String result = EntityUtils.toString(entity,"UTF-8");
            jsonObject = JSONObject.fromObject(result);
        }
        httpGet.releaseConnection();
        return jsonObject;
    }
}
