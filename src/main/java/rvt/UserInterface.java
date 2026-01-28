package rvt;
import java.util.Scanner;

public class UserInterface {
 
    private ToDoList list;
    private Scanner scanner;
 
    public UserInterface(ToDoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }
 
    public void start() {
        while (true) {
            System.out.println("Command:");
            String command = scanner.nextLine();
            if (command.equals("add")) {
                System.out.println("To add:");
                String add = scanner.nextLine();
                this.list.add(add);
            } else if (command.equals("list")) {
                this.list.print();
            } else if (command.equals("remove")) {
                System.out.println("Which one is removed?");
                int number = Integer.valueOf(scanner.nextLine());
                this.list.remove(number);
            } else if (command.equals("stop")) {
                break;
            }
        }
    }
}
 

