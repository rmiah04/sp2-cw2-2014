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
	String myString = "2 * 2 * 2";
	String eval= sPlit(myString);
//	for (String element : eval) {
//		int i = 1;
//        System.out.println(element);
//        System.out.println("i = " + i);
//        i++;
//		}
	System.out.println(eval);
	}
	public static String sPlit (String str){
		String toSplit = str;
	String  splitString[] = toSplit.split("\\s+");
	//String element : splitString
	String toEval = toSplit;
	//String feval = "";
	Boolean endit = false;
	for (int i = 0; i < splitString.length; i++) {
			if(splitString[i].equals("*")){
				if (i>=1){
					int before = Integer.parseInt(splitString[i-1]);
					int after = Integer.parseInt(splitString[i+1]);
					int eval = before * after;
					toEval = Integer.toString(eval);
					
					int c = toEval.length() + 4  ;
					if (c <toSplit.length() ){
					String nstring = toEval + "" + toSplit.substring(c);
					System.out.println(nstring);
					toEval = sPlit(nstring);
					endit = true;
					}
				}
			}
			if (endit == true){
			break;
			}
	}
	return toEval;
	}
}
