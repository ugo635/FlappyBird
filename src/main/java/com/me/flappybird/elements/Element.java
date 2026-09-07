package com.me.flappybird.elements;

import com.me.flappybird.util.Hitbox;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public abstract class Element extends StackPane {
    private final Hitbox hitbox;

    public Element(Hitbox hitbox) {
        this.hitbox = hitbox;
    }

    public void addGraphicalElement(Node element) {
        this.getChildren().add(element);
    }

    public void removeGraphicalElement(Node element) {
        this.getChildren().remove(element);
    }

    public double getX() {
        return this.hitbox.getX();
    }

    public double getY() {
        return this.hitbox.getY();
    }

    public double getHitboxWidth() {
        return this.hitbox.getWidth();
    }

    public double getHitboxHeight() {
        return this.hitbox.getHeight();
    }
}
