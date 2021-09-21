package amsi.dei.estg.ipleiria.aula1_android_training;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.BreakIterator;

public class MainActivity extends AppCompatActivity {

    TextView descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final String meetme = getResources().getString(R.string.meet_me);
        final String texto = getResources().getString(R.string.texto);

        final Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                //TextView tv = (TextView) v; //code corrected
                TextView tv= (TextView) findViewById(R.id.descricao);
                tv.setText(texto);
                button.setText(meetme);
            }
        });



    }

}




