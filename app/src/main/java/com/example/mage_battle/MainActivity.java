package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.mage_battle.Server;
import com.example.mage_battle.inventory.Rune;
import com.example.mage_battle.inventory.Spell;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = this.getApplicationContext();

        setContentView(R.layout.activity_main);
        RequestQueue queue = Volley.newRequestQueue(this);

        TextView results = findViewById(R.id.maintext);
        results.setText("I am running");

        JSONObject json = new JSONObject();
        try {
            json.put("spell","Life Transfusion");
//            json.put("r2","Fire");
        } catch (JSONException e) {
            e.printStackTrace();
        }


        // URL:
        String url = "http://109.234.37.174/get_random_question/";
        JsonObjectRequest obreq = new JsonObjectRequest(Request.Method.POST, url, json,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        TextView results = findViewById(R.id.maintext);
                        results.setText("I got response");
//                        try {
//                            String data = "";
//                            String spell = response.getString("spell");
//                            data = spell;

                            // WHAT TO DO WITH RESULT:
                            results.setText(response.toString());
//                        }
//                        catch (JSONException e) {
//                            e.printStackTrace();
//                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("Volley", "Error");
                    }
                }
        );
        queue.add(obreq);
    }
}
