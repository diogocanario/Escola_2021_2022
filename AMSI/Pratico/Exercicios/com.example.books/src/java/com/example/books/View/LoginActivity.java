package com.example.books.View;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.books.R;

public class LoginActivity extends AppCompatActivity {
    EditText editTextEmail;
    EditText editTextPassword;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        this.editTextPassword = (EditText) findViewById(R.id.editTextPassword);
    }

    public void onClickLogin(View view) {
        String email = this.editTextEmail.getText().toString();
        String password = this.editTextPassword.getText().toString();
        boolean valid = true;
        if (!isEmailValid(email)) {
            this.editTextEmail.setError("Introduza um e-mail válido");
            valid = false;
        }
        if (!isPasswordValid(password)) {
            this.editTextPassword.setError("A password tem de ter mais de 7 caracteres");
            valid = false;
        }
        if (valid) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.putExtra("email", email);
            startActivity(intent);
            finish();
        }
    }

    public boolean isEmailValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        return Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public boolean isPasswordValid(String password) {
        boolean z = false;
        if (password == null || password.isEmpty()) {
            return false;
        }
        if (password.length() > 7) {
            z = true;
        }
        return z;
    }
}
