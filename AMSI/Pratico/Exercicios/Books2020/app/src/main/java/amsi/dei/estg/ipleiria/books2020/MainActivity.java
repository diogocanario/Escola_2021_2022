package amsi.dei.estg.ipleiria.books2020;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

//import com.example.books.R;

public class MainActivity extends AppCompatActivity {

    public static final String EMAIL ="email";
    private String email="";
    private TextView textViewEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //buscar o email que vinha no intent
        email = getIntent().getStringExtra(EMAIL).toString();
        textViewEmail = findViewById(R.id.textViewEmail);
        textViewEmail.setText(email);
    }

    public void onClickStaticDetails(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.buttonDetalhesEstatico:
                 intent = new Intent(this, DetalhesEstaticoActivity.class);
                startActivity(intent);

            case R.id.buttonDetalhesDinamico:
                intent = new Intent(this, DetalhesDinamicoActivity.class);
                startActivity(intent);

            case R.id.buttonEnviarEmail:
                //todo
                //ver ppt teorico
                break;
            default:
                return;
        }



    }

    public void onClickDinamicDetails(View view){
        Intent intent = new Intent(this, DetalhesDinamicoActivity.class);
        startActivity(intent);
    }
}
