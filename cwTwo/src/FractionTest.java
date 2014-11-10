import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Created by keith for the second coursework assignment.
 *
 * You need to recode this as a series of JUnit tests
 */
public class FractionTest {
	@Test
	public void multiply() {
        assertEquals((new Fraction(3, 10)),(new Fraction(1, 2).multiply(new Fraction(3, 5))));
        //test output pass

	}
	@Test
	public void multiplyTwo() {
        assertEquals((new Fraction(3, 11)),(new Fraction(1, 2).multiply(new Fraction(3, 5))));
        //test output for failure

	}

	//zero value test
	@Test 
	public void zero (){
		new Fraction(1, 0);
	}
	@Test
	public void equals1(){
		assertEquals(new Fraction(1, 2),(new Fraction(1, 2)));
	}
	@Test
	public void equals2(){
		assertEquals(new Fraction(1, 2),(new Fraction(3, 6)));
	}
	@Test
	public void equals3(){
		assertEquals(new Fraction(-1, 2),(new Fraction(1, -2)));
	}
	// test for failure
	@Test
	public void equals4(){
		assertEquals(new Fraction(-1, -2),(new Fraction(1, 4)));
	}
	//addition test
	@Test
	public void add(){
		assertEquals((new Fraction(3, 2)),(new Fraction(3, 4).add(new Fraction(3, 4))));

	}
	//subtraction test
	@Test
	public void sub(){
		assertEquals((new Fraction(1, 4)),(new Fraction(2, 4).subtract(new Fraction(1, 4))));
		System.out.println(new Fraction(3, 4));
	}
	//subtraction test two
		@Test
		public void subTwo(){
			assertEquals((new Fraction(1, 4)),(new Fraction(2, 4).subtract(new Fraction(2, 8))));
			System.out.println(new Fraction(3, 4));
		}
		//Devision test one
		@Test
		public void devided(){
			assertEquals((new Fraction(1, 4)),(new Fraction(2, 4).devide(new Fraction(2, 8))));
			System.out.println(new Fraction(3, 4));
		}
		//Devision test two
		@Test
		public void devidedTwo(){
			assertEquals((new Fraction(8, 3)),(new Fraction(2, 3).devide(new Fraction(1, 4))));
			System.out.println(new Fraction(3, 4));
		}
		//add with negative
		@Test
		public void nAdd(){
			assertEquals((new Fraction(5, 12)),(new Fraction(3, 4).add(new Fraction(1, -3))));

		}
		

}
