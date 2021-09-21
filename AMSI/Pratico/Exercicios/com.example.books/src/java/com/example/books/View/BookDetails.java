package com.example.books.View;

import Model.Book;
import Model.SingletonBookManager;
import android.os.Bundle;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.example.books.R;

public class BookDetails extends AppCompatActivity {
    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_details);
        setBook((Book) SingletonBookManager.getInstance().getBooks().get(getIntent().getIntExtra("BOOK", 0)));
    }

    /* Access modifiers changed, original: 0000 */
    public void setBook(Book book) {
        setTitle(book.getTitulo());
        EditText serie = (EditText) findViewById(R.id.editTextSerie);
        EditText author = (EditText) findViewById(R.id.editTextAuthor);
        EditText year = (EditText) findViewById(R.id.editTextYear);
        ((EditText) findViewById(R.id.editTextTitle)).setText(book.getTitulo());
        serie.setText(book.getSerie());
        author.setText(book.getAutor());
        year.setText(String.valueOf(book.getAno()));
    }
}
