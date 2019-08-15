package com.example.administrator.power;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Getjson {

    public static String[] RiceNames;
    public static final String JSONArray ="result";
    public static final String rice_ta_name ="rice_ta_name";
    private String json;
    private JSONArray urls;
    public Getjson(String json){
        this.json = json;
        try {
            JSONObject jsonObject = new JSONObject(json);
            urls = jsonObject.getJSONArray(JSONArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
