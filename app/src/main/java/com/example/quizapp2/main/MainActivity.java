package com.example.quizapp2.main;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.quizapp2.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_frame,new MainFragment())
                .commit();
    }
}
