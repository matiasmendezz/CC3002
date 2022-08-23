package tarea0;

<<<<<<< HEAD
import java.util.Objects;

=======
>>>>>>> 6875e26b4714e5c3d88aaf5fca6b44572ad27530
public class CreativeWork {
    private final String titulo;
    private final String copyright;

    public CreativeWork(String titulo, String copyright){
        this.titulo = titulo;
        this.copyright = copyright;
    }

<<<<<<< HEAD
    public CreativeWork(String titulo){
        this.titulo = titulo;
        this.copyright = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreativeWork)) return false;
        CreativeWork that = (CreativeWork) o;
        return titulo.equals(that.titulo) && Objects.equals(copyright, that.copyright);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, copyright);
    }

    @Override
    public String toString() {
        return "CreativeWork{" +
                "titulo='" + titulo + '\'' +
                ", copyright='" + copyright + '\'' +
                '}';
    }

=======
>>>>>>> 6875e26b4714e5c3d88aaf5fca6b44572ad27530
    public String getCopyright() {
        return copyright;
    }

    public String getTitulo() {
        return titulo;
    }
}
