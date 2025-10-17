package com.mycompany.code;

public class EditorUI {

    private final ImageController controller;

    public EditorUI(ImageController controller) {
        this.controller = controller;
    }

    public void onDisplayImage(String fileName) {
        controller.displayImage(fileName);
    }

    public void onApplyEffect(Image img, String effectName) {
        Image result = controller.applyEffectToImage(img, effectName);
        System.out.println("Ефект '" + effectName + "' застосовано до зображення " + img.getFileName());
    }

    public static void main(String[] args) {
        ImageRepository repo = new ImageRepository(null); // імітація
        EffectService service = new EffectService();
        ImageController controller = new ImageController(repo, service);
        EditorUI ui = new EditorUI(controller);

        ui.onDisplayImage("example.jpg");
        ui.onApplyEffect(new Image(), "sepia");
    }
}
