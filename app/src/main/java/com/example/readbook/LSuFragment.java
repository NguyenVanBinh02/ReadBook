package com.example.readbook;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LSuFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsu_fragment);
        ImageView trolai = findViewById(R.id.Trolai);
        TextView title = findViewById(R.id.toolbar_title);

        trolai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LSuFragment.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setClass(LSuFragment.this,
                        MainActivity.class);
                startActivity(intent);
            }
        });
    }
}