package com.project.denail.antriku;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessaging;

public class MainActivity extends AppCompatActivity {

    private final String TOKEN = "2bc8ddb375bfbd7dd58d266abb9237b0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("TEST-ID", FirebaseInstanceId.getInstance().getToken());
                FirebaseMessaging.getInstance().subscribeToTopic(TOKEN);
                Log.d("TEST", TOKEN);
            }
        });
    }
}
