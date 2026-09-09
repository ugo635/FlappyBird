package com.me.flappybird.elements;

import com.me.flappybird.util.Hitbox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Pillar extends Element {
    private State state;

    public Pillar(Hitbox hitbox, State state) {
        super(hitbox);
        this.state = state;

        if (hitbox.getHeight() % 20 != 0)
            throw new IllegalArgumentException("Height must be a multiple of 20");

        this.addGraphicalElement(this.getPillarView());
    }

    private StackPane getPillarView() {
        double width = this.getHitboxWidth();
        double height = this.getHitboxHeight();
        double capHeight = 30;

        StackPane pillar = new StackPane();

        Rectangle body = new Rectangle(width, height, Color.web("#4CAF22"));

        Rectangle highlight = new Rectangle(width * 0.15, height, Color.web("#82D832"));
        highlight.setTranslateX(-width * 0.25);

        Rectangle shadow = new Rectangle(width * 0.15, height, Color.web("#287A18"));
        shadow.setTranslateX(width * 0.425);

        StackPane bodyLayer = new StackPane(body, highlight, shadow);

        Rectangle cap = new Rectangle(width + 12, capHeight, Color.web("#4CAF22"));
        cap.setArcWidth(6);
        cap.setArcHeight(6);

        if (state == State.UP) {
            cap.setTranslateY(height / 2 - capHeight / 2);
            pillar.setTranslateY(height);
        } else {
            cap.setTranslateY(-height / 2 + capHeight / 2);
        }

        pillar.getChildren().addAll(bodyLayer, cap);

        return pillar;
    }

    /**
     * Where the floor is <br>
     * UP - The pillar goes from the roof to the bottom <br>
     * DOWN - The pillar goes from the floor to the top
     */
    public enum State {
        UP, DOWN
    }
}