package com.me.flappybird;

import com.me.flappybird.elements.Background;
import com.me.flappybird.elements.Bird;
import com.me.flappybird.elements.Element;
import com.me.flappybird.util.Hitbox;
import javafx.scene.layout.Pane;

public class Game {
    private final Pane root;
    private ObjectManager manager;

    public Game(Pane root) {
        this.root = root;
        this.initializeGame();
    }

    private void initializeGame() {
        Bird bird = new Bird();
        Background background = new Background();
        this.manager = new ObjectManager(this.root, background, bird);
    }
}
