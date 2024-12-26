package HesapMakinesii;

import java.util.Scanner;
import java.util.function.Function;

public class Driver {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		System.out.println("Choose an operation:");
		System.out.println("1. Addition");
		System.out.println("2. Subtraction");
		System.out.println("3. Multiplication");
		System.out.println("4. Division");
		System.out.println("5. Sin");
		System.out.println("6. Cos");
		System.out.println("7. Tangent");
		System.out.println("8. Logarithm");
		System.out.println("9. Square Root");
		System.out.println("10. Derivative Calculation");
		System.out.println("11. Matrix Operations");
		System.out.println("12. Integral Calculation");


		int choice = sc.nextInt();
		sc.nextLine();

		double result = Double.NaN;
		double[][] matrixResult = null;

		if (choice >= 1 && choice <= 4) {
		    System.out.println("Enter the first number:");
		    double num1 = getValidDouble(sc);

		    System.out.println("Enter the second number:");
		    double num2 = getValidDouble(sc);

		    Calculator calculator = new Calculator(num1, num2);

		    switch (choice) {
		        case 1 -> result = calculator.add();
		        case 2 -> result = calculator.subtract();
		        case 3 -> result = calculator.multiply();
		        case 4 -> result = calculator.divide();
		        default -> System.out.println("Invalid choice!");
		    }
		} else if (choice >= 5 && choice <= 9) {
		    System.out.println("Enter a value:");
		    double value = getValidDouble(sc);

		    ScientificCalculator scientificCalculator = new ScientificCalculator();

		    switch (choice) {
		        case 5 -> result = scientificCalculator.sinFunction(value);
		        case 6 -> result = scientificCalculator.cosFunction(value);
		        case 7 -> result = scientificCalculator.tanFunction(value);
		        case 8 -> result = scientificCalculator.logFunction(value);
		        case 9 -> result = scientificCalculator.sqrtFunction(value);
		        default -> System.out.println("Invalid choice!");
		    }
		} else if (choice == 10) {
		    System.out.println("Enter a function (e.g., x*x):");
		    String function = sc.nextLine();
		    System.out.println("Enter the value of x to calculate the derivative:");
		    double xValue = getValidDouble(sc);

		    DerivativeCalculator derivativeCalculator = new DerivativeCalculator();
		    result = derivativeCalculator.calculateDerivative(function, xValue);
		} else if (choice == 11) {
		    System.out.println("Choose a matrix operation:");
		    System.out.println("1. Addition");
		    System.out.println("2. Subtraction");
		    System.out.println("3. Multiplication");
		    int matrixChoice = sc.nextInt();

		    System.out.println("Enter the dimensions of the first matrix (rows and columns):");
		    int rowsA = sc.nextInt();
		    int colsA = sc.nextInt();
		    double[][] matrixA = readMatrix(sc, rowsA, colsA);

		    System.out.println("Enter the dimensions of the second matrix (rows and columns):");
		    int rowsB = sc.nextInt();
		    int colsB = sc.nextInt();
		    double[][] matrixB = readMatrix(sc, rowsB, colsB);

		    MatrixOperations matrixOps = new MatrixOperations();

		    if (matrixChoice == 1 && rowsA == rowsB && colsA == colsB) {
		        matrixResult = matrixOps.add(matrixA, matrixB);
		    } else if (matrixChoice == 2 && rowsA == rowsB && colsA == colsB) {
		        matrixResult = matrixOps.subtract(matrixA, matrixB);
		    } else if (matrixChoice == 3 && colsA == rowsB) {
		        matrixResult = matrixOps.multiply(matrixA, matrixB);
		    } else {
		        System.out.println("Invalid dimensions for matrix operation.");
		    }
		} else if (choice == 12) {
		    System.out.println("Lower bound:");
		    double lowerBound = getValidDouble(sc);
		    System.out.println("Upper bound:");
		    double upperBound = getValidDouble(sc);
		    System.out.println("Number of intervals:");
		    int intervals = sc.nextInt();

		    System.out.println("Function (e.g., x*x):");
		    sc.nextLine();
		    String functionInput = sc.nextLine();
		    Function<Double, Double> function = x -> evalFunction(functionInput, x);

		    IntegralCalculator integralCalculator = new IntegralCalculator();
		    result = integralCalculator.calculateIntegral(function, lowerBound, upperBound, intervals);
		} else {
		    System.out.println("Invalid choice!");
		}

		if (matrixResult != null) {
		    System.out.println("Result Matrix:");
		    printMatrix(matrixResult);
		} else if (!Double.isNaN(result)) {
		    System.out.println("Result: " + result);
		}

		sc.close();
		}

		private static double getValidDouble(Scanner sc) {
		    while (!sc.hasNextDouble()) {
		        System.out.println("Invalid input. Please enter a number:");
		        sc.next();
		    }
		    return sc.nextDouble();
		}

		private static double[][] readMatrix(Scanner sc, int rows, int cols) {
		    double[][] matrix = new double[rows][cols];
		    System.out.println("Enter matrix values:");
		    for (int i = 0; i < rows; i++) {
		        for (int j = 0; j < cols; j++) {
		            matrix[i][j] = getValidDouble(sc);
		        }
		    }
		    return matrix;
		}

		private static void printMatrix(double[][] matrix) {
		    for (double[] row : matrix) {
		        for (double value : row) {
		            System.out.print(value + " ");
		        }
		        System.out.println();
		    }
		}

		private static Double evalFunction(String function, double x) {
		    return switch (function) {
		        case "x*x" -> x * x;
		        case "sin(x)" -> Math.sin(x);
		        case "cos(x)" -> Math.cos(x);
		        default -> throw new IllegalArgumentException("Unsupported function: " + function);
		    };
		}
}