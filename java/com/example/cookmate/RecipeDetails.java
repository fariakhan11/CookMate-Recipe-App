package com.example.cookmate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RecipeDetails extends AppCompatActivity {
    TextView tv1;
    EditText edDetails;
    ImageView img;
    Button fav;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);
        tv1 = findViewById(R.id.BookName);
        edDetails = findViewById(R.id.edBookDetails);
        edDetails.setKeyListener(null);
        img = findViewById(R.id.imageView);
        fav = findViewById(R.id.favorecipe);
        Bundle bundle = getIntent().getExtras();
        int resId = bundle.getInt("text4");
        img.setImageResource(resId);
//        read = findViewById(R.id.btnRead);

        Intent intent = getIntent();
        tv1.setText(intent.getStringExtra("text1"));
        edDetails.setText(intent.getStringExtra("text2"));
        String url = intent.getStringExtra("text3");

        fav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username = sharedPreferences.getString("username", "").toString();
                String recipename = tv1.getText().toString();

                Database db = new Database(getApplicationContext(), "book",null,1);
                if (db.checkFav(username,recipename) == 1){
                    Toast.makeText(RecipeDetails.this, "Recipe Already Exists...", Toast.LENGTH_SHORT).show();
                }

                else{
                    db.addFav(username,recipename);
                    Toast.makeText(RecipeDetails.this, "Recipe added to favourite ❤", Toast.LENGTH_SHORT).show();
                    //startActivity(new Intent(BookDetailsActivity.this, LabTestActivity.class));
                }
            }
        });
    }

}