package com.example.books.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;

import com.example.books.MenuMainActivity;
import com.example.books.R;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
    }

    public void onClickLogin(View view) {
        String email = editTextEmail.getText().toString();
        String password = editTextPassword.getText().toString();
        boolean valid = true;
        if(!isEmailValid(email)){
            editTextEmail.setError("Introduza um e-mail válido");
            valid = false;
        }
        if(!isPasswordValid(password)){
            editTextPassword.setError("A password tem de ter mais de 7 caracteres");
            valid = false;
        }
        if(!valid) return;

        Intent intent = new Intent(this, MenuMainActivity.class);
        intent.putExtra("email", email);
        startActivity(intent);
        finish();

    }

    public boolean isEmailValid(String email){
        if(email == null || email.isEmpty())
            return false;
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isPasswordValid(String password){
        if(password == null || password.isEmpty())
            return false;
        return password.length() > 7;
    }
}
