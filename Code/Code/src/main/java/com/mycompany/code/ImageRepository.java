package com.mycompany.code;

import java.sql.*;

public class ImageRepository {

    private final Connection connection;

    public ImageRepository(Connection connection) {
        this.connection = connection;
    }

    public Image findByFileName(String fileName) throws SQLException {
        String query = "SELECT * FROM Images WHERE FileName = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, fileName);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            Image img = new Image();
            img.setId(rs.getInt("Id"));
            img.setFileName(rs.getString("FileName"));
            img.setFormat(rs.getString("Format"));
            img.setData(rs.getBytes("Data"));
            return img;
        }
        return null;
    }

    public void update(Image img) throws SQLException {
        String query = "UPDATE Images SET Data = ? WHERE Id = ?";
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setBytes(1, img.getData());
        stmt.setInt(2, img.getId());
        stmt.executeUpdate();
    }
}
