package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SportFragment extends Fragment implements View.OnClickListener {

    Button Bn_insertSport, Bn_deleteSport, Bn_updateSport;

    public SportFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports,container,false);


        Bn_insertSport = view.findViewById(R.id.insertSportButton);
        Bn_insertSport.setOnClickListener(this);

        Bn_deleteSport =view.findViewById(R.id.deleteSportButton);
        Bn_deleteSport.setOnClickListener(this);

        Bn_updateSport =view.findViewById(R.id.updateSportButton);
        Bn_updateSport.setOnClickListener(this);


        return view;

    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.insertSportButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SportInsert()).addToBackStack(null).commit();
                break;

            case R.id.deleteSportButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SportDelete()).addToBackStack(null).commit();
                break;

            case R.id.updateSportButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SportUpdate()).addToBackStack(null).commit();
                break;
        }
    }
}
