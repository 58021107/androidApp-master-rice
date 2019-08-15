package com.example.administrator.power;

import android.app.DownloadManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class rice_tableDetail extends AppCompatActivity {

    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_table_detail);

        TextView name = findViewById(R.id.name);
        TextView feature = findViewById(R.id.feature);
        TextView area = findViewById(R.id.area);
        TextView product = findViewById(R.id.product);
        TextView nature = findViewById(R.id.nature);
        TextView soil = findViewById(R.id.soil);
        TextView irrigation = findViewById(R.id.irrigation);
        TextView weather = findViewById(R.id.weather);

        mQueue = Volley.newRequestQueue(this);

        getJson(name, feature, area, product, nature, soil, irrigation, weather, savedInstanceState);
    }

    private void getJson(final TextView name,final TextView feature, final TextView area, final TextView product, final TextView nature, final TextView soil, final TextView irrigation, final TextView weather, Bundle savedInstanceState) {
        String newString;
        String url = "";
        if (savedInstanceState == null){
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                newString = null;
            }else {
                newString = extras.getString("name");
                url = "http://10.0.2.2/project/data/rice_tableDetail.php?id="+newString;
            }

        }else {
            newString = (String) savedInstanceState.getSerializable("name");
            url = "http://10.0.2.2/project/data/rice_tableDetail.php?id="+newString;
        }
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++){
                        JSONObject rice = response.getJSONObject(i);
                        String rice_name = rice.getString("rice_ta_name");
                        String rice_feature = rice.getString("feature");
                        String rice_area = rice.getString("area");
                        String rice_product = rice.getString("product");
                        String rice_nature = rice.getString("nature");
                        String rice_soil = rice.getString("soil");
                        String rice_irrigation = rice.getString("irrigation");
                        String rice_weather = rice.getString("weather");

                        name.setText(rice_name);
                        feature.setText(rice_feature);
                        area.setText(rice_area);
                        product.setText(rice_product);
                        nature.setText(rice_nature);
                        soil.setText(rice_soil);
                        irrigation.setText(rice_irrigation);
                        weather.setText(rice_weather);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            }, new Response.ErrorListener(){

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
       mQueue.add(request);
    }
}
