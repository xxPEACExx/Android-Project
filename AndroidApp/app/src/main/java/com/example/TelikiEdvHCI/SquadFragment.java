package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class SquadFragment extends Fragment implements View.OnClickListener {

    Button buttonInsert, buttonUpdate, buttonDelete ;

    public SquadFragment(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_squad,container, false);

        buttonInsert = view.findViewById(R.id.insertSquadButton);
        buttonInsert.setOnClickListener(this);

        buttonUpdate = view.findViewById(R.id.updateSquadButton);
        buttonUpdate.setOnClickListener(this);

        buttonDelete = view.findViewById(R.id.deleteSquadButton);
        buttonDelete.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.insertSquadButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SquadInsert()).addToBackStack(null).commit();
                break;
            case R.id.updateSquadButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SquadUpdate()).addToBackStack(null).commit();
                break;
            case R.id.deleteSquadButton:
                MainActivity.fragmentManager.beginTransaction().replace(R.id.fragment_container, new SquadDelete()).addToBackStack(null).commit();
                break;
        }

    }
}
