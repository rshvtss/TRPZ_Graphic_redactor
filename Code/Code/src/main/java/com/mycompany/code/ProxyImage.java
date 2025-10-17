package com.mycompany.code;

import java.sql.SQLException;

public class ProxyImage implements IImage {

    private String fileName;
    private ImageRepository imageRepo;
    private RealImage realImage;

    public ProxyImage(String fileName, ImageRepository imageRepo) {
        this.fileName = fileName;
        this.imageRepo = imageRepo;
    }

    @Override
    public void display() {
        try {
            if (realImage == null) {
                System.out.println("Проксі: ліниве завантаження зображення " + fileName);
                Image dbImage = imageRepo.findByFileName(fileName);
                if (dbImage != null) {
                    realImage = new RealImage(dbImage.getFileName(), dbImage.getData());
                } else {
                    System.out.println("Зображення не знайдено у базі!");
                    return;
                }
            }
            realImage.display();
        } catch (SQLException e) {
            System.err.println("Помилка доступу до БД: " + e.getMessage());
        }
    }

    @Override
    public byte[] getData() {
        return realImage != null ? realImage.getData() : null;
    }

    @Override
    public String getFileName() {
        return fileName;
    }
}
