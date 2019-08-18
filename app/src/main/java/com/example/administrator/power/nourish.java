package com.example.administrator.power;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class nourish extends AppCompatActivity {
//หน้าดูแลบำรุงรักษา
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nourish);
//คลิกไปดูรายชื่อโรคข้าว
        Button Disease = (Button)findViewById(R.id.buttonDisease);
        Disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this,disease.class);
                startActivity(intent);
            }
        });
//คลิกไปดูรายชื่อแมลงศัตรูพืช
        Button Inscet = (Button)findViewById(R.id.buttonInscet);
        Inscet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this, insect.class);
                startActivity(intent);
            }
        });
//คลิกไปดูรายชื่อวัชพืช
        Button Weed = (Button)findViewById(R.id.buttonWeed);
        Weed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this,weed.class);
                startActivity(intent);
            }
        });
//คลิกไปดูรายชื่อปุ๋ย
        Button Fertilizer = (Button)findViewById(R.id.buttonFertilizar);
        Fertilizer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(nourish.this,fertilizer.class);
                startActivity(intent);
            }
        });
//คลิกไปดูเว็บราคาข้าว
        Button Price = (Button)findViewById(R.id.buttonPrice);
        Price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.oae.go.th/view/1/%E0%B8%AB%E0%B8%99%E0%B9%89%E0%B8%B2%E0%B9%81%E0%B8%A3%E0%B8%81/TH-TH"));
                startActivity(browserIntent);
            }
        });

    }

}
