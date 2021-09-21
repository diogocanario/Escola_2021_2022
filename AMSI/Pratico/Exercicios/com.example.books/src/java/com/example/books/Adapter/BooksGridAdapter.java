package com.example.books.Adapter;

import Model.Book;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.example.books.R;
import java.util.ArrayList;

public class BooksGridAdapter extends BaseAdapter {
    private ArrayList<Book> books;
    private Context context;
    private LayoutInflater inflater;

    public BooksGridAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    public int getCount() {
        return this.books.size();
    }

    public Object getItem(int position) {
        return this.books.get(position);
    }

    public long getItemId(int position) {
        return (long) ((Book) this.books.get(position)).getId();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (this.inflater == null) {
            this.inflater = (LayoutInflater) this.context.getSystemService("layout_inflater");
        }
        if (convertView == null) {
            convertView = this.inflater.inflate(R.layout.book_grid_item, null);
        }
        Book book = (Book) this.books.get(position);
        convertView.setTag(book);
        ((ImageView) convertView.findViewById(R.id.imageViewBookGridCover)).setImageResource(book.getCapa());
        return convertView;
    }
}
