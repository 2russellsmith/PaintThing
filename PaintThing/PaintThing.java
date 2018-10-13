import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import view.DrawPane;

public class PaintThing extends Application {
    /**
     * Application start.
     * @param primaryStage primaryStage
     */
    public void start(Stage primaryStage) {
        final DrawPane gui = new DrawPane();

        final StackPane rootPane = new StackPane();
        rootPane.getChildren().add(gui);

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
