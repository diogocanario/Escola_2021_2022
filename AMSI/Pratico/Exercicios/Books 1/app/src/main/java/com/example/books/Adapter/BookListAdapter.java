package com.example.books.Adapter;

import android.content.Context;
import android.os.Debug;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.books.R;

import java.util.ArrayList;

import Model.Book;

public class BookListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private ArrayList<Book> books;

    public BookListAdapter(Context context, ArrayList<Book> books) {
        this.context = context;
        this.books = books;
    }

    @Override
    public int getCount() {
        return books.size();
    }

    @Override
    public Object getItem(int position) {
        return books.get(position);
    }

    @Override
    public long getItemId(int position) {
        return books.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.book_list_item, null);
        }

        Book book = books.get(position);
        convertView.setTag(book);

        updateView(convertView, book);
        return convertView;
    }

    public void updateView(View convertView, Book book){
        TextView titulo = convertView.findViewById(R.id.textViewTitulo);
        TextView serie = convertView.findViewById(R.id.textViewSerie);
        TextView autor = convertView.findViewById(R.id.textViewAutor);
        TextView ano = convertView.findViewById(R.id.textViewAno);
        ImageView img = convertView.findViewById(R.id.imageViewCover);

        titulo.setText(book.getTitulo());
        serie.setText(book.getSerie());
        autor.setText(book.getAutor());
        ano.setText(String.valueOf(book.getAno()));
        img.setImageResource(book.getCapa());
    }

    /*private class ViewHolderList{
        private TextView titulo;
        private TextView serie;
        private TextView autor;
        private TextView ano;
        private ImageView img;

        public ViewHolderList(View convertView) {
            titulo = convertView.findViewById(R.id.textViewTitulo);
            serie = convertView.findViewById(R.id.textViewSerie);
            autor = convertView.findViewById(R.id.textViewAutor);
            ano = convertView.findViewById(R.id.textViewAno);
            img = convertView.findViewById(R.id.imageViewCover);
        }

        public void update(Book book){
            titulo.setText(book.getTitulo());
            serie.setText(book.getSerie());
            autor.setText(book.getAutor());
            ano.setText(String.valueOf(book.getAno()));
            img.setImageResource(book.getCapa());
        }
    }*/
}
