package com.example.books.View;

import Model.Book;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.books.R;

public class DetalhesEstatico extends AppCompatActivity {
    ImageView imgCapa;
    TextView tvAno;
    TextView tvAutor;
    TextView tvSerie;
    TextView tvTitulo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_estatico);
        setTitle(R.string.book_details_static);
        this.imgCapa = (ImageView) findViewById(R.id.imageViewCover);
        this.tvTitulo = (TextView) findViewById(R.id.textViewTitulo);
        this.tvSerie = (TextView) findViewById(R.id.textViewSerie);
        this.tvAutor = (TextView) findViewById(R.id.textViewAutor);
        this.tvAno = (TextView) findViewById(R.id.textViewAno);
    }

    public void setBook(Book book) {
        this.imgCapa.setImageResource(book.getCapa());
        this.tvTitulo.setText(book.getTitulo());
        this.tvSerie.setText(book.getSerie());
        this.tvAutor.setText(book.getAutor());
        this.tvAno.setText(book.getAno());
    }
}
