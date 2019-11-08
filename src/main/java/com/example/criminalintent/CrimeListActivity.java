package com.example.criminalintent;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

public class CrimeListActivity extends SimpleFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
    }

    @Override
    public Fragment createFragment() {
        return new CrimeListFragment();
    }
}
