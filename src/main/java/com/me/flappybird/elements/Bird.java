package com.me.flappybird.elements;

import com.me.flappybird.util.Vector;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.me.flappybird.elements.Bird.State.*;

public class Bird extends Element implements Moveable {
    private State state;
    private Vector velocity;

    public Bird() {
        super();

        this.state = MID;
        this.velocity = new Vector(5, 0);

        Image img = new Image(this.state.getImageURL());

        this.hitbox.setPosition(100, 350);
        this.hitbox.setSize(img.getWidth(), img.getHeight());

        this.addGraphicalElement(this.getBirdView());
    }

    @Override
    public void update() {
        this.setPos(
                this.getX() + this.getVelocity().getX(),
                this.getY() + this.getVelocity().getY()
        );

        if (this.getVelocity().getY() > 7.5) {
            this.setState(DOWN);
        } else if (this.getVelocity().getY() < -2.5) {
            this.setState(UP);
        } else {
            this.setState(MID);
        }

        this.velocity.addY(-2.5); // Gravity

        if (this.velocity.getY() < -30) {
            this.velocity.setY(-30); // Limit falling speed
        } else if (this.velocity.getY() > 15) {
            this.velocity.setY(15); // Limit rising speed
        }
    }

    @Override
    public Vector getVelocity() {
        return velocity;
    }

    @Override
    public void setVelocity(Vector velocity) {
        this.velocity.set(velocity);
    }

    @Override
    public void addVelocity(Vector velocity) {
        this.velocity.add(velocity);
    }

    private void setState(State state) {
        this.removeGraphicalElement(this.getBirdView());
        this.state = state;
        this.addGraphicalElement(this.getBirdView());

        switch (state) {
            case UP -> this.setRotate(-35);
            case MID -> this.setRotate(0);
            case DOWN -> this.setRotate(35);
        }
    }

    public void flap() {
        this.addVelocity(new Vector(0, 10));
    }

    public enum State {
        UP(State.class.getResource("/sprites/bird/bird_up.png").toString()),
        MID(State.class.getResource("/sprites/bird/bird_mid.png").toString()),
        DOWN(State.class.getResource("/sprites/bird/bird_down.png").toString());

        private final String url;

        State(String url) {
            this.url = url;
        }

        public String getImageURL() {
            return this.url;
        }
    }

    private ImageView getBirdView() {
        return new ImageView(this.state.getImageURL());
    }

}
