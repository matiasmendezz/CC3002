package tarea0;

public class Comic extends LiteraryWork{
    private final String escritor;
    private final String[] dibujo;

    public Comic(String titulo, String publisher, String escritor, String[] dibujo, String copyright){
        super(titulo, publisher, copyright);
        this.escritor = escritor;
        this.dibujo = dibujo;
    }

    public String getEscritor() {
        return escritor;
    }

    public String[] getDibujo() {
        return dibujo;
    }
}
