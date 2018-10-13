// Assignment #: Arizona State University CSE205 #7
//         Name: Jon Bartlett
//    StudentID: 1215254430
//      Lecture: Lecture 3, M,W 6:00-7:15
//  Description: The Assignment7 class creates a view.DrawPane object
//               on which we can draw different shapes with different
//               colors and erase one or all, etc.
//               see view.DrawPane.java

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import view.DrawPane;

public class Assignment7 extends Application {
    /**
     * Application start.
     * @param primaryStage primaryStage
     */
    public void start(Stage primaryStage) {
        //create a view.DrawPane object. See view.DrawPane.java for details.
        final DrawPane gui = new DrawPane();

        //put gui on top of the rootPane
        final StackPane rootPane = new StackPane();
        rootPane.getChildren().add(gui);

        // Create a scene and place rootPane in the stage
        final Scene scene = new Scene(rootPane, 600, 400);
        primaryStage.setTitle("Shape Drawing");
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    /**
     * Main function for application.
     * @param args args
     */
    public static void main(String[] args) {
        Application.launch(args);
    }
}
