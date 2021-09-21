package com.example.books.View;

import Model.Book;
import Model.SingletonBookManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import com.example.books.Adapter.BooksGridAdapter;
import com.example.books.R;
import java.util.ArrayList;

public class BooksGridFragment extends Fragment {
    ArrayList<Book> books;
    GridView gridView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_books_grid, container, false);
        this.books = SingletonBookManager.getInstance().getBooks();
        GridView gridView = (GridView) v.findViewById(R.id.gridBooks);
        this.gridView = gridView;
        gridView.setAdapter(new BooksGridAdapter(getContext(), this.books));
        return v;
    }
}
