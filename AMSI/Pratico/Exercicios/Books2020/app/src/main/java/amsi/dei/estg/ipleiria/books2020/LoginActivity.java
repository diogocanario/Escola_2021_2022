package amsi.dei.estg.ipleiria.books2020;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;


public class LoginActivity extends AppCompatActivity {

    private EditText editTextEmail;
    private EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //setTitle(getString(R.string));


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
            //editTextPassword.setError(getString(R.string.Password));
            editTextPassword.setError("A password tem de ter 4 ou mais caracteres");
            valid = false;
        }
        if(!valid) return;



        Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
        myIntent.putExtra(MainActivity.EMAIL, "email");
        startActivity(myIntent);
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
        return password.length() >= 4;
    }
}
