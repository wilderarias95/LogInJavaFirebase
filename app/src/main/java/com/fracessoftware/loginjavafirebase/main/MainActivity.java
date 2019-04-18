package com.fracessoftware.loginjavafirebase.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.fracessoftware.loginjavafirebase.R;
import com.fracessoftware.loginjavafirebase.login.LogInActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity implements IMainMVP.View{

    TextView txtEmail;
    IMainMVP.PresenterView presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser == null){
            Intent intent= new Intent(this, LogInActivity.class);
            startActivity(intent);
            finish();
        }

        presenter = new MainPresenter(this);

        txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(firebaseUser.getEmail());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.logOutUser();
    }
}
