package com.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.recyclerview.Basic.BasicRecyclerView;
import com.example.recyclerview.BasicAdd.BasicRecyclerAddView;
import com.example.recyclerview.Retrofit.RetrofitView;
import com.example.recyclerview.Volley.VolleyRecyclerView;
import com.example.recyclerview.VolleyAdd.VolleyRecyclerAddView;

public class MainActivity extends AppCompatActivity {

    Button mBtn_basic, mBtn_basicAdd, mBtn_volley, mBtn_volleyAdd, mBtn_retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtn_basic      = findViewById(R.id.btn_basic);
        mBtn_basicAdd   = findViewById(R.id.btn_basicAdd);
        mBtn_volley     = findViewById(R.id.btn_volley);
        mBtn_volleyAdd     = findViewById(R.id.btn_volleyAdd);
        mBtn_retrofit     = findViewById(R.id.btn_retrofit);


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

        mBtn_volley.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolleyRecyclerView.class);
                startActivity(intent);
            }
        });

        mBtn_volleyAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VolleyRecyclerAddView.class);
                startActivity(intent);
            }
        });

        mBtn_retrofit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RetrofitView.class);
                startActivity(intent);
            }
        });
    }


}
