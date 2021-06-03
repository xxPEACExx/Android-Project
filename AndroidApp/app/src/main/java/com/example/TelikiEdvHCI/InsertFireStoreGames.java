package com.example.TelikiEdvHCI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;

/**
 * A simple {@link Fragment} subclass.
 */
public class InsertFireStoreGames extends Fragment {
    EditText editText1, editText2, editText3, editText4,editText5, editText6, editText7, editText8,editText9;
    Button bn;
    public InsertFireStoreGames() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_firestore, container, false);

        editText1 = view.findViewById(R.id.GamesEditText1);
        editText2 = view.findViewById(R.id.GamesEditText2);
        editText3 = view.findViewById(R.id.GamesEditText3);
        editText4 = view.findViewById(R.id.GamesEditText4);
        editText5 = view.findViewById(R.id.GamesEditText5);
        editText6 = view.findViewById(R.id.GamesEditText6);
        editText7 = view.findViewById(R.id.GamesEditText7);
        editText8 = view.findViewById(R.id.GamesEditText8);
        editText9 = view.findViewById(R.id.GamesEditText9);

        bn = view.findViewById(R.id.insertGamesSubmitButton);
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String var_date = editText1.getText().toString();
                String var_city = editText2.getText().toString();
                String var_country = editText3.getText().toString();

                int var_sportID = 0;
                try {
                    var_sportID = Integer.parseInt(editText4.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                String var_home = editText5.getText().toString();
                String vat_away = editText6.getText().toString();
                String var_score = editText7.getText().toString();

                int var_matchID = 0;
                try {
                    var_matchID = Integer.parseInt(editText8.getText().toString());
                } catch (NumberFormatException ex) {
                    System.out.println("Could not parse " + ex);
                }

                String var_sportType=editText9.getText().toString();


                try {

                    Games games = new Games();
                    games.setDate(var_date);
                    games.setCity(var_city);
                    games.setCountry(var_country);
                    games.setSportID(var_sportID);
                    games.setHome(var_home);
                    games.setAway(vat_away);
                    games.setScore(var_score);
                    games.setMatchID(var_matchID);
                    games.setSportType(var_sportType);
                    if (var_matchID !=0) {

                        MainActivity.db.
                                collection("Agwnes").
                                document("" + var_matchID).
                                set(games).

                                addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        Toast.makeText(getActivity(), "The Next Match is on "+var_date+ "In City '"+var_city+"'", Toast.LENGTH_LONG).show();
                                    }
                                })

                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(getActivity(),"add operation failed.",Toast.LENGTH_LONG).show();
                                }
                            });}else {
                        Toast.makeText(getActivity(),"You Need To Complete The Match ID",Toast.LENGTH_LONG).show();
                    }
                } catch (Exception e) {
                    String message = e.getMessage();
                    Toast.makeText(getActivity(),message,Toast.LENGTH_LONG).show();
                }
            }
        });
        editText1.setText("");
        editText2.setText("");
        editText3.setText("");
        editText4.setText("");
        editText5.setText("");
        editText6.setText("");
        editText7.setText("");
        editText8.setText("");
        editText9.setText("");
        return view;
    }
}
