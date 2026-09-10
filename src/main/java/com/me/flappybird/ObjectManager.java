package com.me.flappybird;

import com.me.flappybird.elements.Background;
import com.me.flappybird.elements.Bird;
import com.me.flappybird.elements.Element;
import com.me.flappybird.elements.Pillar;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private Pane root;

    private Bird bird;
    private List<Pillar> pillars;
    private List<Element> elements;

    private final Timeline timer;
    public boolean hasStarted;

    public ObjectManager(Pane root, Background background, Bird bird) {
        this.bird = bird;
        this.root = root;
        this.pillars = new ArrayList<>();
        this.elements = new ArrayList<>();
        this.addElement(background);
        this.addElement(bird);

        this.hasStarted = false;
        this.timer = new Timeline();

        timer.getKeyFrames().setAll(new KeyFrame(Duration.millis(100), event -> {
            if (!this.hasStarted) return;

            this.elements.forEach(Element::update);
            if (bird.getY() < Game.FLOOR_HEIGHT || bird.getY() > Game.ROOF_HEIGHT) {
                this.gameOver();
            }
        }));

        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();
    }

    private void gameOver() {
        Label label = new Label("Game Over");

        label.setScaleY(-1); // Flips the label back
        label.setTextFill(Color.RED);
        label.setStyle("-fx-font-size: 48px; -fx-font-weight: bold;");
        label.setLayoutX(400);
        label.setLayoutY(300);

        this.root.getChildren().add(label);

        timer.stop();
    }

    public void addElement(Element elem) {
        this.elements.add(elem);
        this.root.getChildren().add(elem);

        elem.updateGraphicalPosition();
    }

    public void addPillar(Pillar pillar) {
        this.addElement(pillar);
        this.pillars.add(pillar);
    }

}
