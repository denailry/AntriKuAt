package com.project.denail.antriku;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by denail on 17/09/20.
 */

public class APICallLib {
    public static final String API_KEY = "a9319aebea880e49c0a46c5e26fe1445";
    public static final String URL_ROOT = "http://dummy.levyson.com/bnihackfest/";

    public static void response(Integer antrianNumb, String antrianCode, String userToken, final OnSendResponse listener) {
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(URL_ROOT)
                .build();
        AntrianSendAPI api = adapter.create(AntrianSendAPI.class);
        api.reserve(API_KEY, antrianNumb, antrianCode, userToken, new Callback<Response>() {
            @Override
            public void success(Response result, Response response) {
                BufferedReader reader;
                String output;
                try {
                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));
                    output = reader.readLine();
                    listener.onSuccess(output);
                } catch (IOException e) {
                    listener.onSuccess(null);
                }
            }
            @Override
            public void failure(RetrofitError error) {
                listener.onFailure(error.toString());
            }
        });
    }
}
