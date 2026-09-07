package com.me.flappybird;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        Pane root = new Pane();
        Scene scene = new Scene(root);

        root.setScaleY(-1); // Flips the Y coordinate to make (0, 0) mean bottom left instead of top left

        stage.setTitle("FlappyBird");
        stage.setScene(scene);
        stage.show();

        stage.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
