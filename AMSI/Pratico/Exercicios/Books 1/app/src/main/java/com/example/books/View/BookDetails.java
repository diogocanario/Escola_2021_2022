package com.example.books.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.books.R;

import Model.Book;
import Model.SingletonBookManager;

public class BookDetails extends AppCompatActivity {

    private Object Book;
    private static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        int id = getIntent().getIntExtra("BOOK", 0);
        Book b = SingletonBookManager.getInstance(context).getBooks().get(id);
        setBook(b);
    }

    void setBook(Book book)
    {
        setTitle(book.getTitulo());//settitle ("etalhes" + livro.gettitulu));
        //carregar detalhes livro();
        if (Book != null) {
        EditText title = findViewById(R.id.editTextTitle);
        EditText serie = findViewById(R.id.editTextSerie);
        EditText author = findViewById(R.id.editTextAuthor);
        EditText year = findViewById(R.id.editTextYear);
        
        title.setText(book.getTitulo());
        serie.setText(book.getSerie());
        author.setText(book.getAutor());
        year.setText(String.valueOf(book.getAno()));
        }
    }
}
