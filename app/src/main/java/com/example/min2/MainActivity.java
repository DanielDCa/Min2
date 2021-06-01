package com.example.min2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void getPerfil(View view){
        Intent intent = new Intent(this,InfoActivity.class);
        startActivity(intent);
    }

    public void getInsignias(View view) {
        Intent intent = new Intent(this,InsigActivity.class);
        startActivity(intent);
    }
}