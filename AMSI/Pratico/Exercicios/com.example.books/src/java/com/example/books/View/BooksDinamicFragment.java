package com.example.books.View;

import Model.Book;
import Model.SingletonBookManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.example.books.R;

public class BooksDinamicFragment extends Fragment {
    ImageView imgCapa;
    TextView tvAno;
    TextView tvAutor;
    TextView tvSerie;
    TextView tvTitulo;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_books_dinamic, container, false);
        this.imgCapa = (ImageView) root.findViewById(R.id.imageViewCover);
        this.tvTitulo = (TextView) root.findViewById(R.id.textViewTitulo);
        this.tvSerie = (TextView) root.findViewById(R.id.textViewSerie);
        this.tvAutor = (TextView) root.findViewById(R.id.textViewAutor);
        this.tvAno = (TextView) root.findViewById(R.id.textViewAno);
        setBook((Book) SingletonBookManager.getInstance().getBooks().get(0));
        return root;
    }

    public void setBook(Book book) {
        this.imgCapa.setImageResource(book.getCapa());
        this.tvTitulo.setText(book.getTitulo());
        this.tvSerie.setText(book.getSerie());
        this.tvAutor.setText(book.getAutor());
        this.tvAno.setText(String.valueOf(book.getAno()));
    }
}
