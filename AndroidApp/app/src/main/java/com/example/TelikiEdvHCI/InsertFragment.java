package com.example.TelikiEdvHCI;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFragment extends Fragment implements View.OnClickListener {
    Button Bn_ins_Sailor, Bn_query1, Bn_query2, Bn_query3, Bn_query4;

    public InsertFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert, container, false);

        Bn_ins_Sailor = view.findViewById(R.id.insertGameButton);
        Bn_ins_Sailor.setOnClickListener(this);

        Bn_query1 = view.findViewById(R.id.queryButton1);
        Bn_query1.setOnClickListener(this);

        Bn_query2 = view.findViewById(R.id.queryButton2);
        Bn_query2.setOnClickListener(this);

        Bn_query3 = view.findViewById(R.id.queryButton3);
        Bn_query3.setOnClickListener(this);


        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.insertGameButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertFireStoreGames()).addToBackStack(null).commit();
                break;

            case R.id.queryButton1:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new FireStoreQuery1()).addToBackStack(null).commit();
                break;

            case R.id.queryButton2:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new FireStoreQuery2()).addToBackStack(null).commit();
                break;


            case R.id.queryButton3:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new FireStoreQuery3()).addToBackStack(null).commit();
                break;

        }
    }
}
