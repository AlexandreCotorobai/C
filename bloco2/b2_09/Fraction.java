import org.stringtemplate.v4.ST.RegionType;

public class Fraction {
    public int numerator;
    public int denominator;

    public Fraction(int numerator, int denominator){
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void reduce(){
        int gcd = gcd(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
    }

    public float result(){
        return numerator/denominator;
    }

    public void add(Fraction incoming){
        int numerator1 = this.numerator * incoming.denominator;
        int numerator2 = incoming.numerator * this.denominator;
        int denominator = this.denominator * incoming.denominator;
        this.numerator = numerator1 + numerator2; 
        this.denominator = denominator;
    }

    public void sub(Fraction incoming){
        int numerator1 = this.numerator * incoming.denominator;
        int numerator2 = incoming.numerator * this.denominator;
        int denominator = this.denominator * incoming.denominator;
        this.numerator = numerator1 - numerator2; 
        this.denominator = denominator;
    }

    public void mul(Fraction incoming){
        this.numerator *= incoming.numerator;
        this.denominator *= incoming.denominator;
    }

    public void div(Fraction incoming){
        this.numerator *= incoming.denominator;
        this.denominator *= incoming.numerator;
    }

    private int gcd(int a, int b){
        if (b==0) return a;
        return gcd(b, a%b);
    }
    
    @Override
    public String toString(){
        if (denominator == 1) return Integer.toString(numerator);
        return numerator + "/" + denominator;
    }
    
    public void pow(Fraction incoming){
        int numerator = (int) Math.pow(this.numerator, incoming.numerator);
        int denominator = (int) Math.pow(this.denominator, incoming.denominator);
        this.numerator = numerator;
        this.denominator = denominator;
    }
}
