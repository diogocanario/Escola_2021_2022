package Model;

public class Book {
    private int ano;
    String autor;
    private int capa;
    private int id;
    String serie;
    String titulo;

    public Book(int id, int ano, int capa, String titulo, String serie, String autor) {
        this.id = id;
        this.ano = ano;
        this.capa = capa;
        this.titulo = titulo;
        this.serie = serie;
        this.autor = autor;
    }

    public int getId() {
        return this.id;
    }

    public int getAno() {
        return this.ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCapa() {
        return this.capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSerie() {
        return this.serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }
}
