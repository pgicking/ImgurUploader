import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * USed to handle all the HTTP requests (GET, POST, PUT, DELETE)
 * Created by peterg on 9/8/2014.
 */
public class HTTPHandler {

    protected String IMGUR_API_KEY = "f9a7c2d2d48a0fe1fae941abbe475b7367054d5c";
    protected String IMGUR_CLIENT_ID = "3b837a79bf02e18";

    /**
     * Uses a given URL to send a GET request to Imgurs API. It returns
     * the JSON as text because all the response models are different, I
     * figured I'd just let the caller handle it.
     * @param URL The URL to send a GET request too
     * @return  Returns the json in String form
     */
    public String doGET(String URL, String access_Token){
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(URL);

        //request header
        if(URL.contains("me")){
            //For requests about authorized account
            request.addHeader("Authorization", "Bearer " + access_Token);
        }
        else {
            //For anonymous requests
            request.addHeader("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
        }
        HttpResponse response = null;
        try {
            response = client.execute(request);
        } catch (IOException e) {
            System.err.println("Error contacting server");
            e.printStackTrace();
            return null;
        }

        //Store response code (200, 403, 404, etc)
        int ResponseCode = response.getStatusLine().getStatusCode();

        if(ResponseCode == (200))
            System.out.println("Server returned: " + ResponseCode + ", Success!\n");
        else
            System.out.println("Server returned: " + ResponseCode + ", something went wrong.\n");

        BufferedReader rd = null;
        StringBuffer result = new StringBuffer();
        try {
            rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

            //Catch server JSON response in a string
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line);

            }
        } catch (IOException e) {
            System.err.println("Error creating or reading InputStream to catch JSON response.");
            System.err.println("This means the servers JSON response was malformed (shouldn't ever happen)");
            e.printStackTrace();
            return null;
        }

        return String.valueOf(result);
    }

    public String doPOST(){
        return null;
    }
}
