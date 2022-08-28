package tarea0;

import java.util.Objects;

public class LiteraryWork extends CreativeWork {
     private final String publisher;

     public LiteraryWork(String titulo, String publisher, String copyright){
         super(titulo, copyright);
         this.publisher = publisher;
     }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LiteraryWork)) return false;
        if (!super.equals(o)) return false;
        LiteraryWork that = (LiteraryWork) o;
        return publisher.equals(that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), publisher);
    }

    public String getPublisher() {
        return publisher;
    }
}
