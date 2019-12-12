package com.f19.vulcansalute_768425_fp.src;

public class Vehicle implements java.io.Serializable {
    private String make;
    private String plate;
    private String color;
    private String category;

    public Vehicle(String make, String plate, String color) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = "";
    }

    public Vehicle(String make, String plate, String color, String category) {
        this.make = make;
        this.plate = plate;
        this.color = color;
        this.category = category;
    }

    @Override
    public String toString() {
        return  "\t\t - make: " + this.getMake() + "\n" +
                "\t\t - plate: " + this.getPlate() + "\n" +
                "\t\t - color: " + this.getColor();
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
