/**
 * Created by peterg on 9/2/2014.
 */

import org.json.JSONObject;

import java.text.ParseException;
//http://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
public class JsonHandler {
    protected JSONObject jsonObject;

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

    public int GetExpiration(){
        return jsonObject.getInt("expires_in");
    }

    public String GetTokenType(){
        return jsonObject.getString("token_type");
    }
}
