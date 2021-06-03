package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MainFragmentChoise extends Fragment implements View.OnClickListener {

    Button Bn_athlete, Bn_sport, Bn_squad, Bn_query,Bn_firebase;


    public MainFragmentChoise(){

    }




    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_choise,container, false);

        Bn_athlete = view.findViewById(R.id.athleteButton);
        Bn_athlete.setOnClickListener(this);

        Bn_sport = view.findViewById(R.id.sportsButton);
        Bn_sport.setOnClickListener(this);

        Bn_squad = view.findViewById(R.id.squadButton);
        Bn_squad.setOnClickListener(this);

        Bn_query = view.findViewById(R.id.queryButton);
        Bn_query.setOnClickListener(this);

        Bn_firebase = view.findViewById(R.id.firebaseButton);
        Bn_firebase.setOnClickListener(this);




        return view;
    }



    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.athleteButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new AthleteFragment()).addToBackStack(null).commit();
                break;

            case R.id.sportsButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SportFragment()).addToBackStack(null).commit();
                break;

           case R.id.squadButton :
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SquadFragment()).addToBackStack(null).commit();
                break;
            case R.id.queryButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new QueryFragment()).addToBackStack(null).commit();
                break;
            case R.id.firebaseButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new InsertFragment()).addToBackStack(null).commit();
                break;
        }
    }
}
