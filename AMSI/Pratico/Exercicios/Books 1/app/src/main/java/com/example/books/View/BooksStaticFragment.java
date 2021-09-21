package com.example.books.View;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.books.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class BooksStaticFragment extends Fragment {


    public BooksStaticFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.book_list_item, container, false);
    }

}
