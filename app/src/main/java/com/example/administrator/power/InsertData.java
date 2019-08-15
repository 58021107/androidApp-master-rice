package com.example.administrator.power;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.android.volley.Request.*;


public class InsertData extends AppCompatActivity {

    EditText editName;
    EditText editDate;
    EditText editFarming;
//    private Context context;
//    private  int byGetOrPost = 0;

//    Button btn_insert, btn_sug;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_data);
        Display();
    }

    private void Display() {
        Button Display = findViewById(R.id.Display);
        final EditText[] editName = {findViewById(R.id.editName)};
        final EditText[] editDate = {findViewById(R.id.editDate)};
        final EditText[] editFarming = {findViewById(R.id.editFarming)};

//        RadioButton radioButton1 = findViewById(R.id.radioButton1);
//        RadioButton radioButton2 = findViewById(R.id.radioButton2);
//        Display.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String kindOfSoil = spinner1.getSelectedItem().toString();
//                String weathers = spinner2.getSelectedItem().toString();
//                Toast.makeText(area.this, "How to" +kindOfSoil, Toast.LENGTH_SHORT);
//                Toast.makeText(area.this,"How to" +weathers, Toast.LENGTH_SHORT);

//                editName[0] = (EditText)findViewById(R.id.editName);
//                editDate[0] = (EditText)findViewById(R.id.editDate);
//                editFarming[0] = (EditText)findViewById(R.id.editFarming);
//                String message = editName.getText().toSting();
//            }
//        });

    }

//    public InsertData(Context context, EditText editName, EditText editDate, EditText editFarming, int flag){
//        this.context = context;
//        this.editName = editName;
//        this.editDate = editDate;
//        this.editFarming = editFarming;
//        byGetOrPost = flag;
//
//
//    }



}
