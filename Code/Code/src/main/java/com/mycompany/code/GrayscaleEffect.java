package com.mycompany.code;

public class GrayscaleEffect implements EffectStrategy {
    @Override
    public Image apply(Image img) {
        System.out.println("Застосовано ефект: чорно-білий (Grayscale)");
        return img;
    }
}