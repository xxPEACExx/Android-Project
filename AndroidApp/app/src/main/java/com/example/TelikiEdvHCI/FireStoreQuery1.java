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
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;

/**
 * A simple {@link Fragment} subclass.
 */
public class FireStoreQuery1 extends Fragment {
    TextView querytextresult;
    DocumentReference documentReference;
    public FireStoreQuery1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_query_1, container, false);
        querytextresult = view.findViewById(R.id.txtqueryresult);
        documentReference = MainActivity.db.
                collection("Agwnes").
                document("2");

        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                if(documentSnapshot.exists()){
                    String away = documentSnapshot.getString("away");
                    String city = documentSnapshot.getString("city");
                    String country = documentSnapshot.getString("country");
                    String date = documentSnapshot.getString("date");
                    String home = documentSnapshot.getString("home");

                    Double matchID = documentSnapshot.getDouble("matchID");
                    String score = documentSnapshot.getString("score");
                    Double sportID = documentSnapshot.getDouble("sportID");
                    String sportType = documentSnapshot.getString("sportType");

                    querytextresult.setText(" Away              -->   " + away +
                            "\n City                 -->  "+ city +
                            "\n Country         -->   " + country +
                            "\n Date               -->   " + date+
                            "\n Home            -->    " +home +
                            "\n Match ID       -->   "+matchID +
                            "\n Score             -->   "+score +
                            "\n Sport ID         -->   "+sportID +
                            "\n Sport Type    -->   "+sportType);
                } else {
                    Toast.makeText(getActivity(),"document does not exist.",Toast.LENGTH_LONG).show();
                }
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(getActivity(),"document does not exist.",Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }
}