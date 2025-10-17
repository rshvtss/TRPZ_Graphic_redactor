package com.mycompany.code;

public class ImageController {

    private final ImageRepository imageRepo;
    private final EffectService effectService;

    public ImageController(ImageRepository repo, EffectService service) {
        this.imageRepo = repo;
        this.effectService = service;
    }

    public void displayImage(String fileName) {
        IImage proxy = new ProxyImage(fileName, imageRepo);
        proxy.display();
    }

    public Image applyEffectToImage(Image img, String effectName) {
        switch (effectName.toLowerCase()) {
            case "grayscale" -> effectService.setStrategy(new GrayscaleEffect());
            case "sepia" -> effectService.setStrategy(new SepiaEffect());
            case "invert" -> effectService.setStrategy(new InvertEffect());
            default -> throw new IllegalArgumentException("Невідомий ефект: " + effectName);
        }
        return effectService.applyEffect(img);
    }
}
