package Week7;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Ex16_1 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Text text = new Text(50, 50, "Java is fun");
        text.setFont(Font.font("Times New Roman", FontWeight.BOLD, FontPosture.ITALIC,24));

        HBox hBox = new HBox();
        Button left = new Button("<=");
        Button right = new Button("=>");
        hBox.getChildren().addAll(left, right);
        hBox.setAlignment(Pos.CENTER);
        borderPane.setBottom(hBox);
        left.setOnAction(e -> text.setX(text.getX() - 10));
        right.setOnAction(e -> text.setX(text.getX() + 10));

        HBox hbox2 = new HBox();
        RadioButton red = new RadioButton("Red");
        RadioButton yellow = new RadioButton("Yellow");
        RadioButton black = new RadioButton("Black");
        RadioButton orange = new RadioButton("Orange");
        RadioButton green = new RadioButton("Green");
        hbox2.getChildren().addAll(red, yellow, black, orange, green);

        red.setOnAction(e -> {
            if (red.isSelected()) {
                text.setFill(Color.RED);
            }
        });
        yellow.setOnAction(e -> {
            if (yellow.isSelected()) {
                text.setFill(Color.YELLOW);
            }
        });
        black.setOnAction(e -> {
            if (black.isSelected()) {
                text.setFill(Color.BLACK);
            }
        });
        orange.setOnAction(e -> {
            if (orange.isSelected()) {
                text.setFill(Color.ORANGE);
            }
        });
        green.setOnAction(e -> {
            if (green.isSelected()) {
                text.setFill(Color.GREEN);
            }
        });

        ToggleGroup group = new ToggleGroup();
        red.setToggleGroup(group);
        yellow.setToggleGroup(group);
        black.setToggleGroup(group);
        orange.setToggleGroup(group);
        green.setToggleGroup(group);

        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: black");
        pane.getChildren().add(text);


        borderPane.setBottom(hBox);
        borderPane.setCenter(pane);
        borderPane.setTop(hbox2);

        Scene scene = new Scene(borderPane, 450, 150);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
