import java.text.ParseException;

/**
 * Created by peterg on 9/4/2014.
 * This model is used to represent the basic account information.
 * https://api.imgur.com/models/account
 */
public class JsonAccount extends JsonBasic {
    public JsonAccount(String Json) throws ParseException {
        super(Json);
    }

    /**
     * The account id for the username requested.
     * @return The account id for the username requested.
     */
    public int GetID(){
        return jsonObject.getJSONObject("data").getInt("id");
    }

    /**
     * @return The account username, will be the same as requested in the URL
     */
    public String GetUrl(){
        return jsonObject.getJSONObject("data").getString("url");
    }

    /**
     * @return A basic description the user has filled out
     */
    public String GetBio(){
        return jsonObject.getJSONObject("data").getString("bio");
    }

    /**
     * @return The reputation for the account, in it's numerical format.
     */
    public double GetReputation(){
        //hopfully doubles and floats are the same thing
        return jsonObject.getJSONObject("data").getDouble("reputation");
    }

    /**
     * @return The epoch time of account creation
     */
    public int GetAcctCreationTime(){
        return jsonObject.getJSONObject("data").getInt("created");
    }

    /**
     * Will return zero instead of false if not a pro user
     * @return False if not a pro user, their expiration date if they are.
     */
    public int GetProExpiration(){
        if(!jsonObject.getJSONObject("data").getString("pro_expiration").equals("false")){
            return jsonObject.getJSONObject("data").getInt("pro_expiration");
        }
        else
            return 0;
    }
}
