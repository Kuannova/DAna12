package Week7;

import javafx.application.Application;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;

public class Ex16_24 extends Application {
    /*private static final String MEDIA_URL =
             "http://cs.armstrong.edu/liang/common/Clouds.mp4";*/
    public static String getTimeString(double speed) {
        speed /= 1000;
        String s = formatTime(speed % 60);
        speed /= 60;
        String m = formatTime(speed % 60);
        speed /= 60;
        String h = formatTime(speed % 24);
        return h + ":" + m + ":" + s;
    }

    public static String formatTime(double time) {
        int t = (int)time;
        if (t > 9) {
            return String.valueOf(t);
        }
        return "0" + t;
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        File mediaFile = new File("C:\\Users\\user\\Downloads\\WhatsApp Video 2022-03-16 at 15.01.37.mp4");
        Media media = new Media(mediaFile.toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button playButton = new Button(">");
        playButton.setOnAction(e -> {
            if (playButton.getText().equals(">")) {
                mediaPlayer.play();
                playButton.setText("||");
            } else {
                mediaPlayer.pause();
                playButton.setText(">");
            }
        });
        Button rewindButton = new Button("<<");
        rewindButton.setOnAction(e -> mediaPlayer.seek(Duration.ZERO));

        Slider slider = new Slider();
        slider.setPrefWidth(150);
        slider.setValue(10);
        System.out.println(mediaPlayer.volumeProperty());
        System.out.println(slider.valueProperty());
        slider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                System.out.println(slider.valueProperty());
            }
        });
        mediaPlayer.volumeProperty().bind(slider.valueProperty().divide(100));

        Label timer = new Label("Time");

        Slider foTimeSlider = new Slider(0, 0, 0);
        mediaPlayer.setAutoPlay(true);
        mediaPlayer.currentTimeProperty().addListener(ov -> {
            if (!foTimeSlider.isValueChanging()) {

                double total = mediaPlayer.getTotalDuration().toMillis();
                double current = mediaPlayer.getCurrentTime().toMillis();
                foTimeSlider.setMax(total);
                foTimeSlider.setValue(current);
                timer.setText(getTimeString(current) + "/" + getTimeString(total));
            }
        });

        foTimeSlider.valueProperty().addListener(event -> {
            if (foTimeSlider.isValueChanging()) {
                mediaPlayer.seek(new Duration(foTimeSlider.getValue()));
            }
        });
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().addAll(playButton,rewindButton,foTimeSlider,timer , new Label("Volume"),slider);

        BorderPane pane = new BorderPane();
        pane.setCenter(mediaView);
        pane.setBottom(hBox);
        mediaPlayer.play();


        Scene scene = new Scene(pane,600,700);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
