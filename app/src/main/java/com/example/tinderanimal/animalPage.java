package com.example.tinderanimal;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class animalPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_page);

        ImageView imgA = findViewById(R.id.imgAnimal);
        TextView titleA = findViewById(R.id.nameAnimalPage);
        TextView descA = findViewById(R.id.descAnimalPage);

        TextView number = findViewById(R.id.number);
        TextView mail = findViewById(R.id.mail);

        Button butCLS = findViewById(R.id.buttonCloseAnimal);

        imgA.setImageResource(getIntent().getIntExtra("imgA", 0));
        titleA.setText(getIntent().getStringExtra("titleA"));
        descA.setText(getIntent().getStringExtra("descA"));
        number.setText(getIntent().getStringExtra("numA"));
        mail.setText(getIntent().getStringExtra("mailA"));


        butCLS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();

            }
        });
    }
}