package com.example.books.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.books.R;

import java.util.ArrayList;

import Model.Book;
import Model.SingletonBookManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksDinamicFragment extends Fragment {

    ImageView imgCapa;
    TextView tvTitulo, tvSerie, tvAutor, tvAno;

    public BooksDinamicFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_books_dinamic, container, false);

        imgCapa = root.findViewById(R.id.imageViewCover);
        tvTitulo = root.findViewById(R.id.textViewTitulo);
        tvSerie = root.findViewById(R.id.textViewSerie);
        tvAutor = root.findViewById(R.id.textViewAutor);
        tvAno = root.findViewById(R.id.textViewAno);

        ArrayList<Book> books = SingletonBookManager.getInstance(getContext()).getBooks();
        Book b = books.get(0);
        setBook(b);

        return root;
    }

    public void setBook(Book book){
        imgCapa.setImageResource(book.getCapa());
        tvTitulo.setText(book.getTitulo());
        tvSerie.setText(book.getSerie());
        tvAutor.setText(book.getAutor());
        tvAno.setText(String.valueOf(book.getAno()));
    }
}
