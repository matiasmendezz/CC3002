package tarea0;


import java.util.Objects;


public class CreativeWork {
    private final String titulo;
    private final String copyright;

    public CreativeWork(String titulo, String copyright){
        this.titulo = titulo;
        this.copyright = copyright;
    }


    public CreativeWork(String titulo){
        this.titulo = titulo;
        this.copyright = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CreativeWork that)) return false;
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


    public String getCopyright() {
        return copyright;
    }

    public String getTitulo() {
        return titulo;
    }
}
