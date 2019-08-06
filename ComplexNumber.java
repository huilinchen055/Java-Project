public class ComplexNumber {
    private double real;
    private double imag;

    public ComplexNumber(double real, double imag){
        this.real = real;
        this.imag = imag;
    }

    public ComplexNumber add(ComplexNumber other){
        double newReal = this.real + other.real;
        double newImag = this.imag + other.imag;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber subtract(ComplexNumber other) {
        double newReal = this.real - other.real;
        double newImag = this.real - other.imag;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber multiply(ComplexNumber other){
        double newReal = this.real * other.real - this.imag * other.imag;
        double newImag = this.real * other.imag + this.imag * other.real;
        return new ComplexNumber(newReal, newImag);
    }

    public ComplexNumber divide(ComplexNumber other){
        double newReal = (other.real * this.real + other.imag * other.imag)/(Math.pow(this.real,2)+Math.pow(this.imag,2));
        double newImag = (other.imag * this.real - other.real * this.imag)/(Math.pow(this.real,2)+Math.pow(this.imag,2));
        return new ComplexNumber(newReal, newImag);
    }

}
