package com.me.flappybird;

import com.me.flappybird.elements.Background;
import com.me.flappybird.elements.Bird;
import com.me.flappybird.elements.Element;
import com.me.flappybird.elements.Pillar;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class ObjectManager {
    private Pane root;

    private Bird bird;
    private List<Pillar> pillars;

    private List<Element> elements;

    public ObjectManager(Pane root, Background background, Bird bird) {
        this.root = root;
        this.elements = new ArrayList<>();
        this.addElement(background);
        this.addElement(bird);
    }

    public void addElement(Element elem) {
        this.elements.add(elem);
        this.root.getChildren().add(elem);

        elem.updateGraphicalPosition();
    }

}
