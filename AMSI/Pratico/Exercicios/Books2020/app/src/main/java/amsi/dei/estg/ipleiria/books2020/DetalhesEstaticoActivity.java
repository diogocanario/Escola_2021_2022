package amsi.dei.estg.ipleiria.books2020;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetalhesEstaticoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_estatico);
        setTitle(getString(R.string.actEstatica));
    }
}