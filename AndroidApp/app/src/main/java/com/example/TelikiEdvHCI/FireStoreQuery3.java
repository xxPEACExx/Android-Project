package com.example.TelikiEdvHCI;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


/**
 * A simple {@link Fragment} subclass.
 */
public class FireStoreQuery3 extends Fragment {
    TextView querytextresult;

    public FireStoreQuery3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_3, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresult);
        CollectionReference collectionReference = MainActivity.db.
                collection("Agwnes");
        collectionReference.
                get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                String result = "";
                int count = 0;
                for(QueryDocumentSnapshot documentSnapshot: queryDocumentSnapshots){
                    Games games = documentSnapshot.toObject(Games.class);

                    String away = games.getAway();
                    String city =games.getCity();
                    String country = games.getCountry();
                    String date = games.getDate();
                    String home = games.getHome();
                    Integer matchID =games.getMatchID();
                    String score =games.getScore();
                    Integer sportID = games.getSportID();
                    String sportType = games.getSportType();

                    count ++;
                    result+=" FIRE BASE DOCUMENT ID "+count+
                            "\n Away              -->   " + away +
                                    "\n City                 -->   "+ city +
                                    "\n Country         -->   " + country +
                                    "\n Date               -->   " + date+
                                    "\n Home             -->   " +home +
                                    "\n Match ID       -->   "+matchID +
                                    "\n Score             -->   "+score +
                                    "\n Sport ID         -->   "+sportID +
                                    "\n Sport Type   -->   "+sportType+"\n\n";
                }
                querytextresult.setText(result);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"query operation failed.", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}
