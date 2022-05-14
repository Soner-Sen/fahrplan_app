package com.example.mentz;


import com.example.mentz.api_interface.APIInterface;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

        private static RetrofitClient instance = null;
        private APIInterface fahrplan_api;

        private RetrofitClient() {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(APIInterface.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            fahrplan_api = retrofit.create(APIInterface.class);
        }

        public static synchronized RetrofitClient getInstance() {
            if (instance == null) {
                instance = new RetrofitClient();
            }
            return instance;
        }

        public APIInterface getMyApi() {
            return fahrplan_api;
        }
}
