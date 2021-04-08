package com.example.breathforme;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.breathforme.Fragments.Home;
import com.example.breathforme.Fragments.Liked;
import com.example.breathforme.Fragments.Membership;
import com.example.breathforme.Fragments.Records;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private long backPressedTime;
    private Toast backToast;
    private SharedPreferences sharedPreferences;
    private int setInitialBreathCount, setInitialSetCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        registerBottomNavigation();
        openFragment();

    }
    private void registerBottomNavigation(){



    }
    private void showMainBottomSheet(){


    }
    private void openFragment(){
        //Sets up bottom Nav + Fragments
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new Home()).commit();

    }
    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectedFragment = null;
            BottomNavigationView bottomView = findViewById(R.id.bottom_navigation);
            Menu menu = bottomView.getMenu();

            //    getSupportActionBar().setDisplayHomeAsUpEnabled(true);

            switch (item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = new Home();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    break;
                case R.id.nav_records:
                    selectedFragment = new Records();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    break;
                case R.id.nav_liked:
                    selectedFragment = new Liked();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
                    break;
                case R.id.nav_membership:
                    selectedFragment = new Membership();
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();
            }
            return true;
        }
    };

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void finish() {
        super.finish();

    }

    @Override
    public void onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        } else {
            backToast = Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT);
            backToast.show();
        }
        backPressedTime = System.currentTimeMillis();


    }

}