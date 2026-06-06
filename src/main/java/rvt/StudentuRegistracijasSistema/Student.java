package rvt.StudentuRegistracijasSistema;
import java.time.LocalDateTime;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private LocalDateTime registrationDate;

    public Student(String firstName, String lastName, String email, String personalCode, LocalDateTime registrationDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationDate = registrationDate;
    }

    public String toCSV() {
        return firstName + "," + lastName + "," + email + "," + personalCode + "," + registrationDate;
    }

    public static Student fromCSV(String line) {
        String[] data = line.split(",");
        return new Student(
                data[0],
                data[1],
                data[2],
                data[3],
                LocalDateTime.parse(data[4])
        );
    }

    public String getPersonalCode() {
        return personalCode;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String formattedOutput() {
        return String.format("| %-12s | %-12s | %-25s | %-12s | %-20s |",
                firstName, lastName, email, personalCode, registrationDate);
    }
}