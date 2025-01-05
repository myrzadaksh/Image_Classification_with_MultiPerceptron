Image Classifier Using MultiPerceptron

Overview:

- This project implements an Image Classifier that uses the MultiPerceptron algorithm for multiclass classification of images. The classifier extracts the red channel of each pixel as a feature, trains the model on a set of labeled images, and evaluates its performance on a testing dataset.

- The classifier predicts the class of each image based on the extracted features and calculates the error rate. This project demonstrates how to use a multi-layer perceptron for image classification tasks in Java.


Features:

- Feature Extraction: Uses pixel values (red channel) from images to create feature vectors.
  
- Multi-Class Classification: Classifies images into one of several predefined categories using a MultiPerceptron.
  
- Error Rate Calculation: After classification, calculates and displays the error rate based on misclassified images.
  
- Image Handling: Uses the Picture class to load and manipulate images.

  
Technologies Used:

- Java
  
- MultiPerceptron Algorithm: For multiclass classification.
  
- Picture Class: To load and process images.
  
- In Class: To read input data for training and testing.

  
How It Works:

1)Feature Extraction:

- The classifier extracts the red color value of each pixel in the image as the feature vector.
  
- The feature vector is a 1D array representing the image (width × height).
  
2)Training:

- The training set is read from a file where each image is associated with a label.
  
- The MultiPerceptron is trained using these feature vectors and their corresponding labels.
  
3)Prediction:

- After training, the classifier predicts the label of images in the testing set.

- The predicted label is compared to the actual label, and misclassified images are reported.

4)Error Rate:

- The classifier calculates the error rate by dividing the number of misclassified images by the total number of test images.


Learning Outcomes:

- Understand how MultiPerceptron can be applied to multiclass classification.

- Learn how to extract features from images (in this case, pixel color values).

- Explore the use of a multi-layer perceptron for classification tasks.

  
Contributions:

- Contributions are always welcome! If you have any improvements, bug fixes, or suggestions, feel free to open an issue or create a pull request.


License:

- This project is licensed under the MIT License.


The link for ZIP file:

https://drive.google.com/drive/folders/1ZldiE0rIUtWYv-BrOVMBOac3v-ImRQaH
