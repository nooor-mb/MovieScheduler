import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

//import java.lang.classfile.Label;

public class MovieManagerGUI extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("🎬 Movie Screening Schedule Manager");

        // Labels
        Label titleLabel = new Label("Movie Title:");
        Label dateLabel = new Label("Date:");
        Label timeLabel = new Label("Time (HH:mm):");
        Label cinemaLabel = new Label("Cinema:");
        Label messageLabel = new Label();

        // Inputs
        TextField titleInput = new TextField();
        DatePicker datePicker = new DatePicker();
        TextField timeInput = new TextField();
        TextField cinemaInput = new TextField();

        // Buttons
        Button addBtn = new Button("Add Screening");
        Button viewBtn = new Button("View Screenings");
        Button updateBtn = new Button("Update");
        Button deleteBtn = new Button("Delete");
        Button saveBtn = new Button("Save to File");
        Button loadBtn = new Button("Load from File");
        Button importBtn = new Button("Import CSV");

        // Style buttons
        for (Button btn : new Button[]{addBtn, viewBtn, updateBtn, deleteBtn, saveBtn, loadBtn, importBtn}) {
            btn.setStyle("-fx-background-color: #a78bfa; -fx-text-fill: white; -fx-background-radius: 15;");
        }

        // Layout
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(20));
        grid.setHgap(10);
        grid.setVgap(12);

        grid.add(titleLabel, 0, 0);
        grid.add(titleInput, 1, 0);
        grid.add(dateLabel, 0, 1);
        grid.add(datePicker, 1, 1);
        grid.add(timeLabel, 0, 2);
        grid.add(timeInput, 1, 2);
        grid.add(cinemaLabel, 0, 3);
        grid.add(cinemaInput, 1, 3);

        grid.add(addBtn, 0, 4);
        grid.add(viewBtn, 1, 4);
        grid.add(updateBtn, 0, 5);
        grid.add(deleteBtn, 1, 5);
        grid.add(saveBtn, 0, 6);
        grid.add(loadBtn, 1, 6);
        grid.add(importBtn, 0, 7);

        grid.add(messageLabel, 0, 8, 2, 1);

        // Scene and Styling
        Scene scene = new Scene(grid, 450, 450);
        scene.getStylesheets().add(getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
