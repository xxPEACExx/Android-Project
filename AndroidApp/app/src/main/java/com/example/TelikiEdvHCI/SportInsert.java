package com.example.TelikiEdvHCI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SportInsert  extends Fragment {

    EditText editText1,editText2,editText3,editText4;
    Button sibn;

    public SportInsert(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_sports_insert,container,false);
        editText1 =view.findViewById(R.id.insertSportID);
        editText2 = view.findViewById(R.id.insertNameSport);
        editText3 = view.findViewById(R.id.insertTypeSport);
        editText4 = view.findViewById(R.id.insertGenderSport);

        sibn = view.findViewById(R.id.insertSportSubmitButton);
        sibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_sportID=0;
                try {
                    var_sportID = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String var_sportName=editText2.getText().toString();
                String var_sportType = editText3.getText().toString();
                String var_sportGender = editText4.getText().toString();

                if(var_sportID !=0 && var_sportName != null && var_sportType != null && editText4 != null) {

                    try {
                        Sport sport = new Sport();
                        sport.setSportID(var_sportID);
                        sport.setName(var_sportName);
                        sport.setType(var_sportType);
                        sport.setGender(var_sportGender);

                        MainActivity.myDatabase.mydao().insertSport(sport);
                        Toast.makeText(getActivity(), "The Sport Is '" + var_sportName + "'  With ID " + var_sportID + " Was Successfully Register", Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();

                    }
                }else
                {
                    Toast.makeText(getActivity(),"You need to complete all the data",Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
            }
        });
        return  view;


    }
}
