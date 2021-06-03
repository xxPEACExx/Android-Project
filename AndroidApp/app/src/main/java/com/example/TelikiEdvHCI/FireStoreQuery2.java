package com.example.TelikiEdvHCI;
import android.content.Intent;
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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;


/**
 * A simple {@link Fragment} subclass.
 */
public class FireStoreQuery2 extends Fragment {
    TextView querytextresult;

    public FireStoreQuery2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_2, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresult);
        DocumentReference documentReference = MainActivity.db.
                collection("Agwnes").
                document("1");
        documentReference.
                get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
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


                    querytextresult.setText(" Away              -->   " + away +
                            "\n City                 -->   "+ city +
                            "\n Country         -->   " + country +
                            "\n Date               -->   " + date+
                            "\n Home             -->   " +home +
                            "\n Match ID       -->   "+matchID +
                            "\n Score             -->   "+score +
                            "\n Sport ID         -->   "+sportID +
                            "\n Sport Type   -->   "+sportType);



                } else {
                    Toast.makeText(getActivity(),"document does not exist.",Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"query operation failed.",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}
