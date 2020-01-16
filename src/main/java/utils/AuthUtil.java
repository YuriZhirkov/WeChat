package utils;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * Created by zzg on 2019/8/19.
 */
public class AuthUtil {

    //AppID wx3c158b6246f56fbd
    public static final String APPID = "wx3c158b6246f56fbd";

    //AppSecret    c05671fddf719606059059205ba1356d
    public static final String APPSECRET = "c05671fddf719606059059205ba1356d";

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

    public static String doPost(String url, String params) {
        DefaultHttpClient httpClient = new DefaultHttpClient();
        HttpRequest request = new HttpPost(url);

        CloseableHttpResponse response = null;

        try {
            HttpPost httpPost = (HttpPost) request;
            httpPost.setEntity(new StringEntity(params, ContentType.create("application/json", "UTF-8")));
            response = httpClient.execute(httpPost);
            if (response != null && response.getStatusLine() != null && response.getStatusLine().getStatusCode() == 200) {
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
