package com.project.denail.antriku;

/**
 * Created by denail on 17/09/20.
 */

public interface OnSendResponse {
    void onSuccess(String result);
    void onFailure(String error);
}
