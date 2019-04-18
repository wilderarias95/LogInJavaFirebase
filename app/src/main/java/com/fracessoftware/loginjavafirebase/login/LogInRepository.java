package com.fracessoftware.loginjavafirebase.login;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


class LogInRepository implements ILogInRepository{
    ILogInMVP.Model model;
    private FirebaseAuth mAuth;
    LogInRepository(ILogInMVP.Model model){
        this.model= model;
    }

    @Override
    public void authenticationFirebase(String email, String password) {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            model.userLogInSuccessful();
                        }else{
                            model.userLogInUnSuccessful();
                        }
                    }
                });
    }
}
