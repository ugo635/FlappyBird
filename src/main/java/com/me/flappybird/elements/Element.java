package com.me.flappybird.elements;

import com.me.flappybird.util.Hitbox;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public abstract class Element extends StackPane {
    protected final Hitbox hitbox;

    public Element(Hitbox hitbox) {
        this.hitbox = hitbox;
        this.setScaleY(-1); // Flips the element to be flipped on the y axis
    }

    public Element() {
        this(new Hitbox(0, 0, 0, 0));
    }

    public final void addGraphicalElement(Node element) {
        this.getChildren().add(element);
    }

    public final void removeGraphicalElement(Node element) {
        this.getChildren().remove(element);
    }

    public final double getX() {
        return this.hitbox.getX();
    }

    public final double getY() {
        return this.hitbox.getY();
    }

    public final double getHitboxWidth() {
        return this.hitbox.getWidth();
    }

    public final double getHitboxHeight() {
        return this.hitbox.getHeight();
    }

    public final Hitbox getHitbox() {
        return this.hitbox;
    }

    public final boolean intersects(Element other) {
        return this.hitbox.intersects(other.getHitbox());
    }

    public void update() {}

    public final void setPos(double x, double y) {
        this.hitbox.setX(x);
        this.hitbox.setY(y);

        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public final void updateGraphicalPosition() {
        this.setLayoutX(this.hitbox.getX());
        this.setLayoutY(this.hitbox.getY());
    }
}
