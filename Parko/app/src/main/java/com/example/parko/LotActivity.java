package com.example.parko;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LotActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference root = database.getReference();
    String block="";
    FrameLayout frameLayouts[]=new FrameLayout[6];
    FrameLayout frameLayout1;
    int p=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lot);
//        Log.v("FTag","Force");

        frameLayout1=findViewById(R.id.Block1);
        root.child("Block1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(String.valueOf(dataSnapshot.getValue()).equalsIgnoreCase("Yes")){


                        frameLayout1.setBackgroundColor(R.drawable.power_back);
                        Log.v("YesTag",String.valueOf(dataSnapshot));
                    }
                    else if(String.valueOf(dataSnapshot.getValue()).equalsIgnoreCase("No")){


                        frameLayout1.setBackgroundColor(R.drawable.out_back);
                        Log.v("NoTag",String.valueOf(dataSnapshot));
                    }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



//
//        for (int x=1;x<=6;x++){
//            block="Block"+x;
//            p=x-1;
//            root.child(block).addValueEventListener(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//
//
//
//                    if(String.valueOf(dataSnapshot.getValue()).equalsIgnoreCase("Yes")){
//
//                        frameLayouts[0]=findViewById(R.id.Block1);
//                        frameLayouts[1]=findViewById(R.id.Block2);
//                        frameLayouts[2]=findViewById(R.id.Block3);
//                        frameLayouts[3]=findViewById(R.id.Block4);
//                        frameLayouts[4]=findViewById(R.id.Block5);
//                        frameLayouts[5]=findViewById(R.id.Block6);
//
//
//                        frameLayouts[p].setBackgroundColor(R.drawable.power_back);
//                        Log.v("YesTag",String.valueOf(dataSnapshot));
//                    }
//                    else if(String.valueOf(dataSnapshot.getValue()).equalsIgnoreCase("No")){
//
//                        frameLayouts[0]=findViewById(R.id.Block1);
//                        frameLayouts[1]=findViewById(R.id.Block2);
//                        frameLayouts[2]=findViewById(R.id.Block3);
//                        frameLayouts[3]=findViewById(R.id.Block4);
//                        frameLayouts[4]=findViewById(R.id.Block5);
//                        frameLayouts[5]=findViewById(R.id.Block6);
//
//
//                        frameLayouts[p].setBackgroundColor(R.drawable.out_back);
//                        Log.v("NoTag",String.valueOf(dataSnapshot));
//                    }
//
////                    Toast.makeText(getBaseContext(),"CHeck Fire",Toast.LENGTH_SHORT).show();
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError databaseError) {
//
//                }
//            });
//
//
//
//        }


    }
}
