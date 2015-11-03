import calculatrice3.* ;

public class Calculer2 {
    public static void main(String [] args) {
        Calculatrice c = new Calculatrice() ;
	for (int i=0; i<args.length; i++)
	    System.out.println(args[i] + " = " + c.calculer(args[i])) ;
        /*try {
            for (int i=0; i<args.length; i++)
                System.out.println(args[i] + " = " + c.calculer(args[i])) ;
	    } catch (CalculatriceException e) {
            System.out.println(e.getMessage()) ;
	    }*/
    }
}
