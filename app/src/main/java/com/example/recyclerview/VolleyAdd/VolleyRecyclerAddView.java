package com.example.recyclerview.VolleyAdd;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ProgressBar;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.recyclerview.R;
import com.example.recyclerview.VolleyAdd.VolleyRecyclerAddAdapter;
import com.example.recyclerview.VolleyAdd.VolleyRecyclerAddData;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class VolleyRecyclerAddView extends AppCompatActivity {

    private RecyclerView mrecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    private String[] myDataset = {"a","b","c"};
    private ArrayList<VolleyRecyclerAddData> arrayList;

    //private String URL  = "https://newsapi.org/v2/top-headlines?country=kr&apiKey=09b06228654e4e9e94bf43b2712b92b4";
    private String URL  = "http://mdoli.dothome.co.kr/goodword/goodlist_json_data.php";

    private RequestQueue queue;

    private int pageNum = 1;
    private int pageRowCount = 10;

    ProgressBar progressBar;



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

        mAdapter = new VolleyRecyclerAddAdapter(arrayList);
        mrecyclerView.setAdapter(mAdapter);

//        for (int i=0; i < myDataset.length; i++ ) {
//
//            String title_nm  = "슈퍼맨" + myDataset[i];
//            String contents  = myDataset[i] + " 내용 주절주절.....";
//
//            DataAdd(title_nm, contents);
//        }
//
//        mAdapter.notifyDataSetChanged();    // 새로 고침

        queue = Volley.newRequestQueue(this);

        getNews();


        mrecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastVisibleItemPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int itemTotalCount = recyclerView.getAdapter().getItemCount() - 1;
                if (lastVisibleItemPosition == itemTotalCount) {

                    pageNum++;

                    Log.d("jhTest", "last Position...");

                    // DataAdd("신진훈" + itemTotalCount, "ㅎㅎㅎㅎ");
                    //
                    getNews();
                    //  mAdapter.notifyDataSetChanged();    // 새로 고침
                }
            }
        });
    }


    public void DataAdd(String title_nm, String contents){
        VolleyRecyclerAddData VolleyRecyclerData = new VolleyRecyclerAddData(R.mipmap.ic_launcher, title_nm, contents);
        arrayList.add(VolleyRecyclerData);
    }

    public void getNews(){
        // Instantiate the RequestQueue.
        Log.d("jhTest","getNews() 호출 " + URL);
        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //  Log.d("jhTest",response);

                        try {

                            //  Log.d("jhTest","getNews() 호출실행");

                            JSONObject jsonObject = new JSONObject(response);

                            //JSONArray jCnt = jsonObject.getJSONArray("articles");
                            JSONArray jCnt = jsonObject.getJSONObject("body").getJSONArray("list");

                            //  Log.d("jhTest","Array Cnt=" + jCnt.length());

                            for (int i=0; i < jCnt.length(); i++ ) {

                                String title_nm  = jCnt.getJSONObject(i).getString("answer");
                                String contents  = jCnt.getJSONObject(i).getString("contents");

                                //  Log.d("jhTest","title_nm=" + title_nm );
                                //  Log.d("jhTest","contents=" + contents);

                                DataAdd(title_nm, contents);    // 데이타 추가
                            }
                            mAdapter.notifyDataSetChanged();    // 새로 고침

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                params.put("pageNum", String.valueOf(pageNum));
                params.put("pageRowCount", String.valueOf(pageRowCount));
                return params;
            }
        };

        // Add the request to the RequestQueue.
        queue.add(stringRequest);
        //mAdapter.notifyDataSetChanged();    // 여기서 새로 고침 하면 안됨
    }
}
