package com.example.books.View;

import Model.Book;
import Model.SingletonBookManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import androidx.fragment.app.Fragment;
import com.example.books.Adapter.BookListAdapter;
import com.example.books.R;
import java.util.ArrayList;

public class BookListFragment extends Fragment {
    private ArrayList<Book> books;
    ListView listView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_book_list, container, false);
        this.books = SingletonBookManager.getInstance().getBooks();
        ListView listView = (ListView) root.findViewById(R.id.listBooks);
        this.listView = listView;
        listView.setAdapter(new BookListAdapter(getContext(), this.books));
        this.listView.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent i = new Intent(BookListFragment.this.getActivity(), BookDetails.class);
                String str = "BOOK";
                i.putExtra(str, SingletonBookManager.getInstance().getBooks().indexOf((Book) view.getTag()));
                BookListFragment.this.startActivity(i);
            }
        });
        return root;
    }
}
