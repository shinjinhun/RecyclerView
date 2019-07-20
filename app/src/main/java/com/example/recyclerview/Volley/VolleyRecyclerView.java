package com.example.recyclerview.Volley;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.recyclerview.BasicAdd.BasicRecyclerAddAdapter;
import com.example.recyclerview.BasicAdd.BasicRecyclerAddData;
import com.example.recyclerview.R;

import java.util.ArrayList;

public class VolleyRecyclerView extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] myDataset = {"a","b","c"};
    private ArrayList<VolleyRecyclerData> arrayList;

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

        arrayList = new ArrayList<>();

        mAdapter = new VolleyRecyclerAdapter(arrayList);
        mrecyclerView.setAdapter(mAdapter);

//        VolleyRecyclerData VolleyRecyclerData = new VolleyRecyclerData(R.mipmap.ic_launcher, "신진훈","내용");
//        arrayList.add(VolleyRecyclerData);
//
//        VolleyRecyclerData VolleyRecyclerData2 = new VolleyRecyclerData(R.mipmap.ic_launcher, "신진훈","내용");
//        arrayList.add(VolleyRecyclerData2);


        for (int i=0; i < myDataset.length; i++ ) {

            String title_nm  = "홍길동" + myDataset[i];
            String contents  = myDataset[i] + " 내용 주절주절.....";

            DataAdd(title_nm, contents);
        }

        DataAdd("신진훈", "ㅎㅎㅎㅎ");
        DataAdd("신민재", "ㅅㅅㅅㅅ");

        mAdapter.notifyDataSetChanged();    // 새로 고침

        mrecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int itemTotalCount = recyclerView.getAdapter().getItemCount() - 1;
                if (lastVisibleItemPosition == itemTotalCount) {
                    Log.d("jhTest", "last Position...");

                    DataAdd("신진훈" + itemTotalCount, "ㅎㅎㅎㅎ");
                    mAdapter.notifyDataSetChanged();    // 새로 고침
                }
            }
        });



/*

// 스트링 배열 작업..
//  private String[] myDataset = {"a","b","c"};
//  ArrayList 를 이용하여 주석처리함


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
//        mAdapter = new VolleyRecyclerAdapter(myDataset);
        mAdapter = new VolleyRecyclerAdapter(strData);
        mrecyclerView.setAdapter(mAdapter);     // 5개가 출력됨



* */



    }


    public void DataAdd(String title_nm, String contents){
        VolleyRecyclerData VolleyRecyclerData = new VolleyRecyclerData(R.mipmap.ic_launcher, title_nm, contents);
        arrayList.add(VolleyRecyclerData);
    }





}
