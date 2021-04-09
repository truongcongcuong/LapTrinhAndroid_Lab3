package com.example.ltdd_lab2;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;


public class MainActivity_ChonMau extends AppCompatActivity {
    ImageView imageView;
    Button buttonSelect, buttonWhite,buttonBlue,buttonRed,buttonBlack;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__chon_mau);
        getSupportActionBar().hide();
        Bundle bundleGet = getIntent().getExtras();
        SmartPhone smartPhone = (SmartPhone) bundleGet.getSerializable("smart");
        imageView = findViewById(R.id.imageView2Mau);
        buttonWhite = findViewById(R.id.button3);
        buttonBlue = findViewById(R.id.button4);
        buttonRed = findViewById(R.id.button5);
        buttonBlack= findViewById(R.id.button6);
        buttonSelect = findViewById(R.id.button7);

        imageView.setImageResource(smartPhone.getImage());


        ArrayList<SmartPhone> phones = ListSmartPhone.getNewInstance().getPhones();
        position = phones.indexOf(smartPhone);
        buttonWhite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 0;
                imageView.setImageResource(phones.get(position).getImage());

            }
        });
        buttonBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 1;
                imageView.setImageResource(phones.get(position).getImage());

            }
        });
        buttonRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 2;
                imageView.setImageResource(phones.get(position).getImage());

            }
        });
        buttonBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position = 3;
                imageView.setImageResource(phones.get(position).getImage());


            }
        });
        buttonSelect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity_ChonMau.this, MainActivity.class);
                Bundle bundlePut = new Bundle();
                bundlePut.putSerializable("smartSelect",phones.get(position));
                intent1.putExtras(bundlePut);
                startActivity(intent1);
            }
        });
    }
}