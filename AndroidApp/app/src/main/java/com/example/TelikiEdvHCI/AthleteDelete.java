package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class AthleteDelete extends Fragment {

    EditText editText1;
    Button button;

    public AthleteDelete(){

    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){

        View view =inflater.inflate(R.layout.fragment_athletes_delete,container,false);

        editText1=view.findViewById(R.id.deleteID);
        button = view.findViewById(R.id.deleteButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int var_id = 0;
                try {
                    var_id = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                if(var_id != 0) {
                    Athlete athlete = new Athlete();
                    athlete.setIdAthlete(var_id);
                    MainActivity.myDatabase.mydao().deleteAthlete(athlete);
                    Toast.makeText(getActivity(), " Successfully Deleted To ID : " + var_id, Toast.LENGTH_LONG).show();
                }else
                {
                    Toast.makeText(getActivity(),"Insert An ID",Toast.LENGTH_LONG).show();
                }
                editText1.setText("");

            }



        });
        return view;
    }

}
