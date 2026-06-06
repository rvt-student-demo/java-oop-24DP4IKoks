package rvt.StudentuRegistracijasSistema;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class RegistrationService {
    private Scanner scanner = new Scanner(System.in);

    public void register() {
        System.out.println("=== Jauna studenta reģistrācija ===");

        String firstName;
        do {
            System.out.print("Vārds: ");
            firstName = scanner.nextLine();
        } while (!Validator.validateName(firstName));

        String lastName;
        do {
            System.out.print("Uzvārds: ");
            lastName = scanner.nextLine();
        } while (!Validator.validateName(lastName));

        String email;
        do {
            System.out.print("E-pasts: ");
            email = scanner.nextLine();
        } while (!Validator.validateEmail(email));

        String personalCode;
        do {
            System.out.print("Personas kods (11 cipari): ");
            personalCode = scanner.nextLine();
        } while (!Validator.validatePersonalCode(personalCode));

        Student student = new Student(
                firstName,
                lastName,
                email,
                personalCode,
                LocalDateTime.now()
        );

        FileHandler.saveStudent(student);
        System.out.println("Students veiksmīgi reģistrēts!");
    }

    public void show() {
        List<Student> students = FileHandler.readStudents();

        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.printf("| %-12s | %-12s | %-25s | %-12s | %-20s |\n",
                "Vārds", "Uzvārds", "E-pasts", "Pers.kods", "Reģ.datums");
        System.out.println("-------------------------------------------------------------------------------------------");

        for (Student s : students) {
            System.out.println(s.formattedOutput());
        }

        System.out.println("-------------------------------------------------------------------------------------------");
    }

    public void remove() {
        System.out.print("Ievadi personas kodu: ");
        String code = scanner.nextLine();

        List<Student> students = FileHandler.readStudents();
        students.removeIf(s -> s.getPersonalCode().equals(code));

        FileHandler.overwriteFile(students);
        System.out.println("Ja eksistēja — students dzēsts.");
    }

    public void edit() {
        System.out.print("Ievadi personas kodu: ");
        String code = scanner.nextLine();

        List<Student> students = FileHandler.readStudents();

        for (Student s : students) {
            if (s.getPersonalCode().equals(code)) {
                System.out.print("Jaunais vārds: ");
                s.setFirstName(scanner.nextLine());

                System.out.print("Jaunais uzvārds: ");
                s.setLastName(scanner.nextLine());

                System.out.print("Jaunais e-pasts: ");
                s.setEmail(scanner.nextLine());
            }
        }

        FileHandler.overwriteFile(students);
        System.out.println("Dati atjaunināti.");
    }
}