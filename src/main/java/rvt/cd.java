package rvt;

public class cd implements packable {
 
    private String artist;
    private String name;
    private int year;
    private double weight = 0.1;
 
    public cd(String artist, String name, int year) {
        this.artist = artist;
        this.name = name;
        this.year = year;
    }
 

    public double weight() {
        return 0.1;
    }
 
    public String toString() {
 
        String s = "";
        s = s + this.artist + ": ";
        s = s + this.name + " (";
        s = s + this.year + ")";
 
        return s;
 
    }
 
}
 