import java.lang.*;

public class Complex{
    private int imaginary;
    private int real;

    public Complex(int real, int im){
        this.real = real;
        this.imaginary = im;
    }


    public int im() {
        return this.imaginary;
    }

    public int real() {
        return this.real;
    }

    public Complex sum(int r, int i){
        return new Complex(r+this.real, i+this.imaginary);
    }

    public Complex sub(int r, int i){
        return new Complex(this.real-r, this.imaginary-i);
    }

    public Complex mult(int r, int i){
        int rr = this.real*r - this.imaginary*i;
        int ii = this.real*i + this.imaginary*r;

        return new Complex(rr, ii);
    }

    @Override
    public String toString(){
        return Integer.toString(real) +(imaginary > 0 ? " + ": " - ") + Integer.toString(Math.abs(imaginary))+ "i";
    }

}