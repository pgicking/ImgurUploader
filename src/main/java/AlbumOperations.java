import java.text.ParseException;

/**
 * Created by peterg on 9/8/2014.
 */
public class AlbumOperations {

    protected String ALBUM_API_URL = "https://api.imgur.com/3/account/me/album/";
    protected String MULTIPLE_ALBUMS_API_URL = "https://api.imgur.com/3/account/{username}/albums";
    protected String IMGUR_API_KEY = "f9a7c2d2d48a0fe1fae941abbe475b7367054d5c";
    protected String IMGUR_CLIENT_ID = "3b837a79bf02e18";
    protected HTTPHandler httpHandler = new HTTPHandler();


    /**
     * Return basic information about a given album
     * @param AlbumID   ID of the album
     * @return  A JsonAlbum object containing the information
     * @throws ParseException
     */
    public JsonAlbum GetAlbumInfo(String AlbumID) throws ParseException {
        JsonAlbum album = null;
        album = new JsonAlbum(httpHandler.doGET(ALBUM_API_URL + AlbumID));
        return album;

    }

    /**
     * This will return the all album IDs for the currently authenticated account
     * @return
     */
    public JsonBasic GetAccountAlbumIDs(){
        JsonBasic jsonBasic = null;
        try {
            jsonBasic = new JsonBasic(httpHandler.doGET(MULTIPLE_ALBUMS_API_URL));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return jsonBasic;
    }
}
