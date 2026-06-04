package rvt;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DatabaseConnection.initializeDatabase();
        
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("\n1 - Pievienot kategoriju");
            System.out.println("2 - Pievienot produktu");
            System.out.println("3 - Parādīt visas kategorijas");
            System.out.println("4 - Parādīt visus produktus");
            System.out.println("5 - Meklēt produktus pēc kategorijas");
            System.out.println("0 - Iziet");
            System.out.print("Izvēlies darbību: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Kļūda: Lūdzu, ievadiet skaitli no izvēlnes!");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Ievadi kategorijas nosaukumu: ");
                    String catName = scanner.nextLine();
                    if (!catName.trim().isEmpty()) {
                        Category.addCategory(catName);
                    } else {
                        System.out.println("Kategorijas nosaukums nevar būt tukšs!");
                    }
                    break;

                case 2:
                    System.out.print("Ievadi produkta nosaukumu: ");
                    String prodName = scanner.nextLine();
                    
                    System.out.print("Ievadi cenu (piemēram, 12.50): ");
                    double price;
                    try {
                        price = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Kļūda: Nepareizs cenas formāts!");
                        break;
                    }

                    Category.showAllCategories();
                    System.out.print("Ievadi izvēlētās kategorijas ID: ");
                    int catId;
                    try {
                        catId = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Kļūda: Kategorijas ID jābūt skaitlim!");
                        break;
                    }

                    if (!prodName.trim().isEmpty()) {
                        Product.addProduct(prodName, price, catId);
                    } else {
                        System.out.println("Produkta nosaukums nevar būt tukšs!");
                    }
                    break;

                case 3:
                    Category.showAllCategories();
                    break;

                case 4:
                    Product.showAllProducts();
                    break;

                case 5:
                    System.out.print("Ievadi kategorijas ID vai nosaukumu: ");
                    String searchInput = scanner.nextLine();
                    if (!searchInput.trim().isEmpty()) {
                        Product.searchProductsByCategory(searchInput);
                    } else {
                        System.out.println("Meklēšanas frāze nevar būt tukša!");
                    }
                    break;

                case 0:
                    System.out.println("Programma darbu beigusi. Uz redzēšanos!");
                    break;

                default:
                    System.out.println("Nepareiza izvēle, mēģini vēlreiz.");
            }
        }
        scanner.close();
    }
}