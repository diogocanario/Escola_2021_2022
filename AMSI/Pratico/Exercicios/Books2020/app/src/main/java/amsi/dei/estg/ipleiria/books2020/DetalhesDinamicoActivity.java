package amsi.dei.estg.ipleiria.books2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetalhesDinamicoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_dinamico);
        setTitle(getString(R.string.actDinamico));
    }
}