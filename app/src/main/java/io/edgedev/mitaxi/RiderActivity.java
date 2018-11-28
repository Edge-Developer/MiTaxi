package io.edgedev.mitaxi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RiderActivity extends AppCompatActivity {
    private static final String TAG = "RiderActivity";
    private FirebaseAuth mAuth;
    private DatabaseReference mFirebaseDatabase;
    private FirebaseDatabase mFirebaseInstance;
    private String userId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rider);

        mAuth = FirebaseAuth.getInstance();

        userId = mAuth.getCurrentUser().getUid();

        mFirebaseInstance = FirebaseDatabase.getInstance();
        mFirebaseDatabase = mFirebaseInstance.getReference(getString(R.string.riders));

        String name = mAuth.getCurrentUser().getDisplayName();
        mFirebaseDatabase.child(userId).child("name").setValue(name);
    }

    private void updateUser(String name, String email, float lat, float lng, boolean needsRide) {
        // updating the user via child nodes
        if (!TextUtils.isEmpty(name))
            mFirebaseDatabase.child(userId).child("name").setValue(name);

        if (!TextUtils.isEmpty(email))
            mFirebaseDatabase.child(userId).child("email").setValue(email);
            mFirebaseDatabase.child(userId).child("latitude").setValue(lat);
            mFirebaseDatabase.child(userId).child("longitude").setValue(lng);
            mFirebaseDatabase.child(userId).child("needsRide").setValue(needsRide);
    }
}