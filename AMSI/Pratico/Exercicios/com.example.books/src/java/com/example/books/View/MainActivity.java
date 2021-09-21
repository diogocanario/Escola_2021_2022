package com.example.books.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.books.R;

public class MainActivity extends AppCompatActivity {
    String email;
    TextView tvEmail;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvEmail = (TextView) findViewById(R.id.textViewEmail);
        String stringExtra = getIntent().getStringExtra("email");
        this.email = stringExtra;
        this.tvEmail.setText(stringExtra);
    }

    public void onClickStaticDetails(View view) {
        startActivity(new Intent(this, DetalhesEstatico.class));
    }

    public void onClickDinamicDetails(View view) {
        startActivity(new Intent(this, DetalhesDinamico.class));
    }
}
