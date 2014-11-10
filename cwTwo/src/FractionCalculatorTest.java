import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Ronu
 *
 */
public class FractionCalculatorTest{
	//test the input with correct out put for the caculator
	@Test 
	public void inputTest(){
		String input = "3/4 + 1/-3 * 7 / 5";
		String result = "17/60";
		assertEquals(result, FractionCalculator.strInput(input));
	}

}
