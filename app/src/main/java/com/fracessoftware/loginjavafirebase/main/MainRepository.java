package com.fracessoftware.loginjavafirebase.main;

import com.google.firebase.auth.FirebaseAuth;

class MainRepository implements IMainRepository {

    IMainMVP.Model model;
    private FirebaseAuth mAuth;

    MainRepository(IMainMVP.Model model){
        this.model = model;
    }

    @Override
    public void signOutUser() {
        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();
    }
}
