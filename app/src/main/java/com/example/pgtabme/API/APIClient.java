package com.example.pgtabme.API;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIClient {



    private  static Retrofit retrofit =null;

    private static  String BASE_URL="https://pgtab.info/home/";

    public  static  Retrofit getClient(){

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return  retrofit;



    }

    public static boolean isNetworkAvailable(AppCompatActivity activity){
     ConnectivityManager connectivityManager=(ConnectivityManager)activity.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activenetworkinfo=connectivityManager.getActiveNetworkInfo();
        return activenetworkinfo!=null&&activenetworkinfo.isConnected();


    }

}
