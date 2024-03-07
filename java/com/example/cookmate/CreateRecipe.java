package com.example.cookmate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreateRecipe extends AppCompatActivity {
    EditText name,details;
    Button btn;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_recipe);
        name = findViewById(R.id.recipename);
        details = findViewById(R.id.recipedet);
        btn = findViewById(R.id.btnsubmit);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String recname = name.getText().toString();
                String recdetails = details.getText().toString();
                Database db = new Database(getApplicationContext(), "recipe", null, 1);
                if (recname.length() == 0 || recdetails.length() == 0) {
                    Toast.makeText(CreateRecipe.this, "Please fill all details...😥", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addrecipe(recname, recdetails);
                    Toast.makeText(CreateRecipe.this, "Your Recipe Is Inserted 😁", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}