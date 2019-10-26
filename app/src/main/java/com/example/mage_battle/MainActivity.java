package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;
import android.util.Log;
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

    private Button button_to_practise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity.context = this.getApplicationContext();

        setContentView(R.layout.activity_main);
    }

    public void openPractise() {
        Intent intent = new Intent(this, PractiseActivity.class);
        startActivity(intent);
    }
}
