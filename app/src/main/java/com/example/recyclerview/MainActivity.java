package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.Basic.BasicRecyclerView;
import com.example.recyclerview.BasicAdd.BasicRecyclerAddView;

public class MainActivity extends AppCompatActivity {

    Button mBtn_basic, mBtn_basicAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn_basic      = findViewById(R.id.btn_basic);
        mBtn_basicAdd   = findViewById(R.id.btn_basicAdd);


        mBtn_basic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicRecyclerView.class);
                startActivity(intent);
            }
        });

        mBtn_basicAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, BasicRecyclerAddView.class);
                startActivity(intent);
            }
        });

    }


}
