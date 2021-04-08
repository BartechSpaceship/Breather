package com.example.breathforme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.breathforme.Fragments.Home;
import com.example.breathforme.cardFragments.Types;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class PickerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picker);
        openFragment();
    }
    private void openFragment(){
        //Sets up bottom Nav + Fragments
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_picker, new Types()).commit();

    }

}