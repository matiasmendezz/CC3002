package tarea0;

public class Novel extends LiteraryWork{
    private final String autor;

    public Novel(String titulo, String publisher, String autor, String copyright) {
        super(titulo, publisher, copyright);
        this.autor = autor;
    }

    public String getAutor() {
        return autor;
    }
}
