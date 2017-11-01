package com.example.shadmanahmed.package_room;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");
    OkHttpClient client = new OkHttpClient();
    String json;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void unlockPressed(View view) {
        // api call unlock the door
    }

    public void lockPressed(View view) {
        try {
            json = new JSONObject()
                    .put("access_token", "e09dbc05f1953e02e1c8622dbd4c69c399086516ead2d01ebb85b9aee5d6b63c")
                    .put("state", "unlock").toString();
            Log.e("json", json);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        String accessToken = "e09dbc05f1953e02e1c8622dbd4c69c399086516ead2d01ebb85b9aee5d6b63c";
        String state = "toggle";
        RequestBody body = RequestBody.create(JSON, json);
        Request request = new Request.Builder()
                .url("https://api.lockitron.com/v2/locks/9c8a1298-b9b4-4740-8b45-ab065b87a6f6?access_token=" + accessToken + "&state=" + state)
                .put(body)
                .build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e("Failed", e.toString());
            }

            @Override
            public void onResponse(Response response) throws IOException {
                Log.e("this is the res", response.toString());
            }
        });
    }

    ;
};


