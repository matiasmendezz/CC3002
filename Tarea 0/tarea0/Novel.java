package tarea0;

import java.util.Objects;

public class Novel extends LiteraryWork{
    private final String autor;

    public Novel(String titulo, String publisher, String autor, String copyright) {
        super(titulo, publisher, copyright);
        this.autor = autor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Novel)) return false;
        if (!super.equals(o)) return false;
        Novel novel = (Novel) o;
        return autor.equals(novel.autor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), autor);
    }

    public String getAutor() {
        return autor;
    }
}
