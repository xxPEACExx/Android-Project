package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AthleteInsert extends Fragment  {
    EditText editText1,editText2,editText3,editText4,editText5,editText6,editText7,editText8;
    Button sibn;

    public AthleteInsert(){

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_athletes_insert,container,false);

        editText1 =view.findViewById(R.id.insertIDAthlete);
        editText2 =view.findViewById(R.id.insertNameAthlete);
        editText3 =view.findViewById(R.id.insertSurenameAthlete);
        editText4 =view.findViewById(R.id.insertAgeAthlete);
        editText5 = view.findViewById(R.id.insertCityAthlete);
        editText6 =view.findViewById(R.id.insertNationalityAthlete);
        editText7 =view.findViewById(R.id.insertSportIDAthlete);
        editText8 =view.findViewById(R.id.insertGenderAthlete);

        sibn = view.findViewById(R.id.insertAthleteSubmitButton);
        sibn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int var_athleteID=0;
                try {
                    var_athleteID = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                String var_athleteName =editText2.getText().toString();
                String var_athleteSurename = editText3.getText().toString();

                int var_age=0;
                try {
                    var_age = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                String var_city = editText5.getText().toString();
                String var_nationality = editText6.getText().toString();
                int var_sportID=0;
                try {
                    var_sportID = Integer.parseInt(editText7.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                String var_gender = editText8.getText().toString();

                if (var_athleteID != 0 && var_athleteName != null && var_athleteSurename != null && var_age != 0 && var_city != null
                        && var_nationality != null && var_sportID !=0 ) {
                    if(var_gender != null && var_gender.equals("Male") || var_gender.equals("Female")) {

                        try {
                            Athlete athlete = new Athlete();
                            athlete.setIdAthlete(var_athleteID);
                            athlete.setName(var_athleteName);
                            athlete.setSurename(var_athleteSurename);
                            athlete.setAge(var_age);
                            athlete.setCity(var_city);
                            athlete.setNationality(var_nationality);
                            athlete.setSportID(var_sportID);
                            athlete.setGender(var_gender);



                            MainActivity.myDatabase.mydao().insertAthlete(athlete);
                            Toast.makeText(getActivity(), "The ID '" + var_athleteID + "'  With Name '" + var_athleteName + "' Was Successfully Register", Toast.LENGTH_LONG).show();

                        } catch (Exception e) {
                            String message = e.getMessage();
                            Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
                        }


                    }
                    else {
                        Toast.makeText(getActivity(),"Gender Must Be Male OR Female",Toast.LENGTH_LONG).show();
                    }

                }
                else{
                    Toast.makeText(getActivity(),"You need to complete all the data",Toast.LENGTH_LONG).show();
                }

                editText1.setText("");
                editText2.setText("");
                editText3.setText("");
                editText4.setText("");
                editText5.setText("");
                editText6.setText("");
                editText7.setText("");
                editText8.setText("");


            }




        });
        return view;
    }

}

