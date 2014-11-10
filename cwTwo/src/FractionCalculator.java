import java.util.Scanner;
/**
 * @author Ronu
 *
 */
public class FractionCalculator{
	public static void main (String[]args){
		Scanner input = new Scanner(System.in);
	    System.out.println("Welcome to fraction Calculator, created by Ronu");
	    System.out.println("please enter the fractions to calculate separated by space : ");
    	String mathExp = "0";
    	boolean ex = false;
    	if (mathExp.equals("q") || mathExp.equals("Q")){
    			ex = true;
    		}
	    while (!ex){
		    System.out.println("Result :" + mathExp);
	    	mathExp = input.nextLine();
	    	boolean match = false;
	    	if (mathExp.equals("q") || mathExp.equals("Q")){
				match = true;
			}
			if (match == true ){
			    System.out.println("Goodbye");
				ex = true;
			}
	    	mathExp = strInput(mathExp);
		}
	 }
	//calculates input
	public static String strInput (String myString){
	String eval = frMaker(myString);
	eval = frMath(eval);
	boolean mixed = false;
	if (eval.contains(" ")){
			mixed = true;
		}
	while (mixed){
		boolean match = false;
		eval = frMath(eval);
		if (eval.contains(" ")){
				match = true;
			}
			if (match != true ){
				mixed = false;
			}
		}
	return eval;
	}
	//method to create a string of fractions
	public static String frMaker (String str){
		String myString = str;
		String eval= fracSplit(myString);
		boolean mixed = false;
		if (eval.contains(" ")){
			String fram[] = eval.split(" ");
			for (int e = 0; e < fram.length; e++){
				if (fram[e].matches("-?\\d+")){
				mixed = true;
				}
			}
		}
		while (mixed){
			boolean match = false;
			eval = fracSplit(eval);
			if (eval.contains(" ")){
				String fram[] = eval.split(" ");
				for (int e = 0; e < fram.length; e++){
					if (e > 0 && fram[e - 1].matches("-?\\d+")){
						match = true;
						}
					if (fram[fram.length-1].matches("-?\\d+")){
						match = true;
					}
				}
				if (match != true ){
					mixed = false;
				}
			}
		}
		return eval;
	}
	//Fraction math expressions
	public static String fracSplit (String str){
	String toSplit = str;
	String toEval = "";
	String  splitString[] = toSplit.split("\\s+");
	//convert mixed fractions to improper fractions
	for (int i = 0; i < splitString.length; i++) {
		if(splitString[i].contains("/") && splitString[i].length() >2){
			if (i > 0 && splitString[i-1].matches("-?\\d+")){
				String frac[] = splitString[i].split("/");
				int num = Integer.parseInt(frac[0]);
				int denom = Integer.parseInt(frac[1]);
				String value = null;
				int before = Integer.parseInt(splitString[i-1]);
				int nNum = before * denom;
				nNum += num;
				value = nNum + "/" + denom;
				int c = i;
				for (int e = 0; e < splitString.length; e++){
					if (e < c - 1){
						toEval += splitString[e] + " ";
					}
					if (e == c && value != null){
						toEval += "" + value;
					}
					if (e > c ){
						toEval += " " + splitString[e];
					}
				}
				return toEval;
			}
		}
	}
	//convert whole numbers to improper fractions
	for (int i = 0; i < splitString.length; i++) {
		if (splitString[i].matches("-?\\d+")){
				int num = Integer.parseInt(splitString[i]);
				int denom = 1;
				String value = null;
				value = num + "/" + denom;
				int c = i;
				for (int e = 0; e < splitString.length; e++){
					if (e < c){
						toEval += splitString[e] + " ";
					}
					if (e == c && value != null){
						toEval += "" + value;
					}
					else if (e==c && value == null) {
						toEval += "" + splitString[e];
					}
					if (e > c ){
						toEval += " " + splitString[e];
					}
				}
				return toEval;
		}
	}
	return toSplit;
	}
	public static String frMath (String str){
		String toSplit = str;
		String  splitString[] = toSplit.split("\\s+");
		String toEval = "";
		//perform Multiplication
		for (int i = 0; i < splitString.length; i++) {
				if(splitString[i].equals("*")){
					if (i>=1){
						String before[] = splitString[i - 1].split("/");
						String after []= splitString[i + 1].split("/");
						int bnum = Integer.parseInt(before[0]);
						int bdenom = Integer.parseInt(before[1]);
						int anum = Integer.parseInt(after[0]);
						int adenom = Integer.parseInt(after[1]);
						 Fraction eval = new Fraction(bnum, bdenom).multiply(new Fraction(anum, adenom));
						String value = eval.toString();
						int c = i;
						if (splitString[c-1] != null && c+1 < splitString.length){
						for (int e = 0; e < splitString.length; e++){
							if (e < c - 1){
								toEval += splitString[e] + " ";
							}
							if (e == c){
								toEval += "" + value;
							}
							if (e > c +1){
								toEval += " " + splitString[e];
							}
							}
						}	
						return toEval;
					}
				}
		}
		//Perform Devision
		for (int i = 0; i < splitString.length; i++) {
			if(splitString[i].equals("/")){
				if (i>=1){
					String before[] = splitString[i - 1].split("/");
					String after []= splitString[i + 1].split("/");
					int bnum = Integer.parseInt(before[0]);
					int bdenom = Integer.parseInt(before[1]);
					int anum = Integer.parseInt(after[0]);
					int adenom = Integer.parseInt(after[1]);
					 Fraction eval = new Fraction(bnum, bdenom).devide(new Fraction(anum, adenom));
					String value = eval.toString();
					int c = i;
					if (splitString[c-1] != null && c+1 < splitString.length){
					for (int e = 0; e < splitString.length; e++){
						if (e < c - 1){
							toEval += splitString[e] + " ";
						}
						if (e == c){
							toEval += "" + value;
						}
						if (e > c +1){
							toEval += " " + splitString[e];
						}
						}
					}	
					return toEval;
				}
			}
		}
		//Perform Addition
		for (int i = 0; i < splitString.length; i++) {
			if(splitString[i].equals("+")){
				if (i>=1 && i < splitString.length){
					String before[] = splitString[i - 1].split("/");
					String after []= splitString[i + 1].split("/");
					int bnum = Integer.parseInt(before[0]);
					int bdenom = Integer.parseInt(before[1]);
					int anum = Integer.parseInt(after[0]);
					int adenom = Integer.parseInt(after[1]);
					 Fraction eval = new Fraction(bnum, bdenom).add(new Fraction(anum, adenom));
					String value = eval.toString();
					int c = i;
					if (splitString[c-1] != null && c+1 < splitString.length){
					for (int e = 0; e < splitString.length; e++){
						if (e < c - 1){
							toEval += splitString[e] + " ";
						}
						if (e == c){
							toEval += "" + value;
						}
						if (e > c +1){
							toEval += " " + splitString[e];
						}
						}
					}	
					return toEval;
				}
			}
		}
		//Perform subtraction
		for (int i = 0; i < splitString.length; i++) {
			if(splitString[i].equals("-")){
				if (i>=1){
					String before[] = splitString[i - 1].split("/");
					String after []= splitString[i + 1].split("/");
					int bnum = Integer.parseInt(before[0]);
					int bdenom = Integer.parseInt(before[1]);
					int anum = Integer.parseInt(after[0]);
					int adenom = Integer.parseInt(after[1]);
					 Fraction eval = new Fraction(bnum, bdenom).subtract(new Fraction(anum, adenom));
					String value = eval.toString();
					int c = i;
					if (splitString[c-1] != null && c+1 < splitString.length){
					for (int e = 0; e < splitString.length; e++){
						if (e < c - 1){
							toEval += splitString[e] + " ";
						}
						if (e == c){
							toEval += "" + value;
						}
						if (e > c +1){
							toEval += " " + splitString[e];
						}
						}
					}	
					return toEval;
				}
			}
		}
		return toSplit;
	}
}