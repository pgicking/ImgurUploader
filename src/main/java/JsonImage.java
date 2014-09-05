import java.text.ParseException;

/**
 * Functions to grab information from a Json response about an image
 * Created by peterg on 9/5/2014.
 */
public class JsonImage extends JsonHandler{
    public JsonImage(String Json) throws ParseException {
        super(Json);
    }

    /**
     * @return The ID of the image
     */
    public String GetImageID(){
        return jsonObject.getJSONObject("data").getString("id");
    }

    /**
     * @return The Title of the image
     */
    public String GetImageTitle(){
        return jsonObject.getJSONObject("data").getString("title");
    }

    /**
     * @return The Images' description
     */
    public String GetImageDescription(){
        return jsonObject.getJSONObject("data").getString("description");
    }

    /**
     * @return The submission time of the image
     */
    public int GetImageSubmitTime(){
        return jsonObject.getJSONObject("data").getInt("datetime");
    }

    /**
     * @return The Image's type (jpeg, png, etc)
     */
    public String GetImageType(){
        return jsonObject.getJSONObject("data").getString("type");
    }

    /**
     * @return Is the image animated
     */
    public boolean IsAnimated(){
        return jsonObject.getJSONObject("data").getBoolean("animated");
    }

    /**
     * @return The Width of the iamge in pixels
     */
    public int GetImageWidth(){
        return jsonObject.getJSONObject("data").getInt("width");
    }

    /**
     * @return The Height of the image in pixels
     */
    public int GetImageHeight(){
        return jsonObject.getJSONObject("data").getInt("height");
    }

    /**
     * @return The size of the image in bytes
     */
    public int GetImageSize(){
        return jsonObject.getJSONObject("data").getInt("size");
    }

    /**
     * @return The number of image views
     */
    public int GetImageViews(){
        return jsonObject.getJSONObject("data").getInt("views");
    }

    /**
     * @return Amount of bandwith image has consumed in bytes
     */
    public int GetImageBandWidth(){
        return jsonObject.getJSONObject("data").getInt("bandwidth");
    }

    /**
     * OPTIONAL (Not entirely sure what a deletehash is)
     * @return The delete hash, if user is logged in
     */
    public String GetImageDeleteHash(){
        return jsonObject.getJSONObject("data").getString("deletehash");
    }

    /**
     *If the image has been categorized by our backend then this will
     *contain the section the image belongs in. (funny, cats, adviceanimals, wtf, etc)
     * @return The images section
     */
    public String GetImageSection(){
        return jsonObject.getJSONObject("data").getString("section");
    }

    /**
     * @return The direct link to the image
     */
    public String GetImageLink(){
        return jsonObject.getJSONObject("data").getString("link");
    }

    /**
     * Indicates if the current user favorited the image.
     * Defaults to false if not signed in.
     * @return Returns true or false if the user favorited the iamge or not
     */
    public  boolean IsFavorite(){
        return jsonObject.getJSONObject("data").getBoolean("favorite");
    }

    /**
     * @return If the image is nsfw or not
     */
    public  boolean IsNsfw(){
        return jsonObject.getJSONObject("data").getBoolean("nsfw");
    }

    /**
     * The current user's vote on the album. null if not signed in,
     * if the user hasn't voted on it, or if not submitted to the gallery.
     * @return the users vote on the album, can be null
     */
    public String GetImageVote(){
        return jsonObject.getJSONObject("data").getString("vote");
    }

    /**
     * @return The usrname of the account that uploaded the image or null
     */
    public  String GetUploaderAccount(){
        return jsonObject.getJSONObject("data").getString("account_url");
    }
}
