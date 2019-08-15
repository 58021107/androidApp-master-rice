package com.example.administrator.power;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.administrator.power.data.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class rice_table extends AppCompatActivity {

    private RequestQueue mQueue;
    private List<Data> rice_lists = new ArrayList<>();
    private RiceApdapter adapter = new RiceApdapter();
    private ResourceBundle extras;
    private Object savedInstanceState;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rice_table);

        ListView listView = findViewById(R.id.rice_lists);
        mQueue = Volley.newRequestQueue(this);


        getJson(listView);
    }


    private void getJson(final ListView listView) {
        String soil;
        String irrigation;
        String weather;
        String url = "";

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null){
                soil= null;
                irrigation = null;
                weather = null;
            }else {
                soil = extras.getString("s1");
                irrigation = extras.getString("s2");
                weather = extras.getString("s3");
                url = "http://10.0.2.2/Project/data/rice_table.php?soil="+soil+"&irrigation="+irrigation+"&weather="+weather;
            }
        }

//        String soil= extras.getString("s1");
//        String irrigation= extras.getString("s2");
//        String weather= extras.getString("s3");

//        String url = "http://10.0.2.2/Project/data/rice_table.php?soil="+soil+"&irrigation="+irrigation+"&weather="+weather;
//        Toast.makeText(rice_table.this,url, Toast.LENGTH_SHORT).show();
        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++){
                        JSONObject rice = response.getJSONObject(i);

                        String  rice_id = rice.getString("rice_ta_id");
                        String rice_name = rice.getString("rice_ta_name");

                        rice_lists.add(new Data(rice_id, rice_name));
                    }


                    listView.setAdapter(adapter);

                    listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(rice_table.this, RiceDetail.class);
                            intent.putExtra("name", rice_lists.get(position).getId());
                            startActivity(intent);
                        }
                    });
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

    class RiceApdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return rice_lists.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.rice_table_list, null);

            TextView name_list = convertView.findViewById(R.id.rice_table_row);

            name_list.setText(rice_lists.get(position).getName());
            return convertView;
        }
    }
}
