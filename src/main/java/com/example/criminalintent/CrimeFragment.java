package com.example.criminalintent;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;


public class CrimeFragment extends Fragment {
    private static final String TAG = "WGJ_CrimeFragment";
    private static final String ARG_CRIME_ID = "crime_id";
    private static final String DIALOG_DATE = "DialogDate";
    private Crime mCrime;

    private EditText mCrimeTitle;
    private TextView mCrimeDetail;
    private CheckBox mCrimeSolved;
    private Button mDateButton;


    public CrimeFragment() {
        // Required empty public constructor
    }

    public static CrimeFragment newInstance(UUID crimeId) {
        Bundle args = new Bundle();
        args.putSerializable(ARG_CRIME_ID, crimeId);
        CrimeFragment fragment = new CrimeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate");
        if (getArguments() != null) {
            UUID crimeId = (UUID) getArguments().getSerializable(ARG_CRIME_ID);
            mCrime = CrimeLab.getInstance(getActivity()).getCrime(crimeId);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.fragment_crime, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mCrimeTitle = view.findViewById(R.id.crime_title);
        mCrimeDetail = view.findViewById(R.id.crime_detail);
        mCrimeSolved = view.findViewById(R.id.crime_solved);
        mDateButton = view.findViewById(R.id.crime_date);

        mCrimeTitle.setText(mCrime.getTilte());
        mCrimeDetail.setText(mCrime.getDate().toString());
        mCrimeSolved.setChecked(mCrime.isSolved());
        mDateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.show(fm, DIALOG_DATE);
            }
        });

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d(TAG, "onActivityCreated");
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach");

    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }


    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

}
