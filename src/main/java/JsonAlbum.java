import java.text.ParseException;

/**
 * Created by peterg on 9/8/2014.
 */
public class JsonAlbum extends JsonHandler{
    public JsonAlbum(String Json) throws ParseException {
        super(Json);
    }

    public String GetAlbumID(){
        return jsonObject.getJSONObject("data").getString("id");
    }

    public String GetAlbumTitle(){
        return jsonObject.getJSONObject("data").getString("title");
    }

    public String GetAlbumDescription(){
        return jsonObject.getJSONObject("data").getString("description");
    }

    public int GetAlbumCreationTime(){
        return jsonObject.getJSONObject("data").getInt("datetime");
    }

    public String GetAlbumCoverImageID(){
        return jsonObject.getJSONObject("data").getString("cover");
    }

    public int GetAlbumCoverImageWidth(){
        return jsonObject.getJSONObject("data").getInt("cover_width");
    }

    public int GetAlbumCoverImageHeight(){
        return jsonObject.getJSONObject("data").getInt("cover_height");
    }

    public String GetAlbumAuthorID(){
        return jsonObject.getJSONObject("data").getString("account_url");
    }

    public String GetAlbumPrivacy(){
        return jsonObject.getJSONObject("data").getString("privacy");
    }

    public String GetAlbumLayout(){
        return jsonObject.getJSONObject("data").getString("layout");
    }

    public int GetAlbumViews(){
        return jsonObject.getJSONObject("data").getInt("views");
    }

    public String GetAlbumURLLink(){
        return jsonObject.getJSONObject("data").getString("link");
    }

    public boolean IsAlbumFavorite(){
        return jsonObject.getJSONObject("data").getBoolean("favorite");
    }

    public boolean IsNSFW(){
        return jsonObject.getJSONObject("data").getBoolean("nsfw");
    }

    public String GetAlbumSection(){
        return jsonObject.getJSONObject("data").getString("section");
    }

    public int GetAlbumORder(){
        return jsonObject.getJSONObject("data").getInt("order");
    }

    public String GetAlbumDeleteHash(){
        return jsonObject.getJSONObject("data").getString("deletehash");
    }

    public int GetAlbumImageCount(){
        return jsonObject.getJSONObject("data").getInt("images_count");
    }

    /**
     * NYI
     * @return
     */
    public org.json.JSONArray GetAlbumImages(){
        return jsonObject.getJSONObject("data").getJSONArray("images");
    }
}
