package com.iteqno.mvvmexample.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.iteqno.mvvmexample.R;
import com.iteqno.mvvmexample.viewmodel.UserViewModel;

public class MainActivity extends AppCompatActivity {

    private EditText inputEmail, inputPassword;
    private Button btnLogin;
    private UserViewModel userViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEmail = findViewById(R.id.eEmail);
        inputPassword = findViewById(R.id.ePassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userViewModel.updateModel(inputEmail.getText().toString(), inputPassword.getText().toString());
                userViewModel.validLogin();
            }
        });
    }
}
