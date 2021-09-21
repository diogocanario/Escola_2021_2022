package Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class LivroBDHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "livrosBD";
    private static final Integer DB_VERSION = 1;

    private static final String TABLE_LIVROS = "Livros";
    private static final String ID_LIVROS = "id";
    private static final String TITULO_LIVROS = "titulo";
    private static final String SERIE_LIVROS = "serie";
    private static final String AUTOR_LIVROS = "autor";
    private static final String ANO_LIVROS = "ano";
    private static final String CAPA_LIVROS = "capa";

    private final SQLiteDatabase db;


    public LivroBDHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sqlCreateTableTLivro = "Create Table " + TABLE_LIVROS + " (" +
                ID_LIVROS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                TITULO_LIVROS + " TEXT NOT NULL, " +
                SERIE_LIVROS + " TEXT NOT NULL, " +
                AUTOR_LIVROS + " TEXT NOT NULL, " +
                ANO_LIVROS + " INTEGER NOT NULL, " +
                CAPA_LIVROS + " INTEGER);";

        db.execSQL(sqlCreateTableTLivro);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sqlDropTableLivros = "DROP TABLE IF EXISTS " + TABLE_LIVROS;
        db.execSQL(sqlDropTableLivros);
        this.onCreate(db);
    }


    /***        METODOS CRUD        ***/

    /**
     * INSERT
     * o metodo insert > return idlivro long se houve erro devolve -1
     *
     * @param Book
     * @return
     */

    public Book adicionarLivroBD(Book Book) {
        ContentValues values = new ContentValues();
        values.put(TITULO_LIVROS, Book.getTitulo());
        values.put(SERIE_LIVROS, Book.getSerie());
        values.put(AUTOR_LIVROS, Book.getAutor());
        values.put(ANO_LIVROS, Book.getAno());
        values.put(CAPA_LIVROS, Book.getCapa());

        long id = this.db.insert(TABLE_LIVROS, null, values);

        if (id > -1) {
            Book.setID((int) id);
            return Book;
        }

        return null;

    }


    /**
     * UPDATE
     * o metodo update> return o numero de linhas alteradas
     *
     * @param Book
     * @return
     */
    public boolean editarLivroBD(Book Book) {

        ContentValues values = new ContentValues();
        values.put(TITULO_LIVROS, Book.getTitulo());
        values.put(SERIE_LIVROS, Book.getSerie());
        values.put(AUTOR_LIVROS, Book.getAutor());
        values.put(ANO_LIVROS, Book.getAno());
        values.put(CAPA_LIVROS, Book.getCapa());

        return this.db.update(TABLE_LIVROS, values, "id=?" /*AND titulo LIKE=?"*/, new String[]{Book.getId() + ""}) > 0;

    }

    /**
     * REMOVER
     *
     * @param id
     * @return
     */
    public boolean removerLivroBD(int id) {

        return this.db.delete(TABLE_LIVROS, "id=?" /*AND titulo LIKE=?"*/, new String[]{id + ""}) > 0;
    }


    /**
     * SELECT
     * this.db.rawQuery("codigo sql"), null) > suscetivel de sqlinjection
     *
     * @return
     */
    public ArrayList<Book> getAllLivrosBD() {

        ArrayList<Book> livros = new ArrayList<>();

        Cursor cursor = this.db.query(TABLE_LIVROS, new String[]{ID_LIVROS, ANO_LIVROS, CAPA_LIVROS, TITULO_LIVROS, SERIE_LIVROS, AUTOR_LIVROS}, null, null, null, null, null);

        if(cursor.moveToFirst()){
            do{
                Book auxLivro = new Book (cursor.getInt(0),cursor.getInt(1),
                        cursor.getInt(2),cursor.getString(3),
                        cursor.getString(4),cursor.getString(5));
                livros.add(auxLivro);

            }while(cursor.moveToNext());
        }
        return livros;
    }

}
