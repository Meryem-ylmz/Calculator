package HesapMakinesii;

public class MatrixOperations {

	public double[][] add(double[][] matrixA, double[][] matrixB) {
		int rows = matrixA.length;
		int cols = matrixA[0].length;
		double[][] result = new double[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = matrixA[i][j] + matrixB[i][j];
			}
		}
		return result;
	}

	public double[][] subtract(double[][] matrixA, double[][] matrixB) {
		int rows = matrixA.length;
		int cols = matrixA[0].length;
		double[][] result = new double[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				result[i][j] = matrixA[i][j] - matrixB[i][j];
			}
		}
		return result;
	}

	public double[][] multiply(double[][] matrixA, double[][] matrixB) {
		int rowsA = matrixA.length;
		int colsA = matrixA[0].length;
		int colsB = matrixB[0].length;
		double[][] result = new double[rowsA][colsB];

		for (int i = 0; i < rowsA; i++) {
			for (int j = 0; j < colsB; j++) {
				for (int k = 0; k < colsA; k++) {
					result[i][j] += matrixA[i][k] * matrixB[k][j];
				}
			}
		}
		return result;
	}

}
