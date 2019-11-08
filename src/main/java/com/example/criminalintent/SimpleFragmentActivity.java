package com.example.criminalintent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

public abstract class SimpleFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FragmentManager fg = getSupportFragmentManager();
        Fragment fragment = fg.findFragmentById(R.id.fragment_container);
        if(fragment == null){
            fragment = createFragment();
            fg.beginTransaction()
                    .add(R.id.fragment_container, fragment)
                    .commit();
        }
    }

    public abstract Fragment createFragment();
}
