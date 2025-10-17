package com.mycompany.code;

public class SepiaEffect implements EffectStrategy {
    @Override
    public Image apply(Image img) {
        System.out.println("Застосовано ефект: сепія (Sepia)");
        return img;
    }
}