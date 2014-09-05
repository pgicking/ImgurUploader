import java.text.ParseException;

/**
 * Exactly the same as JsonImage but with a
 * couple added functions.
 * Created by peterg on 9/5/2014.
 */
public class JsonGalleryImage extends JsonImage {
    public JsonGalleryImage(String Json) throws ParseException {
        super(Json);
    }

    /**
     * @return The account ID of the image uploader, or null
     */
    public int GetUploaderID(){
        return jsonObject.getJSONObject("data").getInt("account_id");
    }

    /**
     * @return The number of upvotes the image has
     */
    public int GetImageUpVotes(){
        return jsonObject.getJSONObject("data").getInt("ups");
    }

    /**
     * @return The number of image downvotes
     */
    public int GetImageDownVotes(){
        return jsonObject.getJSONObject("data").getInt("downs");
    }

    /**
     * @return The score of the image (Upvotes - downvotes)
     */
    public int GetImageScore(){
        return jsonObject.getJSONObject("data").getInt("score");
    }

    /**
     * @return If its an album or not
     */
    public boolean IsAlbum(){
        return jsonObject.getJSONObject("data").getBoolean("is_album");
    }
}
