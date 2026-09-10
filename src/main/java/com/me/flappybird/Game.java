package com.me.flappybird;

import com.me.flappybird.elements.Background;
import com.me.flappybird.elements.Bird;
import com.me.flappybird.elements.Element;
import com.me.flappybird.elements.Pillar;
import com.me.flappybird.util.Hitbox;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.util.Objects;

public class Game {
    private final Pane root;
    private ObjectManager manager;

    public static int FLOOR_HEIGHT = 9;
    public static int ROOF_HEIGHT = 691;

    public Game(Pane root) {
        this.root = root;
        this.initializeGame();
    }

    private void initializeGame() {
        Bird bird = new Bird();
        Background background = new Background();
        this.manager = new ObjectManager(this.root, background, bird);

        this.addPillars();

        this.root.setOnMouseClicked(event -> {
            if (!this.manager.hasStarted) this.manager.hasStarted = true;
            bird.flap();
        });

        this.root.setOnKeyPressed(event -> {
            if (!this.manager.hasStarted) this.manager.hasStarted = true;
            if (Objects.requireNonNull(event.getCode()) == KeyCode.SPACE) {
                bird.flap();
            }
        });
    }

    private void addPillars() {
        Pillar bottomPillar = new Pillar(
                new Hitbox(
                        750,
                        FLOOR_HEIGHT,
                        40,
                        240
                ),
                Pillar.State.DOWN
        );

        Pillar topPillar = new Pillar(
                new Hitbox(
                        750,
                        ROOF_HEIGHT,
                        40,
                        240
                ),
                Pillar.State.UP
        );

        this.manager.addPillar(bottomPillar);
        this.manager.addPillar(topPillar);
    }
}
