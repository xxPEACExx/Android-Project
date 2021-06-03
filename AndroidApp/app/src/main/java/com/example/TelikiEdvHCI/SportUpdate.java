package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SportUpdate extends Fragment {

    EditText editText1,editText2,editText3,editText4;
    Button sibn;

    public SportUpdate(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sports_update,container,false);

        editText1 = view.findViewById(R.id.updateSportID);
        editText2 = view.findViewById(R.id.updateNameSport);
        editText3 = view.findViewById(R.id.updateTypeSport);
        editText4 = view.findViewById(R.id.updateGenderSport);

        sibn = view.findViewById(R.id.updateSportSubmitButton);
        sibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_sportID = 0;
                try {
                    var_sportID = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String var_nameSport = editText2.getText().toString();
                String var_typeSport = editText3.getText().toString();
                String var_genderSport = editText4.getText().toString();

                if(var_sportID !=0 && var_nameSport != null && var_typeSport != null && editText4 != null) {

                    try {
                        Sport sport = new Sport();
                        sport.setSportID(var_sportID);
                        sport.setName(var_nameSport);
                        sport.setType(var_typeSport);
                        sport.setGender(var_genderSport);

                        MainActivity.myDatabase.mydao().updateSport(sport);
                        Toast.makeText(getActivity(), "Successful Update To Sport ID : " + var_sportID, Toast.LENGTH_LONG).show();
                    } catch (Exception e) {
                        String message = e.getMessage();
                        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                    }
                }else {
                    Toast.makeText(getActivity(),"You need to complete all the data",Toast.LENGTH_LONG).show();
                }
                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
            }

        });
        return view;


    }

}
