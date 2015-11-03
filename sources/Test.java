import calculatrice.* ;

public class Test {
    public static void main(String [] args) {
	double x,y;
	String operation;
        if (args.length < 2) 
            System.err.println("Au moins deux nombres sur la ligne de commande !") ;
        else {
            // deux nombres passés sur la ligne de commande
	    switch (args.length) {
	    case 2 :
	        x = new Double(args[0]) ;
	        y = new Double(args[1]) ;
		// la liste des opérations disponibles
		for (Operation o: Operation.values())
		    System.out.println(x + " " + o + " " + y + " = " + o.eval(x,y)) ;
		break;
		
	    case 3 :
	        x = new Double(args[0]) ;
	        operation = new String(args[1]);
	        y = new Double(args[2]) ;
		for (Operation o: Operation.values()) {
		    if (o.toString().equals(operation))
			System.out.println(x + " " + o + " " + y + " = " + o.eval(x,y)) ;
		}
		break;
		
	    default :
		System.out.println("Erreur");
	    }
        }
    }
}
