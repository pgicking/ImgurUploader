

/*
 * Copyright (c) Peter Gicking 2013.
 */

/**
 * Created with IntelliJ IDEA.
 * User: peterg
 * Date: 10/5/13
 * Time: 7:21 PM
 * Copyright (c) Peter Gicking 10/5/13
 * To change this template use File | Settings | File Templates.
 */


/**
TODO: Structure multiple json classes in ways that make sense (child/parent)
TODO: Figure out how to get the correct refresh token on startup every time
TODO: Encode Refresh token in binary or some other non human readable format
TODO: Write tests (junit/hamcrest?)
TODO: Figure out how to make sure all Operations classes have access to new AccessToken (Super Parent Class constructor?)
 */

public class Main {


    public static void main(String[] args)
    {
        ImgurAPI imgur = new ImgurAPI();
        String testfile = "E:\\Users\\peterg\\Pictures\\Pictures\\test.jpg";

        //static file for now
        String refreshToken = imgur.GetRefreshToken("Swook.txt");
        if(refreshToken == null){
            imgur.Authorize();
            imgur.GetToken();
        }
        //imgur.UploadImage(testfile);
        //imgur.ImgInfo();
        String access_token = imgur.GetNewAccessToken("Swook.txt");
        AlbumOperations album = new AlbumOperations(access_token);
        JsonBasic jsonBasic = album.GetAccountAlbumIDs();
        System.out.println(jsonBasic.GetData());
    }
}
