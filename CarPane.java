package Week6;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class CarPane extends Pane {
    private Timeline forCarAnimation;
    private double x = 0;
    private double y = 100;
    private double radius = 5;

    public void pause() {
        forCarAnimation.pause();
    }
    public void play() {
        forCarAnimation.play();
    }


    public CarPane() {
        drawCar();
        forCarAnimation = new Timeline( new KeyFrame(Duration.millis(50), e -> moveCar()));
        forCarAnimation.setCycleCount(Timeline.INDEFINITE);
        forCarAnimation.play();
    }

    private void drawCar() {
        getChildren().clear();
        Rectangle rectangle = new Rectangle(x, y - 20, 50, 10);
        Polygon polygon = new Polygon(x + 10, y - 20, x + 20, y - 30, x + 30, y - 30, x + 40, y - 20);
        Circle firstD = new Circle(x + 15, y - 5, radius);
        Circle secondD = new Circle(x + 35, y - 5, radius);
        getChildren().addAll(rectangle, firstD, secondD, polygon);
    }

    public void increaseSpeed() {
        forCarAnimation.setRate(forCarAnimation.getRate() + 1);
    }

    public void decreaseSpeed() {
        forCarAnimation.setRate(forCarAnimation.getRate() - 1 );
    }

    protected void moveCar() {
        if (x <= getWidth()) {  x += 1;
        }
        else x = 0;
        drawCar();
    }
}
