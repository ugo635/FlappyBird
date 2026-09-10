package com.me.flappybird.elements;

import com.me.flappybird.util.Vector;

public interface Moveable {
    Vector getVelocity();

    void setVelocity(Vector velocity);
    void addVelocity(Vector velocity);
}
