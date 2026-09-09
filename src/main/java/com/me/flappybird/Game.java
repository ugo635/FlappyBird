package com.me.flappybird;

import com.me.flappybird.elements.Background;
import com.me.flappybird.elements.Bird;
import com.me.flappybird.elements.Element;
import com.me.flappybird.elements.Pillar;
import com.me.flappybird.util.Hitbox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

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

        Pillar bottomPillar = new Pillar(
                new Hitbox(
                        750,
                        FLOOR_HEIGHT,
                        40,
                        100
                ),
                Pillar.State.DOWN
        );

        Pillar topPillar = new Pillar(
                new Hitbox(
                        750,
                        ROOF_HEIGHT,
                        40,
                        100
                ),
                Pillar.State.UP
        );

        this.manager.addElement(bottomPillar);
        this.manager.addElement(topPillar);
    }
}
