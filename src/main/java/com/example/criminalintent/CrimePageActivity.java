package com.example.criminalintent;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;
import java.util.UUID;

public class CrimePageActivity extends AppCompatActivity {


    private static final String EXTRA_CRIME_ID =
            "com.example.crimimalintent.crime_id";
    private ViewPager mViewPager;
    private List<Crime> mCrimes;

    public static Intent newIntent (Context packageContext, UUID crimeId){
        Intent intent = new Intent(packageContext, CrimePageActivity.class);
        intent.putExtra(EXTRA_CRIME_ID, crimeId);
        return intent;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crime_page);
        mViewPager = findViewById(R.id.crime_pager_view_pager);
        mCrimes = CrimeLab.getInstance(this).getCrimes();
        FragmentManager fm = getSupportFragmentManager();
        mViewPager.setAdapter(new FragmentStatePagerAdapter(fm) {
            @Override
            public Fragment getItem(int i) {
                Crime crime = mCrimes.get(i);
                return CrimeFragment.newInstance(crime.getId());
            }

            @Override
            public int getCount() {
                return mCrimes.size();
            }
        });
        UUID uuid = (UUID) getIntent().getSerializableExtra(EXTRA_CRIME_ID);
        for(int i = 0; i < mCrimes.size(); i++){
            if(mCrimes.get(i).getId().equals(uuid)){
                mViewPager.setCurrentItem(i);
                break;
            }
        }

    }
}
