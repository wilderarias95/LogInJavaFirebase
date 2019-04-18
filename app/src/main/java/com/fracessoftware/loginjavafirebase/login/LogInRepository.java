package com.fracessoftware.loginjavafirebase.login;

import android.support.annotation.NonNull;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


class LogInRepository implements ILogInRepository {

    private ILogInMVP.Model model;
    private FirebaseAuth mAuth;

    LogInRepository(ILogInMVP.Model model) {
        this.model = model;
        mAuth = FirebaseAuth.getInstance();
    }

    @Override
    public void authenticationFirebase(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            model.userLogInSuccessful();
                        } else {
                            model.userLogInUnSuccessful();
                        }
                    }
                });
    }

    @Override
    public boolean isUserAuthenticated() {
    return mAuth.getCurrentUser() != null;
    }
}
