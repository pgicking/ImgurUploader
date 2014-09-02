/**
 * Created by peterg on 9/2/2014.
 */

import org.json.JSONObject;

import java.text.ParseException;

public class JsonHandler {
    JSONObject jsonObject;

    public JsonHandler(String Json) throws ParseException {
        this.jsonObject = new JSONObject(Json);

    }

    public String GetAccessToken(){
        return jsonObject.getString("access_token");
    }

    public String GetRefreshToken() {
        return jsonObject.getString("refresh_token");
    }

    public String GetAccountName(){
        return jsonObject.getString("account_username");
    }
}
