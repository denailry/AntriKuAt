package com.project.denail.antriku;

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by denail on 17/08/28.
 */

public interface AntrianSendAPI {
    String URL_FILE = "/response_place.php";

    @FormUrlEncoded
    @POST(URL_FILE)
    void reserve(
            @Field("api_key") String apiKey,
            @Field("antrian_numb") Integer antrianNumb,
            @Field("antrian_code") String antrianCode,
            @Field("user_token") String userToken,
            Callback<Response> callback);
}
