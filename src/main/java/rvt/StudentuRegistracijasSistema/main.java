package rvt.StudentuRegistracijasSistema;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        RegistrationService service = new RegistrationService();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Sveicināti studentu reģistrācijas sistēmā!");

        while (running) {
            System.out.println("\nIzvēlieties darbību:");
            System.out.println("1. Reģistrēt jaunu studentu");
            System.out.println("2. Parādīt visus studentus");
            System.out.println("3. Rediģēt studenta datus");
            System.out.println("4. Dzēst studentu");
            System.out.println("5. Iziet");
            System.out.print("Ievadiet ciparu (1-5): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    service.register();
                    break;
                case "2":
                    service.show();
                    break;
                case "3":
                    service.edit();
                    break;
                case "4":
                    service.remove();
                    break;
                case "5":
                    System.out.println("Programma darbu beigusi. Uz redzēšanos!");
                    running = false;
                    break;
                default:
                    System.out.println("Nekorekta izvēle. Lūdzu, mēģiniet vēlreiz.");
            }
        }
        
        scanner.close();
    }
}