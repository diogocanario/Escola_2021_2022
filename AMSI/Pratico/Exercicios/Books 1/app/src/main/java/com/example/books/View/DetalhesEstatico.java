package com.example.books.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.books.R;

import Model.Book;

public class DetalhesEstatico extends AppCompatActivity {

    ImageView imgCapa;
    TextView tvTitulo, tvSerie, tvAutor, tvAno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_estatico);
        setTitle(R.string.book_details_static);

        imgCapa = findViewById(R.id.imageViewCover);
        tvTitulo = findViewById(R.id.textViewTitulo);
        tvSerie = findViewById(R.id.textViewSerie);
        tvAutor = findViewById(R.id.textViewAutor);
        tvAno = findViewById(R.id.textViewAno);
    }

    public void setBook(Book book){
        imgCapa.setImageResource(book.getCapa());
        tvTitulo.setText(book.getTitulo());
        tvSerie.setText(book.getSerie());
        tvAutor.setText(book.getAutor());
        tvAno.setText(book.getAno());
    }
}
