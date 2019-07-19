package com.example.recyclerview.BasicAdd;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.recyclerview.Basic.BasicRecyclerAdapter;
import com.example.recyclerview.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BasicRecyclerAddView extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] myDataset = {"a","b","c"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basic_recycler_add_view);

        mrecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mrecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mLayoutManager);



        Log.d("jhTest","" + myDataset.length);  // 현재 myDataset 데이터는 3개임

        ArrayList<String> arrData = new ArrayList<String>();    // Array 배열로 바꾸고
        Collections.addAll(arrData, myDataset);

        arrData.add("d");           // 데이터 추가
        arrData.add("e");           // 데이터 추가

        Log.d("jhTest","" + arrData.size());        // arrData.size() 는 5개가 됨

        for(int i=0; i< arrData.size(); i++){
            Log.d("jhTest","data = " + arrData.get(i));
        }


        // ArrayList, List => String[] 로 변환
        String[] strData = arrData.toArray(new String[arrData.size()]);

        // specify an adapter (see also next example)
//        mAdapter = new BasicRecyclerAddAdapter(myDataset);
        mAdapter = new BasicRecyclerAddAdapter(strData);
        mrecyclerView.setAdapter(mAdapter);     // 5개가 출력됨






    }
}
