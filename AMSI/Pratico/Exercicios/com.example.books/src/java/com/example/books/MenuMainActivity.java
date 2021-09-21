package com.example.books;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.example.books.View.BookListFragment;
import com.example.books.View.BooksGridFragment;
import com.example.books.View.BooksStaticFragment;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener;
import java.io.PrintStream;

public class MenuMainActivity extends AppCompatActivity implements OnNavigationItemSelectedListener {
    DrawerLayout dl;
    String email;
    FragmentManager fm;
    NavigationView nv;

    /* Access modifiers changed, original: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        this.fm = getSupportFragmentManager();
        this.nv = (NavigationView) findViewById(R.id.navView);
        this.dl = (DrawerLayout) findViewById(R.id.drawer);
        this.nv.setNavigationItemSelectedListener(this);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, this.dl, toolbar, R.string.app_name, R.string.app_name);
        toggle.syncState();
        this.dl.addDrawerListener(toggle);
        setTitle(R.string.book_details_static);
        this.fm.beginTransaction().replace(R.id.contentFragment, new BooksStaticFragment()).commit();
        loadHeader();
    }

    /* Access modifiers changed, original: 0000 */
    public void loadHeader() {
        this.email = getIntent().getStringExtra("email");
        PrintStream printStream = System.out;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("--> email:");
        stringBuilder.append(this.email);
        printStream.println(stringBuilder.toString());
        ((TextView) this.nv.getHeaderView(0).findViewById(R.id.textViewHeaderEmail)).setText(this.email);
    }

    public boolean onNavigationItemSelected(MenuItem menuItem) {
        Fragment frag = null;
        switch (menuItem.getItemId()) {
            case R.id.menuItemBookDinamic /*2131230873*/:
                setTitle(R.string.book_details_dinamic);
                frag = new BooksGridFragment();
                break;
            case R.id.menuItemBookStatic /*2131230874*/:
                setTitle(R.string.book_list);
                frag = new BookListFragment();
                break;
            default:
                System.out.println("-->Nav Default");
                break;
        }
        this.fm.beginTransaction().replace(R.id.contentFragment, frag).commit();
        this.dl.closeDrawer(8388611);
        return true;
    }
}
