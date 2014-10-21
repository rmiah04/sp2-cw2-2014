import static org.junit.Assert.*;

import org.junit.Test;

/**
 * 
 */

/**
 * @author Ronu
 *
 */
public class FractionCalculatorTest{

	@Test
	public void multiply() {
        assert((new FractionCalculator(3, 10)).equals(new FractionCalculator(1, 2).multiply(new FractionCalculator(3, 5))));

	}
	@Test 
	public void zero (){
		new FractionCalculator(1, 0);
	}
	@Test
	public void equals1(){
		assert (new FractionCalculator(1, 2).equals(new FractionCalculator(1, 2)));
	}
	@Test
	public void equals2(){
		assert (new FractionCalculator(1, 2).equals(new FractionCalculator(3, 6)));
	}
	@Test
	public void equals3(){
		assert (new FractionCalculator(-1, 2).equals(new FractionCalculator(1, -2)));
	}
	@Test
	public void equals4(){
		assert (new FractionCalculator(-1, -2).equals(new FractionCalculator(1, 2)));
	}
	@Test
	public void add1(){
		assert((new FractionCalculator(3, 10)).equals(new FractionCalculator(1, 2).add(new FractionCalculator(3, 5))));
	}
}
