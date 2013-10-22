import com.google.gson.*;
import com.google.gson.stream.JsonReader;
import com.google.*;

import java.io.*;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: peterg
 * Date: 10/10/13
 * Time: 8:35 PM
 * To change this template use File | Settings | File Templates.
 */
public class Json {


    //One of many different attempts at reading Json, not yet working.
    public void MyJson(String JsonString){



       /* Gson gson = new Gson();

        ImageDetails image = gson.fromJson(JsonString ,ImageDetails.class);  */


        //String ImageDetail = image.toString();

        //System.out.println("\nFrom MyJSON\n" + ImageDetail + "\n");

        JsonObject json = (JsonObject)new JsonParser().parse(JsonString);
        System.out.println("id=" + json.get("id"));





    }

}
