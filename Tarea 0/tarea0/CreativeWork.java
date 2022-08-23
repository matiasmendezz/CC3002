package tarea0;

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

    public String getCopyright() {
        return copyright;
    }

    public String getTitulo() {
        return titulo;
    }
}
