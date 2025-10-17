package com.mycompany.code;

public class EffectService {

    private EffectStrategy strategy;

    public void setStrategy(EffectStrategy strategy) {
        this.strategy = strategy;
    }

    public Image applyEffect(Image img) {
        if (strategy == null) {
            throw new IllegalStateException("Ефект не вибрано!");
        }
        return strategy.apply(img);
    }
}
