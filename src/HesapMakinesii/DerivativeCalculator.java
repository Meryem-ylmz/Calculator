package HesapMakinesii;

import net.objecthunter.exp4j.ExpressionBuilder;

public class DerivativeCalculator {
	public double calculateDerivative(String function, double x) {
		String derivativeFunction = differentiate(function);

		double derivativeAtX = evaluateExpression(derivativeFunction, x);
		return derivativeAtX;

	}

	private String differentiate(String function) {
		if (function.contains("x")) {
			return function.replace("x^2", "2*x");
		}

		return function;
	}

	private double evaluateExpression(String expression, double x) {
		double result = new ExpressionBuilder(expression).variables("x").build().setVariable("x", x).evaluate();

		return result;
	}

}
