package com.example.cookmate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewFav extends AppCompatActivity {

    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btn2;
    TextView tv= findViewById(R.id.btngoBack);
    private String[][] packages = {};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_fav);
        lst = findViewById(R.id.listfav);
        SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("username", "").toString();
        Database db = new Database(getApplicationContext(), "recipe", null, 1);
        String dbData = db.getFavoriteRecipe(username);
        tv.setText(username);

        btn2=findViewById(R.id.btnBackgo);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ViewFav.this, HomePageActivity.class));

            }
        });
    }
}