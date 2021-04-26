package com.fti.recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    EditText inputEmail;
    String email;
    Button btnlogin;
    EditText inputPassword;
    String pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        inputEmail = findViewById(R.id.email);
        inputPassword = findViewById(R.id.password);
        btnlogin = findViewById(R.id.btnLogin);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = inputEmail.getText().toString();
                pass = inputPassword.getText().toString();
                if(email.equals("")|| pass.equals("")){
                    Toast.makeText(getApplicationContext(), "Mohon diisi semua datanya", Toast.LENGTH_SHORT).show();
                }else{
                    if (email.equals("admin@gmail.com")){
                        if(pass.equals("admin")){
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }else{
                            Toast.makeText(getApplicationContext(), "Password anda salah", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Email anda salah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}