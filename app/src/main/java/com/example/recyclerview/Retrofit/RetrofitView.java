package com.example.recyclerview.Retrofit;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.recyclerview.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitView extends AppCompatActivity {


    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private GridLayoutManager layoutManager;

    private ApiInterface apiInterface;
    private RecyclerAdapter adapter;

    private int page_number = 1;
    private int item_count = 10;

    //Variables for pagination

    private boolean isLoading = true;
    private int pastVisibleItems, visibleItemCount, totalItemCount, previous_total = 0;
    private int view_threshold = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.retrofit_view);

        progressBar = findViewById(R.id.progressBar);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this,2);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);

        apiInterface = ApiClient.getApiclient().create(ApiInterface.class);
        progressBar.setVisibility(View.VISIBLE);

        Call<List<DataResponse>> call = apiInterface.getImages(page_number, item_count);

        call.enqueue(new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {

                Log.d("jhTest","response : " + response);


                List<Images> images = response.body().get(1).getImages();
                adapter = new RecyclerAdapter(images, RetrofitView.this);
                recyclerView.setAdapter(adapter);
                Toast.makeText(RetrofitView.this,"First page is loaded..",Toast.LENGTH_SHORT).show();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {

            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                visibleItemCount = layoutManager.getChildCount();
                totalItemCount = layoutManager.getItemCount();
                pastVisibleItems = layoutManager.findFirstVisibleItemPosition();

                if(dy>0) {

                    if(isLoading){
                        if(totalItemCount > previous_total) {
                            isLoading = false;
                            previous_total = totalItemCount;

                        }
                    }

                    if(!isLoading && (totalItemCount-visibleItemCount) <= (pastVisibleItems+view_threshold)){
                        page_number++;
                        performPagaination();
                        isLoading = true;
                    }
                }
            }
        });

    }


    private void performPagaination(){

        progressBar.setVisibility(View.VISIBLE);

        Log.d("jhTest","page_number : " + page_number);
        Log.d("jhTest","item_count : " + item_count);

        Call<List<DataResponse>> call = apiInterface.getImages(page_number, item_count);

        call.enqueue(new Callback<List<DataResponse>>() {
            @Override
            public void onResponse(Call<List<DataResponse>> call, Response<List<DataResponse>> response) {

                Log.d("jhTest","response : " + response);

                if(response.body().get(0).getStatus().equals("ok")){
                    List<Images> images = response.body().get(1).getImages();
                    adapter.addImages(images);
                    Toast.makeText(RetrofitView.this,"Page " + page_number + " is loaded",Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(RetrofitView.this,"No more Images available..",Toast.LENGTH_SHORT).show();
                }

                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<DataResponse>> call, Throwable t) {

            }
        });
    }
}
