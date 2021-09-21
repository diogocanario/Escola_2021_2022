package com.example.books.View;

import Model.Book;
import Model.SingletonBookManager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.books.R;

public class DetalhesDinamico extends AppCompatActivity {
    ImageView imgCapa;
    TextView tvAno;
    TextView tvAutor;
    TextView tvSerie;
    TextView tvTitulo;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhes_dinamico);
        setTitle(R.string.book_details_dinamic);
        this.imgCapa = (ImageView) findViewById(R.id.imageViewCover);
        this.tvTitulo = (TextView) findViewById(R.id.textViewTitulo);
        this.tvSerie = (TextView) findViewById(R.id.textViewSerie);
        this.tvAutor = (TextView) findViewById(R.id.textViewAutor);
        this.tvAno = (TextView) findViewById(R.id.textViewAno);
        setBook((Book) SingletonBookManager.getInstance().getBooks().get(0));
    }

    public void setBook(Book book) {
        this.imgCapa.setImageResource(book.getCapa());
        this.tvTitulo.setText(book.getTitulo());
        this.tvSerie.setText(book.getSerie());
        this.tvAutor.setText(book.getAutor());
        this.tvAno.setText(String.valueOf(book.getAno()));
    }
}
