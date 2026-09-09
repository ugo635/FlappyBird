package com.me.flappybird.elements;

import com.me.flappybird.util.Hitbox;
import javafx.scene.image.ImageView;

public class Background extends Element {
    public Background() {
        super(
                new Hitbox(
                    0,
                    0,
                    1200,
                    700
                )
        );

        this.addGraphicalElement(new ImageView(this.getClass().getResource("/sprites/background.png").toString()));
    }
}
