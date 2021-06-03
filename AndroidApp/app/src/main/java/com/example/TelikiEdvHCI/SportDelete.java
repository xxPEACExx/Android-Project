package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SportDelete  extends Fragment {
    EditText editText;
    Button button;

    public SportDelete() {

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view =inflater.inflate(R.layout.fragment_sports_delete,container,false);
        editText = view.findViewById(R.id.deleteSportID);
        button = view.findViewById(R.id.deleteSportSubmitButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_sportId = 0;
                try {
                    var_sportId = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                if(var_sportId != 0) {
                    Sport sport = new Sport();
                    sport.setSportID(var_sportId);
                    MainActivity.myDatabase.mydao().deleteSport(sport);
                    Toast.makeText(getActivity(), " Successfully Deleted To Sport ID : " + var_sportId, Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(getActivity(),"Insert An ID",Toast.LENGTH_LONG).show();
                }
                editText.setText("");
            }
        });
        return view;

    }
}