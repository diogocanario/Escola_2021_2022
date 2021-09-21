package com.example.books.Adapter;

import Model.Book;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.books.R;
import java.util.ArrayList;

public class BookListAdapter extends BaseAdapter {
    private ArrayList<Book> books;
    private Context context;
    private LayoutInflater inflater;

    public BookListAdapter(Context context, ArrayList<Book> books) {
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
            convertView = this.inflater.inflate(R.layout.book_list_item, null);
        }
        Book book = (Book) this.books.get(position);
        convertView.setTag(book);
        updateView(convertView, book);
        return convertView;
    }

    public void updateView(View convertView, Book book) {
        TextView serie = (TextView) convertView.findViewById(R.id.textViewSerie);
        TextView autor = (TextView) convertView.findViewById(R.id.textViewAutor);
        TextView ano = (TextView) convertView.findViewById(R.id.textViewAno);
        ImageView img = (ImageView) convertView.findViewById(R.id.imageViewCover);
        ((TextView) convertView.findViewById(R.id.textViewTitulo)).setText(book.getTitulo());
        serie.setText(book.getSerie());
        autor.setText(book.getAutor());
        ano.setText(String.valueOf(book.getAno()));
        img.setImageResource(book.getCapa());
    }
}
