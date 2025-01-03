public class MultiPerceptron {

    private final int m;
    private final int n;
    private final double[][] weights;

    public MultiPerceptron(int m, int n) {
        this.m = m;
        this.n = n;
        this.weights = new double[m][n];
    }

    public int numberOfClasses() {
        return m;
    }

    public int numberOfInputs() {
        return n;
    }

    public int predictMulti(double[] x) {
        if (x.length != n) {
            throw new IllegalArgumentException(
                    "Feature vector size does not match the expected size: " + n);
        }

        double maxScore = Double.NEGATIVE_INFINITY;
        int bestClass = -1;

        for (int i = 0; i < m; i++) {
            double score = 0.0;
            for (int j = 0; j < n; j++) {
                score += weights[i][j] * x[j];
            }

            if (score > maxScore) {
                maxScore = score;
                bestClass = i;
            }
        }

        return bestClass;
    }

    public void trainMulti(double[] x, int label) {
        if (x.length != n) {
            throw new IllegalArgumentException(
                    "Feature vector size does not match the expected size: " + n);
        }

        int predictedLabel = predictMulti(x);

        if (predictedLabel != label) {
            for (int j = 0; j < n; j++) {
                weights[label][j] += x[j];
            }

            for (int j = 0; j < n; j++) {
                weights[predictedLabel][j] -= x[j];
            }
        }
    }
}
