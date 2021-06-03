package com.example.TelikiEdvHCI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class SquadDelete extends Fragment {


    EditText editText1;
    Button button;

    public SquadDelete(){

    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        View view =inflater.inflate(R.layout.fragment_squad_delete,container,false);

        editText1=view.findViewById(R.id.deleteSquadWithID);

        button = view.findViewById(R.id.deleteSquadSumbitButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int var_id = 0;
                try {
                    var_id = Integer.parseInt(editText1.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }
                if (var_id != 0) {


                    Squad squad = new Squad();
                    squad.setIdSquad(var_id);
                    MainActivity.myDatabase.mydao().deleteSquad(squad);
                    Toast.makeText(getActivity(), " Successfully Deleted To Squad ID : " + var_id, Toast.LENGTH_LONG).show();
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
