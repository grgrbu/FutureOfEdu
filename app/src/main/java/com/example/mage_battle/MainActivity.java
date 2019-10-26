package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.content.Intent;
import android.widget.Button;

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
