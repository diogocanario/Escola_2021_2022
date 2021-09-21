package com.example.books;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.books.View.BookListFragment;
import com.example.books.View.BooksDinamicFragment;
import com.example.books.View.BooksGridFragment;
import com.example.books.View.BooksStaticFragment;
import com.google.android.material.navigation.NavigationView;


public class MenuMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FragmentManager fm;
    NavigationView nv;
    DrawerLayout dl;

    private static final String USER = "USER";
    //public static final String EMAIL2 = "EMAIL2";
    public static final String EMAIL = "EMAIL";

    //String email= "";
    private String email ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);



        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fm = getSupportFragmentManager();
        nv = findViewById(R.id.navView);
        dl = findViewById(R.id.drawer_layout);

        nv.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, dl, toolbar, R.string.ndOpen,R.string.ndClose);
        toggle.syncState();

        dl.addDrawerListener(toggle);

        setTitle("lista de livros");

        fm.beginTransaction().replace(R.id.contentFragment, new BooksStaticFragment()).commit();

        loadHeader();
    }


    //se nao existir um email, carregar shared
    //caso exista apresenta o que recebeu e guarda na sahed

    void loadHeader(){

        email = getIntent().getStringExtra("email");
        System.out.println("--> email:" +email);
        // LER ficheiro shared USER
        SharedPreferences sharedPrefUser=getSharedPreferences(USER, Context.MODE_PRIVATE);

        if (email == null)
        {
            //ler string

            //carregar idiomas em string(i think)
            email = sharedPrefUser.getString(EMAIL, "Sem email");
        }
        else
        {
            //editar string
            SharedPreferences.Editor editor = sharedPrefUser.edit();
            editor.putString(EMAIL, email);
            editor.apply();

        }

        View v = nv.getHeaderView(0);
        TextView tv = v.findViewById(R.id.textViewHeaderEmail);
        tv.setText(email);

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

        Fragment frag = null;
        switch (menuItem.getItemId()) {
            case R.id.nav_estatico:
                frag = new BookListFragment();
                setTitle(R.string.book_list);
                break;

            case R.id.nav_dinamico:
                frag = new BooksGridFragment();
                setTitle(R.string.book_details_dinamic);

                break;

            //case R.id.email:
            //    break;

            default:
                System.out.println("-->Nav Default");
        }

        if (frag != null)
            fm.beginTransaction().replace(R.id.contentFragment, frag).commit();
        dl.closeDrawer(GravityCompat.START);
        return true;
    }
}
