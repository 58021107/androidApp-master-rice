package com.example.administrator.power;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

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

public class insect extends AppCompatActivity {

    private RequestQueue mQueue;
    List<Data> inscet_lists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscet);

        ListView listView = findViewById(R.id.inscet_list);
        mQueue = Volley.newRequestQueue(this);
//ดึงข้อมูลรายชื่อแมลงศัตรูพืชมาแสดง
        getJson(listView);
    }

    public void getJson(final ListView listView) {
//เรียกผ่าน url มาแสดงในรายการ listview
        String url = "http://10.0.2.2/project/data/inscet.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        try {
                            for (int i = 0; i < response.length(); i++) {
                                JSONObject rice = response.getJSONObject(i);
//แสดงรายชื่อแมลงศัตรูพืชและ id โดนเรียกผ่าน id โดยคลิกที่ชื่อก่อน
                                String  insect_id = rice.getString("inscet_id");
                                String insect_name = rice.getString("inscet_name");

                                inscet_lists.add(new Data(insect_id, insect_name));
                            }
//กดเข้าไปเป็นส่วนรายละเอียดของโรคแมลงศัตรูพืช
                            //ส่งค่ารายชื่อไป
                            RiceApdapter adapter = new RiceApdapter();
                            listView.setAdapter(adapter);
                            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                                @Override
                                public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
                                    Intent intent = new Intent(insect.this, InsectDetail.class);
                                    intent.putExtra("name", inscet_lists.get(position).getId());
                                    startActivity(intent);
                                }
                            });
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
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
            return inscet_lists.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @SuppressLint("ViewHolder")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = getLayoutInflater().inflate(R.layout.insect_row, null);

            TextView name_list = convertView.findViewById(R.id.insect_row);

            name_list.setText(inscet_lists.get(position).getName());
            return convertView;
        }
    }
}
