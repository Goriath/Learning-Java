package com.kfryc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.flickr.com/services/feeds/photos_public.gne?tags=cat");
//            URLConnection urlConnection = url.openConnection();
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Chrome");
            connection.setReadTimeout(10000);

            int responseCode = connection.getResponseCode();    //performs the connection: connection.connect();
            System.out.println("Response code: " + responseCode);
            if (responseCode != 200) {
                System.out.println("error reading web page");
                System.out.println(connection.getResponseMessage());
                return;
            }

            BufferedReader inputReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String line = "";

            while ((line = inputReader.readLine()) != null){
                System.out.println(line);
            }

            inputReader.close();

//            urlConnection.setDoInput(true);
//            urlConnection.connect();
//
//
//            BufferedReader inputStream = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//
//            Map<String, List<String>> headerFields = urlConnection.getHeaderFields();
//            for(Map.Entry<String, List<String>> entry : headerFields.entrySet()){
//                String key = entry.getKey();
//                List<String> value = entry.getValue();
//                System.out.println("------ key = " + key);
//                for (String string: value){
//                    System.out.println("value = " + value);
//                }
//            }

//            String line = "";
//
//            while (line!= null){
//                line = inputStream.readLine();
//                System.out.println(line);
//            }
//
//            inputStream.close();

//            URI uri = url.toURI();

//            URI baseUri = new URI("http://username:password@mynewserver.com:5000");
//            URI uri1 = new URI("/catalogue/phones?os=android#samsung");
//            URI uri2 = new URI("/catalogue/tv?manufacturer=samsung");
//            URI uri3 = new URI("/stores/location?zip=12345");
//            URI resolvedUri1 = baseUri.resolve(uri1); //appends the base uri
//            URI resolvedUri2 = baseUri.resolve(uri2); //appends the base uri
//            URI resolvedUri3 = baseUri.resolve(uri3); //appends the base uri
//
//            //URI can be relative
//            //URL has to be absolute path!
//
//            URL url1 = resolvedUri1.toURL();
//            System.out.println("URL = " + url1);
//
//            URL url2 = resolvedUri2.toURL();
//            System.out.println("URL = " + url2);
//
//            URL url3 = resolvedUri3.toURL();
//            System.out.println("URL = " + url3);
//
//
//            URI relativizedURI = baseUri.relativize(resolvedUri2);
//            System.out.println("Relative URI = " + relativizedURI);
//
//
//            System.out.println("Scheme = " + uri.getScheme());
//            System.out.println("Scheme-specific part = " + uri.getSchemeSpecificPart());
//            System.out.println("Authority = " + uri.getAuthority());
//            System.out.println("User info = " + uri.getUserInfo());
//            System.out.println("Host = " + uri.getHost());
//            System.out.println("Port = " + uri.getPort());
//            System.out.println("Path = " + uri.getPath());
//            System.out.println("Query = " + uri.getQuery());
//            System.out.println("Fragment = " + uri.getFragment());
//
//        } catch (URISyntaxException e) {
//            System.out.println("URI Bad Syntax: " + e.getMessage());
        } catch (MalformedURLException e) {
            System.out.println("URL Malformed: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
        }

    }
}
