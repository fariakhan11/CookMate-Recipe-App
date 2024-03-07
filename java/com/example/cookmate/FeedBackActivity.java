package com.example.cookmate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FeedBackActivity extends AppCompatActivity {
    Button btn1,btn2;
    EditText edt;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed_back);
        btn1=findViewById(R.id.btnsubmit);
        edt=findViewById(R.id.addRev);
        btn2=findViewById(R.id.logOut);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String var = edt.getText().toString();
                if(var.length() == 0){
                    Toast.makeText(FeedBackActivity.this, "Please Add Your Feedback!!!😥", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(FeedBackActivity.this, "Thank You For Adding Your Feedback!!!🥳", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FeedBackActivity.this, LoginActivity.class));

            }
        });

    }
}