package com.example.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Exe14_6 extends Application {
    public void start(Stage primaryStage){
        GridPane pane = new GridPane();
        int board = 0;
        for (int i = 0; i < 8; i++) {
            board++;
            for (int j = 0; j < 8; j++) {
                Rectangle rectangle = new Rectangle(50, 50, 50, 50);
                Rectangle rectangle2 = new Rectangle(50,50, 50, 50);
            if (board % 2 == 0){
                rectangle.setFill(Color.WHITE);
                rectangle2.setFill(Color.BLACK);
            }
                pane.add(rectangle, j, i);
            board++;
            }
        }

        Scene scene = new Scene(pane, 400, 400);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
