import java.awt.Color;

public class ImageClassifier {

    public static double[] extractFeatures(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        double[] features = new double[width * height];

        int index = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                Color color = picture.get(col, row);
                features[index++] = color.getRed();
            }
        }

        return features;
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ImageClassifier <training-file> <testing-file>");
            return;
        }

        String trainingFile = args[0];
        String testingFile = args[1];

        In trainingIn = new In(trainingFile);
        int m = trainingIn.readInt();
        int width = trainingIn.readInt();
        int height = trainingIn.readInt();
        int n = width * height;

        MultiPerceptron perceptron = new MultiPerceptron(m, n);

        while (!trainingIn.isEmpty()) {
            String imageFile = trainingIn.readString();
            int label = trainingIn.readInt();
            Picture picture = new Picture(imageFile);
            double[] features = extractFeatures(picture);
            perceptron.trainMulti(features, label);
        }

        In testingIn = new In(testingFile);
        m = testingIn.readInt();
        width = testingIn.readInt();
        height = testingIn.readInt();

        int totalTests = 0;
        int misclassified = 0;

        while (!testingIn.isEmpty()) {
            String imageFile = testingIn.readString();
            int actualLabel = testingIn.readInt();
            Picture picture = new Picture(imageFile);
            double[] features = extractFeatures(picture);
            int predictedLabel = perceptron.predictMulti(features);

            if (predictedLabel != actualLabel) {
                System.out.println(imageFile);
                misclassified++;
            }

            totalTests++;
        }
        double errorRate = (double) misclassified / totalTests;
        System.out.printf("test error rate = %.3f\n", errorRate);
    }
}

