package com.example.mentz.api_interface;

import com.example.mentz.model.Fahrplan;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIInterface
{
    // https://mvvvip1.defas-fgi.de/mvv/XML_STOPFINDER_REQUEST?language=de&outputFormat=RapidJSON&type_sf=any&name_sf={Suchtext}
    String BASE_URL = "https://mvvvip1.defas-fgi.de/mvv/";

    @GET("XML_STOPFINDER_REQUEST")
    Call<Fahrplan> getList(
            @Query("20language") String de,
            @Query("outputFormat") String RapidJSON,
            @Query("type_sf") String any,
            @Query("name_sf") String text
    );
}
