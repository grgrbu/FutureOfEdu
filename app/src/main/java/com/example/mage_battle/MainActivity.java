package com.example.mage_battle;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button_to_practise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_to_practise = (Button) findViewById(R.id.button_math);
        button_to_practise.setOnClickListener(new View.OnClickListener() {
            @Override
            public  void onClick(View v) {
                openPractise();
            }
        });
    }

    public void openPractise() {
        Intent intent = new Intent(this, PractiseActivity.class);
        startActivity(intent);
    }
}
