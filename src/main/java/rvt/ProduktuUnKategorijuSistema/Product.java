package rvt.ProduktuUnKategorijuSistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Product {
    
    public static void addProduct(String name, double price, int categoryId) {
        String sql = "INSERT INTO products(name, price, category_id) VALUES(?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, name);
            pstmt.setDouble(2, price);
            pstmt.setInt(3, categoryId);
            pstmt.executeUpdate();
            System.out.println("Produkts '" + name + "' veiksmīgi pievienots!");
            
        } catch (SQLException e) {
            System.out.println("Kļūda, pievienojot produktu (Pārliecinies, vai kategorijas ID eksistē): " + e.getMessage());
        }
    }

    public static void showAllProducts() {
        String sql = "SELECT p.id, p.name AS p_name, p.price, c.name AS c_name " +
                     "FROM products p " +
                     "LEFT JOIN categories c ON p.category_id = c.id";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            
            System.out.println("\n--- PRODUKTI ---");
            boolean irDati = false;
            while (rs.next()) {
                irDati = true;
                String katNosaukums = rs.getString("c_name") != null ? rs.getString("c_name") : "Nav kategorijas";
                System.out.println("ID: " + rs.getInt("id") + 
                                   " | Nosaukums: " + rs.getString("p_name") + 
                                   " | Cena: " + rs.getDouble("price") + " EUR" +
                                   " | Kategorija: " + katNosaukums);
            }
            if (!irDati) {
                System.out.println("Produktu saraksts ir tukšs.");
            }
            System.out.println("----------------");
            
        } catch (SQLException e) {
            System.out.println("Kļūda, atlasot produktus: " + e.getMessage());
        }
    }

    public static void searchProductsByCategory(String searchInput) {

        String sql = "SELECT p.id, p.name AS p_name, p.price, c.name AS c_name " +
                     "FROM products p " +
                     "JOIN categories c ON p.category_id = c.id " +
                     "WHERE c.id = ? OR c.name = ?";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            

            int categoryId = -1;
            try {
                categoryId = Integer.parseInt(searchInput);
            } catch (NumberFormatException e) {
                
            }
            
            pstmt.setInt(1, categoryId);
            pstmt.setString(2, searchInput);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                System.out.println("\n--- MEKLĒŠANAS REZULTĀTI (Kategorija: " + searchInput + ") ---");
                boolean irDati = false;
                while (rs.next()) {
                    irDati = true;
                    System.out.println("ID: " + rs.getInt("id") + 
                                       " | Nosaukums: " + rs.getString("p_name") + 
                                       " | Cena: " + rs.getDouble("price") + " EUR" +
                                       " | Kategorija: " + rs.getString("c_name"));
                }
                if (!irDati) {
                    System.out.println("Šai kategorijai netika atrasts neviens produkts.");
                }
                System.out.println("-------------------------------------------------------");
            }
            
        } catch (SQLException e) {
            System.out.println("Kļūda, meklējot produktus: " + e.getMessage());
        }
    }
}