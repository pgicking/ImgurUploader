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
     * Is null, boolean, or integer value.
     * If it's a post then this will contain an object with the all generated values, such as an ID.
     * I decided to return a string since that encompasses ints,nulls or bools
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
