package Model;

import com.example.books.R;
import java.util.ArrayList;

public class SingletonBookManager {
    private static final SingletonBookManager INSTANCE = new SingletonBookManager();
    private ArrayList<Book> books = new ArrayList();

    public static synchronized SingletonBookManager getInstance() {
        SingletonBookManager singletonBookManager;
        synchronized (SingletonBookManager.class) {
            singletonBookManager = INSTANCE;
        }
        return singletonBookManager;
    }

    private SingletonBookManager() {
        generateFakeData();
    }

    public ArrayList<Book> getBooks() {
        return this.books;
    }

    private void generateFakeData() {
        this.books.add(new Book(1, 2019, R.drawable.programarandroid1, "Teste", "Teste", "Teste"));
        this.books.add(new Book(2, 2000, R.drawable.programarandroid2, "Teste 2", "Teste 2", "Teste 2"));
        this.books.add(new Book(3, 2001, R.drawable.programarandroid1, "Teste 3", "Teste 3", "Teste 3"));
        this.books.add(new Book(4, 2002, R.drawable.programarandroid2, "Teste 4", "Teste 4", "Teste 4"));
        this.books.add(new Book(5, 2003, R.drawable.programarandroid1, "Teste 5", "Teste 5", "Teste 5"));
        this.books.add(new Book(6, 2004, R.drawable.programarandroid2, "Teste 6", "Teste 6", "Teste 6"));
        this.books.add(new Book(7, 2005, R.drawable.programarandroid1, "Teste 7", "Teste 7", "Teste 7"));
        this.books.add(new Book(8, 2006, R.drawable.programarandroid2, "Teste 8", "Teste 8", "Teste 8"));
        this.books.add(new Book(9, 2007, R.drawable.programarandroid1, "Teste 9", "Teste 9", "Teste 9"));
        this.books.add(new Book(10, 2008, R.drawable.programarandroid2, "Teste 10", "Teste 10", "Teste 10"));
    }
}
