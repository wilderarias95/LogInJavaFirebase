package com.fracessoftware.loginjavafirebase.main;

import android.support.annotation.NonNull;

import com.fracessoftware.loginjavafirebase.UserInformation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class MainRepository implements IMainRepository {

    private IMainMVP.Model model;
    private FirebaseAuth mAuth;
    private FirebaseUser firebaseUser;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    MainRepository(IMainMVP.Model model) {
        this.model = model;
        mAuth = FirebaseAuth.getInstance();
        firebaseUser = mAuth.getCurrentUser();
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("user_information");
    }

    @Override
    public void signOutUser() {
        mAuth.signOut();
    }

    @Override
    public void writeRTDatabase() {

        LocalDateTime localDateTime = LocalDateTime.now();
        ZoneId zoneId = ZoneId.systemDefault();
        final Long dateLong = localDateTime.atZone(zoneId).toEpochSecond();
        final String dateString = dateLong.toString();
        final long l = Long.parseLong(dateString);
        final UserInformation userInformation = new UserInformation("Wilder"+dateString, "Arias",
                "Barrio obrero", "6125487");
        databaseReference.child(dateString).setValue(userInformation).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    model.writeRTDataSuccessful();
                }

            }
        });

        /*databaseReference.setValue("Hello, World").addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    model.writeRTDataSuccessful();
                }

            }
        });*/

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                String value = "";
                if (dataSnapshot.exists()){
                    value=dataSnapshot.child(dateString).getValue(UserInformation.class).firstName;
                }

                //model.dataChange(value);
                model.dataChange("Writing Structured Data with Java" + dateLong+"value: "+value);
                //model.dataChange(dataSnapshot.getValue(String.class));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                model.failedReadRT();
            }
        });
    }

    @Override
    public boolean isUserAuthenticated() {
        return firebaseUser != null;
    }

    @Override
    public String getUserEmail() {
        return firebaseUser.getEmail();
    }

    @Override
    public void updateRTChild(String child) {
        HashMap<String, Object> update = new HashMap<>();
        update.put("firstName", "James");
        databaseReference.child(child).updateChildren(update);
    }

    @Override
    public void removeRTChild(String child) {
        databaseReference.child(child).removeValue();
    }
}
