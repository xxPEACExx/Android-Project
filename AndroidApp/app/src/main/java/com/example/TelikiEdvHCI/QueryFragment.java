package com.example.TelikiEdvHCI;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.List;

public class QueryFragment extends Fragment {
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter;
    TextView querytextView, querytextresult;
    Button bnqueryrun;
    int test;
    public QueryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query, container, false);
        final String[] queryArray = getResources().getStringArray(R.array.queries_description_array);
        querytextView = view.findViewById(R.id.txtquery);
        spinner = view.findViewById(R.id.spinner);
        adapter = ArrayAdapter.createFromResource(getContext(), R.array.queries_array, R.layout.support_simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(R.layout.support_simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                querytextView.setText(queryArray[position]);
                test = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        querytextresult = view.findViewById(R.id.txtqueryresult);
        bnqueryrun = view.findViewById(R.id.queryrun);
        bnqueryrun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                querytextresult.setText("Wrong Result !" + test);
                int count=0;
                int countSport=0;
                int countSquad = 0;
                int countQuery1 = 0;
                int countQuery2 = 0;
                int countQuery3 = 0;
                String result ="";
                switch (test){
                    case 1:
                        List<Athlete> athlete= MainActivity.myDatabase.mydao().getAthletes();
                        for (Athlete i: athlete) {
                            int code = i.getIdAthlete();
                            String name = i.getName();
                            String surename = i.getSurename();
                            int age = i.getAge();
                            String city = i.getCity();
                            String nationality = i.getNationality();
                            int sportID =i.getSportID();
                            String gender = i.getGender();

                            count++;
                            result = result + "------------------  The Athlete Number "+count+" -----------------"+
                                    "\n\n   The Athlete Id                   :       "+code+
                                    "\n   The Athlete Name            :       "+name+
                                    "\n   The Athlete Surename    :       " + surename+
                                    "\n   The Athlete Age               :       "+age+
                                    "\n   The Athlete City               :       "+city+
                                    "\n   The Athlete Nationality   :       "+nationality+
                                    "\n   The Sport Id                      :       "+sportID+
                                    "\n   The Athlete Gender         :       "+gender+"\n\n";

                        }
                        querytextresult.setText(result);
                        break;
                    case 2:
                        List<Sport> sports = MainActivity.myDatabase.mydao().getSports();
                        for (Sport i: sports) {
                            int code = i.getSportID();
                            String name = i.getName();
                            String type = i.getType();
                            String gender =i.getGender();

                            countSport++;
                            result = result + "------------------  The Sport Number "+countSport+" -----------------"+
                                    "\n\n   The Sport Id                      :       "+code+
                                    "\n   The Sport Name               :       "+name+
                                    "\n   The Sport Type                 :       " + type+
                                    "\n   The Sport Gender             :       "+gender+"\n\n";


                        }
                        querytextresult.setText(result);
                        break;
                    case 3:
                        List<Squad> reserves = MainActivity.myDatabase.mydao().getSquads();
                        for (Squad i: reserves) {
                            int id = i.getIdSquad();
                            String name = i.getName();
                            String stadium = i.getStadiumName();
                            String city = i.getCity();
                            String nationality = i.getNationality();
                            int sportID = i.getSportID();
                            int year = i.getYear();
                            countSquad++;
                            result = result + "------------------  The Squad Number "+countSquad+" -----------------"+
                                    "\n\n   The Squad Id                        :       "+id+
                                    "\n   The Squad Name                 :       "+name+
                                    "\n   The Squad Stadium             :       " + stadium+
                                    "\n   The Squad City                     :       "+city+
                                    "\n   The Squad Country              :       "+nationality+
                                    "\n   The Sport Id                          :       "+sportID+
                                    "\n   The Squad Εstablishment   :       "+year+"\n\n";

                        }
                        querytextresult.setText(result);
                        break;

                    case 4:
                        List<Athlete> athletes = MainActivity.myDatabase.mydao().getQuery1();
                        for (Athlete i: athletes) {

                            int id = i.getSportID();
                            String name = i.getName();
                            String surename = i .getSurename();
                            String city = i.getCity();
                            String nationality = i.getNationality();

                            countQuery1++;
                            result = result + "--------------  Football Plyers From Spain "+countQuery1+" ---------"+
                                    "\n\n   The Sport Id                         :  "+id+
                                    "\n   The Athlete Name               :  "+name+
                                    "\n   The Athlete Surename        :  " + surename+
                                    "\n   The Athlete city                   :  "+city+
                                    "\n   The Athlete Nationality      :  "+nationality+"\n\n";


                        }
                        querytextresult.setText(result);
                        break;

                    case 5:
                        List<ResultStringInt> resultStringInts3 = MainActivity.myDatabase.mydao().getQuery2();
                        for (ResultStringInt i : resultStringInts3) {
                            String athlete_name = i.getField1();
                            int max_age = i.getField2();
                            String gender = i.getField3();
                            countQuery2++;
                            result = result + "------------------  The Athlete  "+gender+" -----------------"+
                                    "\n\n Athlete Name " + athlete_name +
                                    "\n Maximum Age: " + max_age +
                                    "\n Gender : "+gender+"\n\n\n";
                        }
                        querytextresult.setText(result);
                        break;

                    case 6:
                        List<ResultStringInt> resultStringInts34= MainActivity.myDatabase.mydao().getQuery3();
                        for (ResultStringInt i : resultStringInts34) {

                            String athlete_name = i.getField1();
                            int age = i.getField2();
                            String sport_name = i.getField3();

                            countQuery3++;
                            result = result + "--------------  The Athlete Female number  "+countQuery3+" ----------"+
                                    "\n\n Female Name      :  " + athlete_name +
                                    "\n Athlete Age          : " + age+
                                    "\n Sport Name         : "+sport_name+"\n\n\n";
                        }
                        querytextresult.setText(result);
                        break;



                }
            }
        });
        return view;
    }
}

