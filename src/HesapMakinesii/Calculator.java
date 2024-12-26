package HesapMakinesii;

public class Calculator {

    private double x;
    private double y;

    public Calculator() {

    }

    public Calculator(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double add() {
        return x + y;
    }

    public double subtract() {
        return x - y;
    }

    public double multiply() {
        return x * y;
    }

    public double divide() {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            System.out.println("Error: You cannot divide a number by zero.");
            return Double.NaN;
        }
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
