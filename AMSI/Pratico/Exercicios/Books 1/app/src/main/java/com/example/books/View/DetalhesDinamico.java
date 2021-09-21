package com.example.books.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Context;

import com.example.books.R;

import java.util.ArrayList;

import Model.Book;
import Model.SingletonBookManager;

public class DetalhesDinamico extends AppCompatActivity {

    ImageView imgCapa;
    TextView tvTitulo, tvSerie, tvAutor, tvAno;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_dinamico);
        setTitle(R.string.book_details_dinamic);

        imgCapa = findViewById(R.id.imageViewCover);
        tvTitulo = findViewById(R.id.textViewTitulo);
        tvSerie = findViewById(R.id.textViewSerie);
        tvAutor = findViewById(R.id.textViewAutor);
        tvAno = findViewById(R.id.textViewAno);

        ArrayList<Book> books = SingletonBookManager.getInstance(context).getBooks();
        Book b = books.get(0);
        setBook(b);
    }

    public void setBook(Book book){
        imgCapa.setImageResource(book.getCapa());
        tvTitulo.setText(book.getTitulo());
        tvSerie.setText(book.getSerie());
        tvAutor.setText(book.getAutor());
        tvAno.setText(String.valueOf(book.getAno()));
    }
}
