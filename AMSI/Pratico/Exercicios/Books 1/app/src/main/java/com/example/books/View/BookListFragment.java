package com.example.books.View;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.books.Adapter.BookListAdapter;
import com.example.books.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

import Model.Book;
import Model.SingletonBookManager;

public class BookListFragment extends Fragment {

    private ArrayList<Book> books;
    ListView listView;
    private SearchView searchView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_list, container, false);
        setHasOptionsMenu(true);

        books = SingletonBookManager.getInstance(getContext()).getBooks();
        listView = view.findViewById(R.id.listBooks);
        listView.setAdapter(new BookListAdapter(getContext(), books));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getActivity(), BookDetails.class);
                Book b = (Book)view.getTag();
                i.putExtra("BOOK", SingletonBookManager.getInstance(getContext()).getBooks().indexOf(b));
                startActivity(i);
            }
        });

        FloatingActionButton FAB = view.findViewById(R.id.FAB);

        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //se tiver num fragmento = get context
                //se tiver numa activity = this
                //intent primeiro parametro de onde > para onde
                Intent intent = new Intent(getContext(),BookDetails.class);
                startActivity(intent);
            }
        });

        return view;
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.menu_pesquisa,menu);

        MenuItem itemPesquisa= menu.findItem(R.id.itemPesquisa);
        searchView = (SearchView) itemPesquisa.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<Book> tempLivros = new ArrayList<>();
                for (Book b:SingletonBookManager.getInstance(getContext()).getBooks())
                    if(b.getTitulo().toLowerCase().contains(newText.toLowerCase()))
                        tempLivros.add(b);
                    listView.setAdapter(new BookListAdapter(getContext(),tempLivros));

                return false;
            }
        });

        super.onCreateOptionsMenu(menu, inflater);
    }
    
}
