package tarea0;

import java.util.Arrays;
import java.util.Objects;

public class Comic extends LiteraryWork{
    private final String escritor;
    private final String[] dibujo;

    public Comic(String titulo, String publisher, String escritor, String[] dibujo, String copyright){
        super(titulo, publisher, copyright);
        this.escritor = escritor;
        this.dibujo = dibujo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Comic)) return false;
        if (!super.equals(o)) return false;
        Comic comic = (Comic) o;
        return escritor.equals(comic.escritor) && Arrays.equals(dibujo, comic.dibujo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(super.hashCode(), escritor);
        result = 31 * result + Arrays.hashCode(dibujo);
        return result;
    }

    public String getEscritor() {
        return escritor;
    }

    public String[] getDibujo() {
        return dibujo;
    }
}
