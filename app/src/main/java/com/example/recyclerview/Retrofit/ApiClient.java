package com.example.recyclerview.Retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String Base_url = "http://mdoli.dothome.co.kr";
    public static Retrofit retrofit = null;

    public  static  Retrofit getApiclient(){
        if(retrofit == null){
            retrofit = new Retrofit.Builder().baseUrl(Base_url).addConverterFactory(GsonConverterFactory.create()).build();
        }
        
        return retrofit;
    }
}
