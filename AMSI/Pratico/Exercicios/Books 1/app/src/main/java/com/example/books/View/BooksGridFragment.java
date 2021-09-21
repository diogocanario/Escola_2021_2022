package com.example.books.View;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.GridView;

import com.example.books.Adapter.BookListAdapter;
import com.example.books.Adapter.BooksGridAdapter;
import com.example.books.R;

import java.util.ArrayList;

import Model.Book;
import Model.SingletonBookManager;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksGridFragment extends Fragment {

    GridView gridView;
    ArrayList<Book> books;

    @Override
    /*public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_books_grid, container, false);

        books = SingletonBookManager.getInstance().getBooks();
        gridView = v.findViewById(R.id.gridBooks);
        gridView.setAdapter(new BooksGridAdapter(getContext(), books));

        return v;
    }*/
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_books_grid, container, false);
        books = SingletonBookManager.getInstance(getContext()).getBooks();
        gridView = root.findViewById(R.id.gridBooks);
        gridView.setAdapter(new BooksGridAdapter(getContext(), books));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), BookDetails.class);
                Book b = (Book)view.getTag();
                i.putExtra("BOOK", SingletonBookManager.getInstance(getContext()).getBooks().indexOf(b));
                startActivity(i);
            }
        });

        return root;
    }

}
