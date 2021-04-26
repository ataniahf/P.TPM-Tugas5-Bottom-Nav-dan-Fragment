package com.fti.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView botNavbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botNavbar = findViewById(R.id.main_navbar);
        botNavbar.setOnNavigationItemSelectedListener(this);
        loadFragment(new HomeFragment());


    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.main_frame,fragment)
                    .commit();
            return true;
        }
        return false;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()){
            case R.id.ic_home:
                fragment = new HomeFragment();
                break;
            case R.id.ic_list:
                fragment = new ListFragment();
                break;
            case R.id.ic_profil:
                fragment = new PhoneFragment();
                break;

        }
        return loadFragment(fragment);
    }
}