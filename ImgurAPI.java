import com.sun.org.apache.xml.internal.security.utils.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.*;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;


/**
 * Created with IntelliJ IDEA.
 * User: peterg
 * Date: 10/5/13
 * Time: 7:28 PM
 * To change this template use File | Settings | File Templates.
 */

public class ImgurAPI {

        protected String IMGUR_UPLOAD_TO = "http://api.imgur.com/3/image";
        protected String IMGUR_API_KEY = "693b7d62220755b2ff6d0c440600fdf867a77ce0";
        protected String IMGUR_CLIENT_ID = "3b837a79bf02e18";
        String testfile = "C:\\Users\\peterg\\Pictures\\test.jpg";



           public void ImgInfo()
            {
                String url = "https://api.imgur.com/3/image/pkX3Clm";

                //Fake Test string
                //String url = "http://api.imgur.com/3/account/imgur/images.xml?_fake_status=200";


                 try
                 {
                     HttpClient client = new DefaultHttpClient();
                     HttpGet request = new HttpGet(url);

                     // add request header
                     //Note, imgur is very picky about this, a semi-colon after 'authorization' causes a 403
                     request.addHeader("Authorization", "Client-ID " + IMGUR_CLIENT_ID);

                     HttpResponse response = client.execute(request);

                     //Store response code (200, 403, 404, etc)
                     int ResponseCode = response.getStatusLine().getStatusCode();
                     System.out.println("\nSending 'GET' request to : " + url);
                     System.out.println("Response Code: " + ResponseCode);


                     if(ResponseCode == (200))
                          System.out.print(" Success!\n");
                     else
                          System.out.print(" Something went wrong.\n");

                     BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                     //Catch server JSON response
                     StringBuffer result = new StringBuffer();
                     String line;
                     while ((line = rd.readLine()) != null) {
                         result.append(line);

                     }


                     ImageData image = new ImageData();
                     Json json = new Json();
                     ImageDetails Imagedetails = new ImageDetails();

                     String ImageDetail = image.toString();



                     json.MyJson(result.toString());
                     Imagedetails.DisplayJSON();

                     //System.out.println("\n" + ImageDetail + "\n");

                     //Print out server JSON response
                     System.out.println(result.toString());

                     response.getEntity().consumeContent();
                     rd.close();
                     request.abort();
                     client.getConnectionManager().closeExpiredConnections();


                 }
                 catch(Exception e){e.printStackTrace();}
            }


            //Prompts the user to log into their Imgur account
           public void Authorize(){

               try{

                   //Authorize URL
                    String url = "https://api.imgur.com/oauth2/authorize";

                    HttpClient client = new DefaultHttpClient();
                    HttpPost post = new HttpPost(url);


                    //Attempt at adding parameters to a URL, not sure if code is wrong
                   // or parameter formatting is wrong. Imgur is very picky
                    List<NameValuePair> nvps = new ArrayList<NameValuePair>();
                    nvps.add(new BasicNameValuePair("response_type","code"));
                    nvps.add(new BasicNameValuePair("client-id",IMGUR_CLIENT_ID));

                    post.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
                    HttpResponse response = client.execute(post);

                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                    //Catch server JSON response
                    StringBuffer result = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                            result.append(line);

                    }

                    System.out.println(result.toString());



                   // add header
               //post.setHeader("Authorization", "Client-ID " + IMGUR_CLIENT_ID);
               }catch(Exception e){e.printStackTrace();}
           }

            //Not yet working!
           public void UploadImage(){
               try
               {

                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    String data = URLEncoder.encode("image", "UTF-8") + "=" + URLEncoder.encode(Base64.encode(baos.toByteArray()).toString(), "UTF-8");
                    data = data + "&" + URLEncoder.encode("key", "UTF-8") + "=" + URLEncoder.encode(IMGUR_API_KEY, "UTF-8");
                    System.out.println("Connecting...");

               // Send data
                    java.net.URL url = new java.net.URL("https://api.imgur.com/3/image");
                    URLConnection conn = url.openConnection();
                    conn.setDoOutput(true);
                   conn.setRequestProperty("Authorization",IMGUR_CLIENT_ID);
                    OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());

                    wr.write(data);
                    wr.flush();

               // Get the response
                    BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    String line;

                    while ((line = rd.readLine()) != null) {
                        //Logger.info(line);
                    }

                    wr.close();
                    rd.close();
               }
               catch(Exception e){e.printStackTrace();}

               }



           }


