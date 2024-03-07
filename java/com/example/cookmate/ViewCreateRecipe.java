package com.example.cookmate;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class ViewCreateRecipe extends AppCompatActivity {
    ListView lst = findViewById(R.id.lstview);
    private String[][] order_details = {};
    HashMap<String, String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_create_recipe);
            Database db = new Database(getApplicationContext(), "recipe", null, 1);
            ArrayList dbData = db.showrecipe();
            order_details = new String[dbData.size()][];
            for (int i = 0; i < order_details.length; i++) {
                order_details[i] = new String[2];
                String arrData = dbData.get(i).toString();
                String[] strData = arrData.split(java.util.regex.Pattern.quote("$"));
                order_details[i][0] = strData[0];
                order_details[i][1] = strData[1];
            }
            list = new ArrayList();
            for (int i = 0; i < order_details.length; i++) {
                item = new HashMap<String, String>();
                item.put("line1", order_details[i][0]);
                item.put("line2", order_details[i][1]);
                list.add(item);
            }
            sa = new SimpleAdapter(this, list,
                    R.layout.multi_lines2,
                    new String[]{"line1", "line2"},
                    new int[]{R.id.line_1a, R.id.line_1b});

            lst.setAdapter(sa);
    }
}