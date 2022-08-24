package tarea0;

import tarea0.CreativeWork;

public class LiteraryWork extends CreativeWork {
     private final String publisher;

     public LiteraryWork(String titulo, String publisher, String copyright){
         super(titulo, copyright);
         this.publisher = publisher;
     }

    public String getPublisher() {
        return publisher;
    }
}
