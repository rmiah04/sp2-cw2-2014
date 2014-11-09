import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ronu
 *
 */
public class FractionCalculatorTest{
	//tests input. 3/4 + 1/-3 * 7 / 5
	@Test
	public void inputtest(){
	String myString = "1 1/2 + 1 2/3 + 2 3/4";
	String eval= fracSplit(myString);
	System.out.println("result " + eval);
	boolean mixed = false;
	if (eval.contains(" ")){
		String fram[] = eval.split(" ");
		for (int e = 0; e < fram.length; e++){
			System.out.println("result " + fram[e]);
		if (fram[e].matches("-?\\d+")){
		mixed = true;
		}
		}
	}
	System.out.println("result " + mixed);
	//System.out.println(space + eval);
	while (mixed){
		boolean match = false;
		eval = fracSplit(eval);
		System.out.println("result " + eval);
		if (eval.contains(" ")){
			String fram[] = eval.split(" ");
			for (int e = 0; e < fram.length; e++){
				if (fram[e].matches("-?\\d+")){
					match = true;
					}
			}
			if (match != true ){
				mixed = false;
			}
		}
		
	}
	System.out.println("final result " + eval);
	}
	//Fraction math expressions
	public static String fracSplit (String str){
	String toSplit = str;
	String toEval = "";
	if (!toSplit.contains(" ")){
		return toEval;
		}
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
				System.out.println(value);
			//}
			int c = i;
			//if (c > 0){
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
	return toEval;
	}
	
	//string to math expressions
	
	public static String sPlit (String str){
		String toSplit = str;
	String  splitString[] = toSplit.split("\\s+");
	String toEval = "";
	Boolean endit = false;
	for (int i = 0; i < splitString.length; i++) {
			if(splitString[i].equals("*")){
				if (i>=1){
					int before = Integer.parseInt(splitString[i-1]);
					int after = Integer.parseInt(splitString[i+1]);
					int eval = before * after;
					String value = Integer.toString(eval);
					int c = i;
					if (splitString[c-1] != null && c+1 <= splitString.length){
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
			if(splitString[i].equals("/")){
				if (i>=1){
					int before = Integer.parseInt(splitString[i-1]);
					int after = Integer.parseInt(splitString[i+1]);
					int eval = before / after;
					String value = Integer.toString(eval);
					int c = i;
					if (splitString[c-1] != null && c+1 <= splitString.length){
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
					endit = true;
				}
			}
			if(splitString[i].equals("+")){
				if (i>=1){
					int before = Integer.parseInt(splitString[i-1]);
					int after = Integer.parseInt(splitString[i+1]);
					int eval = before + after;
					String value = Integer.toString(eval);
					int c = i;
					if (splitString[c-1] != null && c+1 <= splitString.length){
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
					endit = true;
				}
			}
			if(splitString[i].equals("-")){
				if (i>=1){
					int before = Integer.parseInt(splitString[i-1]);
					int after = Integer.parseInt(splitString[i+1]);
					int eval = before - after;
					String value = Integer.toString(eval);
					int c = i;
					if (splitString[c-1] != null && c+1 <= splitString.length){
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
					endit = true;
				}
			}
			if (endit == true){
			break;
			}
	}
	return toEval;
	}
}
