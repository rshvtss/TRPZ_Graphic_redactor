package com.mycompany.code;

public class RealImage implements IImage {

    private String fileName;
    private byte[] data;

    public RealImage(String fileName, byte[] data) {
        this.fileName = fileName;
        this.data = data;
        System.out.println("Завантажено реальне зображення: " + fileName);
    }

    @Override
    public void display() {
        System.out.println("Відображення зображення: " + fileName);
    }

    @Override
    public byte[] getData() {
        return data;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
