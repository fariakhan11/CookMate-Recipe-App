package com.example.cookmate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class HomePageActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    ImageView iv,fb,fv,cr,vr,lg;
    iv = findViewById(R.id.view);
    iv.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(HomePageActivity.this,HomeActivity.class));
        }
    });
        fb = findViewById(R.id.feedback);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this,FeedBackActivity.class));
            }
        });
        fv = findViewById(R.id.favorite);
        fv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this,ViewFav2.class));
            }
        });
        cr = findViewById(R.id.create);
        cr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this,CreateRecipe.class));
            }
        });
        vr = findViewById(R.id.viewur);
        vr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this,ViewCreateRecipe2.class));
            }
        });
        lg = findViewById(R.id.logout);
        lg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomePageActivity.this,LoginActivity.class));
            }
        });
    }
}