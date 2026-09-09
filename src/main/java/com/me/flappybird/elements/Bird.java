package com.me.flappybird.elements;

import com.me.flappybird.util.Hitbox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import static com.me.flappybird.elements.Bird.State.*;

public class Bird extends Element {
    private State state;

    public Bird() {
        super(getInitHitbox());

        this.state = DOWN;

        this.addGraphicalElement(this.getBirdView());
    }

    private static Hitbox getInitHitbox() {
        String resource = Bird.class.getResource("/sprites/bird/bird_mid.png").toString();
        Image img = new Image(resource);

        return new Hitbox(
                100,
                350,
                img.getWidth(),
                img.getHeight()
        );
    }

    private ImageView getBirdView() {
        return this.state.getImage();
    }

    public void setState(State state) {
        this.removeGraphicalElement(this.getBirdView());
        this.state = state;
        this.addGraphicalElement(this.getBirdView());
    }

    public enum State {
        UP(State.class.getResource("/sprites/bird/bird_up.png").toString()),
        MID(State.class.getResource("/sprites/bird/bird_mid.png").toString()),
        DOWN(State.class.getResource("/sprites/bird/bird_down.png").toString());

        private final ImageView img;

        State(String url) {
            this.img = new ImageView(url);
        }

        public ImageView getImage() {
            return this.img;
        }
    }
}
