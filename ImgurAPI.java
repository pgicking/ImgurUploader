import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 * Created with IntelliJ IDEA.
 * User: peterg
 * Date: 10/5/13
 * Time: 7:28 PM
 * Copyright (c) Peter Gicking 10/5/13
 * To change this template use File | Settings | File Templates.
 */
/*
TODO: Catch access and refresh token and do stuff with them
TODO: Make catching server response its own function. Taking in Httpclient response and returning a string
 */

public class ImgurAPI {

        protected String IMGUR_UPLOAD_TO = "http://api.imgur.com/3/image";
//        protected String IMGUR_API_KEY = "693b7d62220755b2ff6d0c440600fdf867a77ce0";
        protected String IMGUR_API_KEY = "f9a7c2d2d48a0fe1fae941abbe475b7367054d5c";
        protected String IMGUR_CLIENT_ID = "3b837a79bf02e18";
        protected String pin;
//        String testfile = "E:\\Users\\peterg\\Pictures\\Pictures\\test.jpg";



           public void ImgInfo()
            {
                String url = "https://api.imgur.com/3/image/pkX3Clm";

                //Fake Test string, will always return success
                //String url = "http://api.imgur.com/3/account/imgur/images.xml?_fake_status=200";


                 try
                 {
                     HttpClient client = new DefaultHttpClient();
                     HttpGet request = new HttpGet(url);

                     // add request header
                     //Note, imgur is very picky about this, a semi-colon after 'Authorization' causes a 403
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

                     //Catch server JSON response in a string
                     StringBuffer result = new StringBuffer();
                     String line;
                     while ((line = rd.readLine()) != null) {
                         result.append(line);

                     }

                     ImageData image = new ImageData();

                     String ImageDetail = image.toString();


                     //Print out server JSON response
                     System.out.println(result.toString());


                 }
                 catch(Exception e){e.printStackTrace();}
            }


            //Gives users a link to open in a browser to authorize the application.
            //Getting the code back has been an issue however
           public void Authorize(){
               Scanner scanner = new Scanner (System.in);

               try{

                   //Authorize URL
                    String url = "https://api.imgur.com/oauth2/authorize";


                    HttpClient client = new DefaultHttpClient();

                    URIBuilder builder = new URIBuilder();

                   //set the parameters on the URL
                    builder.setScheme("https").setHost("api.imgur.com").setPath("/oauth2/authorize")
                            .setParameter("response_type","pin")
                            .setParameter("client_id",IMGUR_CLIENT_ID);

                   //build the URL
                    java.net.URI uri = builder.build();
                    HttpPost post = new HttpPost(uri);

                   //Send URL to servers
                    HttpResponse response = client.execute(post);
                   System.out.println(post.getURI());

                   BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                   try {
                       //Open the authorization link in default web browser
                       java.awt.Desktop.getDesktop().browse(uri);
                   }
                   catch (java.io.IOException e) {
                       System.err.println(e.getMessage());
                   }

//                   Catch server response
//                   Returns the html for the page, keep this commented out
//                   StringBuffer result = new StringBuffer();
//                   String line;
//                   while ((line = rd.readLine()) != null) {
//                       result.append(line);
//
//                   }
//                   System.out.println(result.toString());

                   System.out.print("Enter the pin: ");
                   pin = scanner.next();

                   post.abort();
                   HttpEntity entity = response.getEntity();
                   EntityUtils.consume(entity);


               }catch(Exception e){e.printStackTrace();}
           }

            //Exchanges pin from Authorize for an account token
            public void GetToken(){
                String url = "https://api.imgur.com/oauth2/token";
                try {
                    HttpClient client = new DefaultHttpClient();

                    HttpPost post = new HttpPost(url);
//                  From https://groups.google.com/forum/?fromgroups#!topic/imgur/1WThSGbG8CM
                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();

                    nameValuePairs.add(new BasicNameValuePair("client_id", IMGUR_CLIENT_ID));
                    nameValuePairs.add(new BasicNameValuePair("client_secret", IMGUR_API_KEY));
                    nameValuePairs.add(new BasicNameValuePair("grant_type", "pin"));
                    nameValuePairs.add(new BasicNameValuePair("pin", pin));

                    post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                    HttpResponse response = client.execute(post);

                    BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));


                    //Store response code (200, 403, 404, etc)
                    int ResponseCode = response.getStatusLine().getStatusCode();
                    System.out.println("Sending 'POST' request to : " + post.getURI());


                    if(ResponseCode == (200))
                        System.out.println("Success!");
                    else {
                        System.out.print("Something went wrong.\n");
                        System.out.println("Response Code: " + ResponseCode);
                    }
                    //Catch server response
                    StringBuffer result = new StringBuffer();
                    String line;
                    while ((line = rd.readLine()) != null) {
                        result.append(line);

                    }

                    System.out.println(result.toString());


                } catch (Exception e) {e.printStackTrace();}


            }

            //Uploads the testfile anonymously only atm
           public void UploadImage(String filePath){
               //create needed strings
               String url = "https://api.imgur.com/3/upload";
//               filePath = testfile;

               //Create HTTPClient and post
               HttpClient client = new DefaultHttpClient();
               HttpPost post = new HttpPost(url);


               //create base64 image
               BufferedImage image = null;
               File pix = new File(filePath);

               try {
                   //read image
                   image = ImageIO.read(pix);
                   ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
                   ImageIO.write(image, "jpg", byteArray);
                   byte[] byteImage = byteArray.toByteArray();
                   String dataImage = new org.apache.commons.codec.binary.Base64().encodeAsString(byteImage);

                   //add image
                   List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);
                   nameValuePairs.add(new BasicNameValuePair("image", dataImage));
                   post.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                   System.out.println(post.getURI());

                   //add header
                   post.addHeader("Authorization", "Client-ID " + IMGUR_CLIENT_ID);


                   //execute
                   HttpResponse response = client.execute(post);

                   BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                   //Catch server response
                   StringBuffer result = new StringBuffer();
                   String line;
                   while ((line = rd.readLine()) != null) {
                       result.append(line);

                   }

                   System.out.print(result);


               }
               catch (Exception e){e.printStackTrace();}
               }



           }


