
public class FractionCalculator extends Fraction{

	public FractionCalculator(int num, int denom) {
		super(num, denom);
		// TODO Auto-generated constructor stub
	}
	public Fraction add(Fraction frac) {

        int num = this.getNumerator() + frac.getNumerator();
        int denom = this.getDenominator() + frac.getDenominator();
        return new Fraction(num, denom);
    }
}
