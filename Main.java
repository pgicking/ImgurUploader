

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
public class Main {


    public static void main(String[] args)
    {
        //TODO make things happen
        ImgurAPI imgur = new ImgurAPI();

        //imgur.UploadImage();
        imgur.ImgInfo();
        imgur.Authorize();
        imgur.GetToken();
    }
}
