import java.text.ParseException;

/**
 * Created by peterg on 9/4/2014.
 * Handles the "Basic" JSON response from Imgur
 * https://api.imgur.com/models/basic
 */
public class JsonBasic extends JsonHandler {
    public JsonBasic(String Json) throws ParseException {
        super(Json);
    }

    /**
     * Super generic all encompassing Json object, most json responses will be a subset of
     * the "data" class. So I just puke it out as a string
     * because im not sure what else to do with it.
     * @return
     */
    public String GetData(){
        return jsonObject.getString("data");
    }

    /**
     * Returns HTTP status code
     * @return  HTTP status code
     */
    public int GetStatus(){
        return jsonObject.getInt("status");
    }

    /**
     * returns if the request was successfull or error
     * @return boolean
     */
    public boolean GetSuccess(){
        return jsonObject.getString("success").equals("true");
    }

}
