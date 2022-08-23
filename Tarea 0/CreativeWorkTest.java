import tarea0.CreativeWork;


class CreativeWorkTest {
    public static void main(String[] args){
        CreativeWork HP = new CreativeWork("Harry Potter", "Warner Bros");
        CreativeWork GM = new CreativeWork("Game of Thrones", "HBO");
        CreativeWork PS = new CreativeWork("Peep Show", "BBC");
        CreativeWork BS = new CreativeWork("Better Call Saul");
        CreativeWork BB = new CreativeWork("Better Call Saul");
        CreativeWork SJ = new CreativeWork("Slippin' Jimmy");


        System.out.println("Nombre del trabajo creativo: " + HP.toString());
        System.out.println("Nombre del trabajo creativo: " + GM.toString());
        System.out.println("Nombre del trabajo creativo: " + PS.toString());
        System.out.println("Nombre del trabajo creativo: " + BS.toString());
        System.out.println("Nombre del trabajo creativo: " + BB.toString());
        System.out.println("Nombre del trabajo creativo: " + SJ.toString());
        // Comparacion entre objetos con distintos titulos  con copyright, deberia dar false
        System.out.println("Es " + HP.getTitulo()+ " igual a "+ GM.getTitulo() + "? "  + HP.equals(GM));
        // Comparacion entre un objeto con copyright y otro sin copyright, deberia dar false
        System.out.println("Es " + HP.getTitulo()+ " igual a "+ BS.getTitulo() + "? "  + HP.equals(BS));
        // Comparacion entre objetos con distintos titulos sin copyright, deberia dar false
        System.out.println("Es " + BS.getTitulo()+ " igual a "+ SJ.getTitulo() + "? "  + BS.equals(SJ));
        // Comparacion de un objeto consigo mismo, deberia dar true
        System.out.println("Es " + PS.getTitulo()+ " igual a "+ PS.getTitulo() + "? "  + PS.equals(PS));
        // Comparacion entre objetos distintos pero con los mismos datos, deberia dar true
        System.out.println("Es " + BS.getTitulo()+ " igual a "+ BB.getTitulo() + "? "  + BS.equals(BB));


    }

}