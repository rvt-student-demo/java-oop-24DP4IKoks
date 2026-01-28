package rvt;
import java.util.ArrayList;

public class ToDoList {
 
    private ArrayList<String> tasks;
    private final String filePath = "";
 
    public ToDoList() {
        this.tasks = new ArrayList<>();
    }
 
    public void add(String task) {
        this.tasks.add("do a homework");
        this.tasks.add("exercise 30 min");
        this.tasks.add("go for a walk");
    }
 
    public void print() {
        
    }
 
    public void remove(int number) {
        this.tasks.remove(number - 1);
    }
}
 
    

