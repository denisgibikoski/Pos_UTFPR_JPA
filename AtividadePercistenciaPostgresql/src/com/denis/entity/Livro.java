package com.denis.entity;

public class Livro {

    private Long ISBN;
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private String editora;
    private String urlImagemPequena;
    private String urlImagemMedia;
    private String urlImagemGrande;

    public Livro(Long ISBN, String titulo, String autor, int anoPublicacao, String editora, String urlImagemPequena, String urlImagemMedia, String urlImagemGrande) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.editora = editora;
        this.urlImagemPequena = urlImagemPequena;
        this.urlImagemMedia = urlImagemMedia;
        this.urlImagemGrande = urlImagemGrande;
    }

    public String getUrlImagemGrande() {
        return urlImagemGrande;
    }

    public void setUrlImagemGrande(String urlImagemGrande) {
        this.urlImagemGrande = urlImagemGrande;
    }

    public Long getISBN() {
        return ISBN;
    }

    public void setISBN(Long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getUrlImagemPequena() {
        return urlImagemPequena;
    }

    public void setUrlImagemPequena(String urlImagemPequena) {
        this.urlImagemPequena = urlImagemPequena;
    }

    public String getUrlImagemMedia() {
        return urlImagemMedia;
    }

    public void setUrlImagemMedia(String urlImagemMedia) {
        this.urlImagemMedia = urlImagemMedia;
    }

    @Override
    public String toString() {
        return "Livro{" + "ISBN=" + ISBN + ", titulo=" + titulo + ", autor=" + autor + ", anoPublicacao=" + anoPublicacao + ", editora=" + editora + ", urlImagemPequena=" + urlImagemPequena + ", urlImagemMedia=" + urlImagemMedia + ", urlImagemGrande=" + urlImagemGrande + '}';
    }

}
