package com.example.pgtabme.API;




import com.example.pgtabme.Model.DataModel;


import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;


public interface APIInterface {


    @GET("allapi")
    Call<ArrayList<DataModel>> getAll();

    @GET("shirpastorize")
    Call<ArrayList<DataModel>> getshirpastorize();

    @GET("shirestril")
    Call<ArrayList<DataModel>> getshirestril();

    @GET("shirsade")
    Call<ArrayList<DataModel>> getshirsade();

    @GET("shirtamdar")
    Call<ArrayList<DataModel>> getshirtamdar();

    @GET("khame")
    Call<ArrayList<DataModel>> getkhame();

    @GET("kareroghan")
    Call<ArrayList<DataModel>> getkareroghan();

    @GET("mosir")
    Call<ArrayList<DataModel>> getmosir();

    @GET("hamzade")
    Call<ArrayList<DataModel>> gethamzade();

    @GET("mastmamoli")
    Call<ArrayList<DataModel>> getmastmamoli();

    @GET("paniruf")
    Call<ArrayList<DataModel>> getpaniruf();

    @GET("anvaepanir")
    Call<ArrayList<DataModel>> getanvaepanir();

    @GET("doghnayloni")
    Call<ArrayList<DataModel>> getdoghnayloni();

    @GET("doghyekonim")
    Call<ArrayList<DataModel>> getdoghyekonim();

    @GET("sayerdogh")
    Call<ArrayList<DataModel>> getsayerdogh();

    @GET("abmivedevist")
    Call<ArrayList<DataModel>> getabmivedevist();

    @GET("abmiveyeklitri")
    Call<ArrayList<DataModel>> getabmiveyeklitri();

    @GET("poodri")
    Call<ArrayList<DataModel>> getpoodri();

    @GET("kashksayerlabani")
    Call<ArrayList<DataModel>> getkashksayerlabani();

    @GET("gheyrelabani")
    Call<ArrayList<DataModel>> getgheyrelabani();


}
