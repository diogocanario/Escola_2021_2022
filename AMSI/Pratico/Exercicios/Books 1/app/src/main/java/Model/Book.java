package Model;

public class Book {
    private int id, ano, capa;
    String titulo, serie, autor;

    public Book(int id, int ano, int capa, String titulo, String serie, String autor) {
        this.id = id;
        this.ano = ano;
        this.capa = capa;
        this.titulo = titulo;
        this.serie = serie;
        this.autor = autor;
    }

    public int getId() {
        return id;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCapa() {
        return capa;
    }

    public void setCapa(int capa) {
        this.capa = capa;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public void setID(int id) {
        this.id= id;
    }
}
