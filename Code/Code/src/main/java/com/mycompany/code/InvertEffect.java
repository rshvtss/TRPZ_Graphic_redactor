package com.mycompany.code;

public class InvertEffect implements EffectStrategy {
    @Override
    public Image apply(Image img) {
        System.out.println("Застосовано ефект: негатив (Invert)");
        return img;
    }
}