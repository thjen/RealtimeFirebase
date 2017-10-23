package com.example.thjen.realtimefirebase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    DatabaseReference data;
    TextView tv;
    Button android,ios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv = (TextView) findViewById(R.id.tv);
        android = (Button) findViewById(R.id.android);
        ios = (Button) findViewById(R.id.ios);

        data = FirebaseDatabase.getInstance().getReference();

        data.child("Course").setValue("Xamarin");

        data.child("Course").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                tv.setText(dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        android.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.child("Course").setValue("Android");
            }
        });

        ios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.child("Course").setValue("IOS");
            }
        });

    }
}
