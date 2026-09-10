package com.me.flappybird.util;

public class Vector {
    public double x;
    public double y;

    public Vector(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Vector() {
        this(0, 0);
    }

    public void add(Vector vector) {
        this.x += vector.x;
        this.y += vector.y;
    }

    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }

    public void addX(double x) {
        this.x += x;
    }

    public void addY(double y) {
        this.y += y;
    }

    public void times(double multiplier) {
        this.x *= multiplier;
        this.y *= multiplier;
    }

    public void times(Vector multiplier) {
        this.x *= multiplier.x;
        this.y *= multiplier.y;
    }

    public void timesX(double multiplier) {
        this.x *= multiplier;
    }

    public void timesY(double multiplier) {
        this.y *= multiplier;
    }

    public Vector copy() {
        return new Vector(this.x, this.y);
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
}
