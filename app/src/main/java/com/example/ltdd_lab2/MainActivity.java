package com.example.ltdd_lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    Button buttonChonMau;
    ImageView imageView;
    TextView tvPhoneName,tvReview,tvPrice, tvDiscoutPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        buttonChonMau = findViewById(R.id.buttonChonMau);
        imageView = findViewById(R.id.imageView);
        tvPhoneName = findViewById(R.id.tvPhoneName);
        tvDiscoutPrice = findViewById(R.id.tvDiscoutPrice);
        tvPrice = findViewById(R.id.tvPrice);
        tvReview = findViewById(R.id.tvDanhGia);
        SmartPhone vsBac = new SmartPhone("Điện Thoại Vsmart Joy 3 Trắng - Hàng chính hãng",632,1890000,1590000,R.drawable.vs_bac);
        Bundle bundle = getIntent().getExtras();
        if(bundle!=null){

           SmartPhone smartPhoneGet = (SmartPhone) bundle.getSerializable("smartSelect");
           setContent(smartPhoneGet);
        }else {
            setContent(vsBac);
        }
        buttonChonMau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity_ChonMau.class);
                Bundle bundlePut = new Bundle();
                bundlePut.putSerializable("smart",(Serializable)vsBac);
                intent.putExtras(bundlePut);
                startActivity(intent);

            }
        });


    }

    public void setContent(SmartPhone smartPhone){
        DecimalFormat decimalFormat = new DecimalFormat("#,### đ");
        tvPhoneName.setText(smartPhone.getPhoneName());
        tvReview.setText("(Xem "+smartPhone.getReview() +" đánh giá)");
        tvPrice.setText(decimalFormat.format(smartPhone.getPrice()));
        tvPrice.setPaintFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tvDiscoutPrice.setText(decimalFormat.format(smartPhone.getDiscountPrice()));
        imageView.setImageResource(smartPhone.getImage());
    }
}