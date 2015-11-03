package calculatrice3;
import java.util.Stack;

public enum Operation {
    PLUS("+",2), MOINS("-",2), FOIS("*",2), DIV("/",2), PUISS("^",2), SQRT("V", 1), ABS("ABS", 1), NOT("NOT", 1), IF("IF", 3), DROP, DUP, SWAP, COUNT ;
    private final String code_operation;
    private final int nbrArgument;

    Operation(String code_operation, int nbrArgument) {
	this.code_operation = code_operation;
	this.nbrArgument = nbrArgument;
    }

    Operation() {
	this.code_operation = super.toString();
	this.nbrArgument = 0;
    }

    public String toString() {
	return this.code_operation;
    }

    public double eval(double[] operandes) {
	switch (this) {
	case PLUS:
	    return operandes[0]+operandes[1];
	case MOINS :
	    return operandes[0]-operandes[1];
	case FOIS :
	    return operandes[0]*operandes[1];
	case DIV :
	    return operandes[0]/operandes[1];
	case PUISS :
	    return Math.pow(operandes[0],operandes[1]);
	case SQRT :
	    return Math.sqrt(operandes[0]);
	case ABS :
	    return Math.abs(operandes[0]);
	case NOT :
	    if (operandes[0] == 0)
		return operandes[0] = 1;
	    else
		return operandes[0] = 0;
	case IF :
	    if (operandes[0] != 0)
		return operandes[1];
	    else
		return operandes[2];
	default :
	    return 0;
	}
    }

    public void execute(Stack<Double> pile ) {
	double tmp = 0,tmp2 = 0;
	double [] nombre;
	if (this.nbrArgument!=0) {
	    nombre = new double[this.nbrArgument];
	    //On dépile le nombre de fois qu'il faut
	    for (int i=0;i<this.nbrArgument;i++) {
		nombre[i] = pile.pop();
	    }
	    tmp = this.eval(nombre);
	    //On empile le resultat
	    pile.push(tmp);
	}
	else {
	    switch (this) {
	    case DROP:
	        pile.pop();
		break;
	    case DUP :
		pile.push(pile.peek());
		break;
	    case SWAP :
	        tmp = pile.pop();
		tmp2 = pile.pop();
		pile.push(tmp);
		pile.push(tmp2);
		break;
	    case COUNT :
		pile.push((double)pile.size());
		break;
	    default :
	        break;
	    }
	}
    }
}
