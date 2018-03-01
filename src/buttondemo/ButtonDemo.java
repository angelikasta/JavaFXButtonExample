package buttondemo;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

public class ButtonDemo extends Application {

    protected Text text = new Text(50, 50, "JavaFX Programming");

    protected BorderPane getPane() throws FileNotFoundException {
        FileInputStream inputLeft = new FileInputStream("resources\\left.png");
        FileInputStream inputRight = new FileInputStream("resources\\right.png");

        Image rightImage = new Image(inputRight);
        Image leftImage = new Image(inputLeft);
       
        ImageView imageViewRight = new ImageView(rightImage);
        imageViewRight.setFitHeight(25);
        imageViewRight.setFitWidth(25);

        
        ImageView imageViewLeft = new ImageView(leftImage);
        imageViewLeft.setFitHeight(25);
        imageViewLeft.setFitWidth(25);
        HBox paneForButtons = new HBox(20);
        Button btUp = new Button("up", imageViewLeft);
        Button btDown = new Button("down", imageViewRight);
        Button btLeft = new Button("Left",
                imageViewLeft);
        Button btRight = new Button("Right",
                imageViewRight);
        
        paneForButtons.getChildren().addAll(btLeft, btRight, btUp, btDown);
        paneForButtons.setAlignment(Pos.CENTER);
        paneForButtons.setStyle("-fx-border-color: green");

        BorderPane pane = new BorderPane();
        pane.setBottom(paneForButtons);

        Pane paneForText = new Pane();
        paneForText.getChildren().add(text);
        pane.setCenter(paneForText);

        btLeft.setOnAction(e -> text.setX(text.getX() - 10));
        btRight.setOnAction(e -> text.setX(text.getX() + 10));
        btUp.setOnAction(e -> text.setY(text.getY() - 10));
        btDown.setOnAction(e -> text.setY(text.getY() + 10));
        

        return pane;
    }

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) throws FileNotFoundException {
        // Create a scene and place it in the stage
        Scene scene = new Scene(getPane(), 450, 200);
        primaryStage.setTitle("ButtonDemo"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        
        primaryStage.show(); // Display the stage
    }

    /**
     * The main method is only needed for the IDE with limited JavaFX support.
     * Not needed for running from the command line.
     */
    public static void main(String[] args) {
        launch(args);
    }
}
