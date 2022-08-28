package tarea0;

import java.util.Arrays;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        if (!super.equals(o)) return false;
        Movie movie = (Movie) o;
        return director.equals(movie.director) && guionista.equals(movie.guionista) && Arrays.equals(elenco, movie.elenco);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), director, guionista);
        result = 31 * result + Arrays.hashCode(elenco);
        return result;
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
