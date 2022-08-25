package tarea0;

public class Movie extends CreativeWork {
    private final String director;
    private final String guionista;
    private final String[] elenco;

    public Movie(String titulo, String director, String guionista, String[] elenco, String copyright){
        super(titulo, copyright);
        this.director = director;
        this.guionista = guionista;
        this.elenco = elenco;
    }

    public String getDirector() {
        return director;
    }

    public String getGuionista() {
        return guionista;
    }

    public String[] getElenco() {
        return elenco;
    }
}
