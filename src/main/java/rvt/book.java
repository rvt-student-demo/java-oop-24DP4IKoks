package rvt;

public class book implements packable{
 
    private String author;
    private String name;
    private double weight;
 
    public book(String author, String name, double weight) {
        this.author = author;
        this.name = name;
        this.weight = weight;
    }
 
    @Override
    public double weight() {
        return this.weight;
    }
 
    public String toString() {
 
        String s = "";
        s = s + this.author + ": ";
        s = s + this.name;
 
        return s;
 
    }
 
}
 