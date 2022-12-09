package com.example.tinderanimal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.content.Intent;
import android.net.Uri;

public class activity_help extends AppCompatActivity {

    TextView mainPageHeader;
    ImageButton imgVk, imgTg, imgWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        mainPageHeader = findViewById(R.id.mainPageHeader);
        mainPageHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity_help.this, MainPage.class);
                startActivity(intent);
                finish();
            }
        });
        imgVk = findViewById(R.id.imgVk);
        imgVk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://vk.com/aleksynders"));
                startActivity(intent);
            }
        });
        imgTg = findViewById(R.id.imgTg);
        imgTg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/aleksynders"));
                startActivity(intent);
            }
        });
        imgWeb = findViewById(R.id.imgWeb);
        imgWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://tut_dolzen_bit_sait_no_ego_net"));
                startActivity(intent);
            }
        });
    }
}