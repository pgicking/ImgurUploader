import java.text.ParseException;
import java.util.Objects;

/**
 * Created by peterg on 9/4/2014.
 * The account settings, only accessible if you're logged in as the user.
 * https://api.imgur.com/models/account_settings
 */
public class JsonAcctSettings extends JsonAccount{
    public JsonAcctSettings(String Json) throws ParseException {
        super(Json);
    }

    /**
     * @return The logged in users email address
     */
    public String GetEmail(){
        return jsonObject.getJSONObject("data").getString("email");
    }

    /**
     * @return if the user has enabled high quality submissions
     */
    public boolean HighQualityAllowed(){
        return jsonObject.getJSONObject("data").getBoolean("high_quality");
    }

    /**
     * @return If the user has images open to public by default
     */
    public boolean PublicImagesAsDefault(){
        return jsonObject.getJSONObject("data").getBoolean("public_images");
    }

    /**
     * @return What privacy setting albums have by default
     */
    public String GetAlbumPrivacy(){
        return jsonObject.getJSONObject("data").getString("album_privacy");
    }

    /**
     * @return  True if the user has accepted the terms of uploading to the Imgur gallery.
     */
    public boolean AcceptedGalleryTerms(){
        return jsonObject.getJSONObject("data").getBoolean("accepted_gallery_terms");
    }

    /**
     * @return The email addresses that have been activated to allow uploading
     */
    public String[] GetActiveEmails(){
        return (String[]) jsonObject.getJSONObject("data").get("active_emails");
    }

    /**
     * @return If the user is accepting incoming messages or not
     */
    public boolean GetMessagingEnabled(){
        return jsonObject.getJSONObject("data").getBoolean("messaging_enabled");
    }


    /**
     * An array of users that have been blocked from messaging,
     * the object is blocked_id and blocked_url.
     * Not sure how to do this yet so it just returns null for now
     * @return
     */
    public Objects[] GetBlockedUsers(){
        return null;
    }
}
