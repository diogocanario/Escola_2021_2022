package com.example.books.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.books.R;

public class MainActivity extends AppCompatActivity {

    String email;
    TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvEmail = findViewById(R.id.textViewEmail);

        email = getIntent().getStringExtra("email");
        tvEmail.setText(email);
    }

    public void onClickStaticDetails(View view){
        Intent intent = new Intent(this, DetalhesEstatico.class);
        startActivity(intent);
    }

    public void onClickDinamicDetails(View view){
        Intent intent = new Intent(this, DetalhesDinamico.class);
        startActivity(intent);
    }


}
