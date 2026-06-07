package rvt;
import java.util.ArrayList;


public class box implements packable {
 
    private ArrayList<packable> box;
    private double capacity;
 
    public box(double capacity) {
        this.box = new ArrayList<>();
        this.capacity = capacity;
    }
 
    public void add(packable item) {
        if (item.weight() + weight() <= this.capacity) {
            box.add(item);
        }
    }
 
    public double weight() {
        double weight = 0;
        for (packable item : box) {
            weight += item.weight();
        }
        return weight;
    }
    
    public String toString() {
        return "box: " + this.box.size() + " items, total weight " + 
                weight() + " kg";
    }
}
 