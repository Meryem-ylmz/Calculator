package HesapMakinesii;

import java.util.function.Function;

public class IntegralCalculator {

	public double calculateIntegral(Function<Double, Double> function, double lowerBound, double upperBound,
			int intervals) {
		double stepSize = (upperBound - lowerBound) / intervals;
		double integral = 0.0;

		for (int i = 0; i < intervals; i++) {
			double x1 = lowerBound + i * stepSize;
			double x2 = x1 + stepSize;
			integral += (function.apply(x1) + function.apply(x2)) / 2 * stepSize;
		}

		return integral;
	}

}
