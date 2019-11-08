package com.example.criminalintent;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeListFragment extends Fragment {

    private static final String TAG = "WGJ_CrimeListFragment";

    private RecyclerView mRecyclerView;
    private CrimeAdapter mCrimeAdapter;
    public CrimeListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        char a;

        return inflater.inflate(R.layout.fragment_crime_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = view.findViewById(R.id.crime_recycler_view);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//        updateUI();
    }

    @Override
    public void onResume() {
        super.onResume();
        updateUI();
    }

    private void updateUI(){
        CrimeLab crimeLab = CrimeLab.getInstance(getActivity());
        List<Crime> crimes = crimeLab.getCrimes();
        if(mCrimeAdapter == null){
            mCrimeAdapter = new CrimeAdapter(crimes);
            mRecyclerView.setAdapter(mCrimeAdapter);
        }else {
            mCrimeAdapter.notifyDataSetChanged();
        }


    }


    private class CrimeAdapter extends RecyclerView.Adapter<CrimeHolder>{

        private List<Crime> mCrimes;
        public CrimeAdapter(List<Crime> crimes){
            mCrimes = crimes;
        }

        @NonNull
        @Override
        public CrimeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
            LayoutInflater inflater = LayoutInflater.from(getActivity());
            return new CrimeHolder(inflater, viewGroup);
        }

        @Override
        public void onBindViewHolder(@NonNull CrimeHolder crimeHoder, int i) {
            Crime crime = mCrimes.get(i);
            crimeHoder.bind(crime);
        }

        @Override
        public int getItemCount() {
            return mCrimes.size();
        }
    }



    private class CrimeHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        private Crime mCrime;
        private TextView mTilteTextView;
        private TextView mDateTextView;
        public CrimeHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_crime, parent, false));
            mTilteTextView = itemView.findViewById(R.id.item_crime_title);
            mDateTextView = itemView.findViewById(R.id.item_crime_date);
            itemView.setOnClickListener(this);
        }

        public void bind(Crime crime){
            mCrime = crime;
            mTilteTextView.setText(crime.getTilte());
            mDateTextView.setText(crime.getDate().toString());
        }

        @Override
        public void onClick(View v) {
            Intent intent = CrimePageActivity.newIntent(getActivity(), mCrime.getId());
            startActivity(intent);
        }
    }
}
