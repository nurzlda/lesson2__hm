package com.example.lesson2_month3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // FrameLayout frameLayout = findViewById(R.id.container);
        getSupportFragmentManager().beginTransaction().add(R.id.frame_layout_container,
                new FirstFragment()).commit();
    }
}