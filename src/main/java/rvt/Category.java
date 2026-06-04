package rvt;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Category {
    private int id;
    private String name;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public static void addCategory(String name) {
        String sql = "INSERT INTO categories(name) VALUES(?)";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, name);
            pstmt.executeUpdate();
            System.out.println("Kategorija '" + name + "' veiksmīgi pievienota!");

        } catch (SQLException e) {
            System.out.println("Kļūda, pievienojot kategoriju: " + e.getMessage());
        }

    }

    public static void showAllCategories() {
        String sql = "SELECT * FROM categories";

        try (Connection conn = DatabaseConnection.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {

            System.out.println("\n--- KATEGORIJAS ---");
            boolean irDati = false;
            while (rs.next()) {
                irDati = true;
                System.out.println("ID: " + rs.getInt("id") + " | Nosaukums:" + rs.getString("name"));
            }
            if (!irDati) {
                System.out.println("Kategoriju saraksts ir tukšs");
            }
            System.out.println("---------------");

        } catch (SQLException e) {
            System.out.println("Kļūda, atlasot kategorijas: " + e.getMessage());
        }
    }
    
}
