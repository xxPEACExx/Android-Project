package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;


public class AthleteFragment extends Fragment implements View.OnClickListener {

    Button Bn_insertAthlete, Bn_deleteAthlete, Bn_updateAthlete;

    public AthleteFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_athletes,container,false);


        Bn_insertAthlete = view.findViewById(R.id.insertAthleteButton);
        Bn_insertAthlete.setOnClickListener(this);

        Bn_deleteAthlete =view.findViewById(R.id.deleteAthleteButton);
        Bn_deleteAthlete.setOnClickListener(this);

        Bn_updateAthlete =view.findViewById(R.id.updateAthleteButton);
        Bn_updateAthlete.setOnClickListener(this);


        return view;

    }



    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.insertAthleteButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container,new AthleteInsert()).addToBackStack(null).commit();
                break;

            case R.id.deleteAthleteButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AthleteDelete()).addToBackStack(null).commit();
                break;

            case R.id.updateAthleteButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AthleteUpdate()).addToBackStack(null).commit();
                break;


        }

    }
}
