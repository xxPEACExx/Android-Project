package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SquadUpdate  extends Fragment {

    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7;
    Button sibn;

    public SquadUpdate(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        android.view.View view = inflater.inflate(R.layout.fragment_squad_update, container, false);

        editText1 = view.findViewById(R.id.updateIDSquad);
        editText2 = view.findViewById(R.id.updateNameSquad);
        editText3 = view.findViewById(R.id.updateStudiumSquad);
        editText4 = view.findViewById(R.id.updateCitySquad);
        editText5 = view.findViewById(R.id.updateNationalitySquad);
        editText6 = view.findViewById(R.id.updateSportIDSquad);
        editText7 = view.findViewById(R.id.updateYearSquad);

        sibn = view.findViewById(R.id.updateSquadSubmitButton);
        sibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_insertSquadID = 0;
                try {
                    var_insertSquadID = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String var_name = editText2.getText().toString();
                String var_studium = editText3.getText().toString();
                String var_city = editText4.getText().toString();
                String var_nationality = editText5.getText().toString();
                int var_SquadID = 0;
                try {
                    var_SquadID = Integer.parseInt(editText6.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                int var_year = 0;
                try {
                    var_year = Integer.parseInt(editText7.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                if(var_insertSquadID != 0 && var_name != null && var_studium != null && var_city != null && var_nationality != null
                        && var_SquadID != 0 && var_year != 0) {
                    try {
                        Squad squad = new Squad();
                        squad.setIdSquad(var_insertSquadID);
                        squad.setName(var_name);
                        squad.setStadiumName(var_studium);
                        squad.setCity(var_city);
                        squad.setNationality(var_nationality);
                        squad.setSportID(var_SquadID);
                        squad.setYear(var_year);

                        MainActivity.myDatabase.mydao().updateSquad(squad);
                        Toast.makeText(getActivity(), "The Squad ID '" + var_insertSquadID + "'  Was Successfully Updated", Toast.LENGTH_LONG).show();
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
                editText5.setText("");
                editText6.setText("");
                editText7.setText("");

            }
        });
        return view;
    }
}
