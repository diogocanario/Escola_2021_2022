package Model;

import android.content.Context;

import java.util.ArrayList;

public class SingletonBookManager {
    private static Context context;

    private static SingletonBookManager INSTANCE = new SingletonBookManager(context);

    private ArrayList<Book> books = new ArrayList<>();

    private LivroBDHelper livrosBD=null;

    public static synchronized SingletonBookManager getInstance(Context context) {

        if (INSTANCE ==null)
            INSTANCE = new SingletonBookManager(context);

        return INSTANCE;

    }

    private SingletonBookManager(Context context)

    {
        //generateFakeData();
        books = new ArrayList<>();
        livrosBD= new LivroBDHelper(context);
    }

    public ArrayList<Book> getBooks() {

        return books;
    }






    /*private void generateFakeData(){
        books.add(new Book(1, 2019, R.drawable.programarandroid1, "Teste 1", "Teste 1", "Teste 1"));
        books.add(new Book(2, 2000, R.drawable.programarandroid2, "Teste 2", "Teste 2", "Teste 2"));
        books.add(new Book(3, 2001, R.drawable.programarandroid1, "Teste 3", "Teste 3", "Teste 3"));
        books.add(new Book(4, 2002, R.drawable.programarandroid2, "Teste 4", "Teste 4", "Teste 4"));
        books.add(new Book(5, 2003, R.drawable.programarandroid1, "Teste 5", "Teste 5", "Teste 5"));
        books.add(new Book(6, 2004, R.drawable.programarandroid2, "Teste 6", "Teste 6", "Teste 6"));
        books.add(new Book(7, 2005, R.drawable.programarandroid1, "Teste 7", "Teste 7", "Teste 7"));
        books.add(new Book(8, 2006, R.drawable.programarandroid2, "Teste 8", "Teste 8", "Teste 8"));
        books.add(new Book(9, 2007, R.drawable.programarandroid1, "Teste 9", "Teste 9", "Teste 9"));
        books.add(new Book(10, 2008, R.drawable.programarandroid2, "Teste 10", "Teste 10", "Teste 10"));
    }*/
}
