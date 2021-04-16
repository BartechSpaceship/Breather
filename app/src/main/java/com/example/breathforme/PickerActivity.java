package com.example.breathforme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.breathforme.Fragments.Home;
import com.example.breathforme.cardFragments.Sets;
import com.example.breathforme.cardFragments.Types;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PickerActivity extends AppCompatActivity {

    private final String TYPES = "TYPES";
    private final String BREATHS = "BREATHS";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        openFragment();
    }
    private void openFragment(){
        //Sets up bottom Nav + Fragments
        Intent getIntent = getIntent();
        String getFragmentIntent = getIntent.getStringExtra("key");

        if (getFragmentIntent.equals(TYPES)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_picker, new Types()).commit();
        } else if (getFragmentIntent.equals(BREATHS)) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_picker, new Sets()).commit();
        }


    }

}