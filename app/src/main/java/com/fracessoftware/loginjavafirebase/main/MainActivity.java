package com.fracessoftware.loginjavafirebase.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.fracessoftware.loginjavafirebase.R;
import com.fracessoftware.loginjavafirebase.login.LogInActivity;

public class MainActivity extends AppCompatActivity implements IMainMVP.View{

    TextView txtEmail, txtReadRT;
    EditText edtChild;
    IMainMVP.PresenterView presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new MainPresenter(this);

        if (!presenter.isUserLoged()){
            Intent intent= new Intent(this, LogInActivity.class);
            startActivity(intent);
            finish();
        }

        txtEmail = findViewById(R.id.txtEmail);
        txtEmail.setText(presenter.sendUserEmail());

        Button btnWrite = findViewById(R.id.btnWriteRT);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickedWriteRT();
            }
        });

        txtReadRT= findViewById(R.id.txtReadRT);

        edtChild = findViewById(R.id.edtChild);

        Button btnUpdate = findViewById(R.id.btnUpdateRT);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickedUpdateChild(edtChild.getText().toString());
            }
        });

        Button btnRemove = findViewById(R.id.btnRemoveRT);
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.clickedRemoveChild(edtChild.getText().toString());
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.logOutUser();
    }


    @Override
    public void messageWriteSuccessful() {
        Toast.makeText(this, "Write successful", Toast.LENGTH_LONG).show();
    }

    @Override
    public void updateData(String value){
        txtReadRT.setText(value);
    }

    @Override
    public void messageReadFailed() {
        Toast.makeText(this, "Read Failed", Toast.LENGTH_LONG).show();
    }
}
