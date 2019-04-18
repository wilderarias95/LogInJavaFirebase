package com.fracessoftware.loginjavafirebase.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.fracessoftware.loginjavafirebase.main.MainActivity;
import com.fracessoftware.loginjavafirebase.R;


public class LogInActivity extends AppCompatActivity implements ILogInMVP.View{

    ILogInMVP.PresenterView presenter;
    EditText edtEmail, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        presenter = new LogInPresenter(this);

        if (presenter.isUserLoged()){
            goToMainActivity();
        }
        Button btnLogIn = findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickedLogIn();
            }
        });

        edtEmail=findViewById(R.id.edtEmail);
        edtPassword = findViewById(R.id.edtPassword);


    }


    @Override
    public String getEmail() {
        return edtEmail.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPassword.getText().toString();
    }

    @Override
    public void errorEmail() {
        Toast.makeText(this, "Debe ingresar un correo", Toast.LENGTH_LONG).show();
    }

    @Override
    public void errorPassword() {
        Toast.makeText(this, "Debe ingresar una contraseña", Toast.LENGTH_LONG).show();
    }

    @Override
    public void goToMainActivity() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void errorLogInFailed() {
        Toast.makeText(this, "No fue posible ingresar", Toast.LENGTH_LONG).show();
    }
}
