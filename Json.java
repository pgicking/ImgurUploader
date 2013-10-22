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

    public static void ReadJson() {
        try{



        JsonReader jsonReader;

        jsonReader = new JsonReader(new FileReader("derp.txt"));


        while (jsonReader.hasNext()) {
            String text = jsonReader.nextName();
            if (text.equals("data")) {
                //functioncall
            }
        }

        jsonReader.endObject();
        jsonReader.close();

        }catch(Exception e){e.printStackTrace();}
    }

    public static void ReadJSON(JsonReader jsonReader){
        try{
            jsonReader.beginObject();
            while(jsonReader.hasNext()){
                String text = jsonReader.nextName();
                System.out.println(text);
                while(jsonReader.hasNext()){
                    String t = jsonReader.nextName();
                    if(t.equals("id")){
                        //blaaaah
                    }
                }
            }


        }catch(Exception e){e.printStackTrace();}
    }


    public void MyJson(String JsonString){



       /* Gson gson = new Gson();

        ImageDetails image = gson.fromJson(JsonString ,ImageDetails.class);  */


        //String ImageDetail = image.toString();

        //System.out.println("\nFrom MyJSON\n" + ImageDetail + "\n");

        JsonObject json = (JsonObject)new JsonParser().parse(JsonString);
        System.out.println("id=" + json.get("id"));





    }

}
