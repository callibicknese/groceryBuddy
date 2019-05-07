package com.example.grocerybuddy;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Resources:
 * https://www.tutorialspoint.com/android/android_json_parser.htm
 * https://stackoverflow.com/questions/2591098/how-to-parse-json-in-java
 */

public class JSONParser {

    Context activity;

    // An example JSON string that needs to be parsed into a POJO
    public String testStr = "{\n" +
            "   \"pageInfo\": {\n" +
            "         \"pageName\": \"abc\",\n" +
            "         \"pagePic\": \"http://example.com/content.jpg\"\n" +
            "    },\n" +
            "    \"posts\": [\n" +
            "         {\n" +
            "              \"post_id\": \"123456789012_123456789012\",\n" +
            "              \"actor_id\": \"1234567890\",\n" +
            "              \"picOfPersonWhoPosted\": \"http://example.com/photo.jpg\",\n" +
            "              \"nameOfPersonWhoPosted\": \"Jane Doe\",\n" +
            "              \"message\": \"Sounds cool. Can't wait to see it!\",\n" +
            "              \"likesCount\": \"2\",\n" +
            "              \"comments\": [],\n" +
            "              \"timeOfPost\": \"1234567890\"\n" +
            "         }\n" +
            "    ]\n" +
            "}";

    public JSONParser(Context activity) {
        this.activity = activity;
    }

    /**
     *      This method is better to do with a try/catch block
     *      since we don't need any calling methods or classes
     *      to throw an exception to use it.
     */
    public void parse(String jsonStr) {

        try {
            // First throw the JSON string into the constructor
            AssetManager assetManager = activity.getResources().getAssets();
            InputStream fileStream = assetManager.open("json_string.txt");
            testStr = getFileContent(fileStream);
            JSONObject obj = new JSONObject(testStr);

            String pageName = obj.getJSONObject("pageInfo").getString("pageName");
            JSONArray arr = obj.getJSONArray("posts");

            for (int i = 0; i < arr.length(); i++)
            {
                JSONObject post = arr.getJSONObject(i);

                String id = post.getString("actor_id");
                String post_id = post.getString("post_id");
                String msg = post.getString("message");
                String name = post.getString("nameOfPersonWhoPosted");
                String pic = post.getString("picOfPersonWhoPosted");

                String format = String.format("%s\n%s (id = %s, pic = %s) posted (post = %s) \"%s\"",
                        pageName, name, id, pic, post_id, msg);

                Log.i("GroceryBuddy", format);
            }
        } catch (JSONException e) {
            Log.i("GroceryBuddy", "JSON error: " + e.getMessage());
        } catch (IOException e) {
            Log.i("GroceryBuddy", "File error: " + e.getMessage());
        }

    }

    private static String getFileContent(InputStream file) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(file));
        StringBuilder sb = new StringBuilder();

        String line = br.readLine();
        while (line != null) {
            sb.append(line).append("\n");
            line = br.readLine();
        }
        return sb.toString();

    }

}
