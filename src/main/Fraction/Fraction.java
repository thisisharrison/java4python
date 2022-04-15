import java.util.ArrayList;
import java.util.Collections;

public class Fraction extends Number implements Comparable<Fraction> {
    private Integer numerator;
    private Integer denominator;

    public Integer getNumerator() {
        return numerator;
    }

    public Integer getDenominator() {
        return denominator;
    }

    public void setNumerator(Integer numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(Integer denominator) {
        this.denominator = denominator;
    }

    public Fraction(Integer top, Integer bottom) {
        numerator = top;
        denominator = bottom;
    }

    //    overloading constructor to take a number and return a fraction
    public Fraction(Integer number) {
        numerator = number;
        denominator = 1;
    }

    //    public: any other method may call the add method
    //    Fraction: add will return a Fraction as well
    public Fraction add(Fraction otherFrac) {
        Integer newNum = otherFrac.getDenominator() * numerator + denominator * otherFrac.getNumerator();
        Integer newDen = otherFrac.getDenominator() * denominator;
        Integer common = gcd(newNum, newDen);
        return new Fraction(newNum / common, newDen / common);
    }

    //    overloading Add
    public Fraction add(Integer number) {
        Fraction otherFrac = new Fraction(number);
        return add(otherFrac);
    }

    public String toString() {
        return numerator.toString() + "/" + denominator.toString();
    }

    public boolean equals(Fraction otherFrac) {
        Integer num1 = numerator * otherFrac.getDenominator();
        Integer num2 = denominator * otherFrac.getNumerator();
        if (num1 == num2)
            return true;
        else
            return false;
    }

    //    We are extending Fraction class to Number and we must have a few methods
    public double doubleValue() {
        return numerator.doubleValue() / denominator.doubleValue();
    }

    public float floatValue() {
        return numerator.floatValue() / denominator.floatValue();
    }

    public int intValue() {
        return numerator.intValue() / denominator.intValue();
    }

    public long longValue() {
        return numerator.longValue() / denominator.longValue();
    }

    //    implements the Comparable interface
    public int compareTo(Fraction otherFrac) {
        Integer num1 = numerator * otherFrac.getDenominator();
        Integer num2 = denominator * otherFrac.getNumerator();
        return num1 - num2;
    }

    private static Integer gcd(Integer m, Integer n) {
        while (m % n != 0) {
            Integer oldm = m;
            Integer oldn = n;
            m = oldn;
            n = oldm % oldn;
        }
        return n;
    }

    // Play around with using Number type
    public Fraction test_add(Number a) {
//        a can be a Fraction
        int val = a.intValue();
//        val becomes 0, from 1/2
        System.out.println(val);
        return this.add(val);
    }

    public static void main(String[] args) {
        System.out.println("Addition: ");

        Fraction oneHalf = new Fraction(1, 2);

        System.out.println(oneHalf.add(1));

        Fraction otherHalf = new Fraction(1, 2);

        System.out.println(oneHalf.add(oneHalf));

        System.out.println("Equality: ");
        System.out.println(oneHalf.equals(otherHalf));

        System.out.println("Test a function that takes a Number type: ");
        System.out.println(oneHalf.test_add(otherHalf));

//        Test out the Comaprable interface
        ArrayList<Fraction> listOfFrac = new ArrayList<Fraction>();
        listOfFrac.add(oneHalf);
        listOfFrac.add(new Fraction(1));
        listOfFrac.add(new Fraction(1, 3));
        listOfFrac.add(new Fraction(1, 5));
        Collections.sort(listOfFrac);

        System.out.println("Sorted fractions: ");
        for (Fraction f : listOfFrac) {
            System.out.println(f);
        }
    }
}
