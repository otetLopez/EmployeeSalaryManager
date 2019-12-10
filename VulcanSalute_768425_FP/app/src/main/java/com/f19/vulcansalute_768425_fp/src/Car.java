package com.f19.vulcansalute_768425_fp.src;

import androidx.annotation.NonNull;

public class Car extends Vehicle {
    private String type;

    public Car(String make, String plate, String color, String type) {
        super(make, plate, color);
        this.type = type;
    }

    public Car(String make, String plate, String color) {
        super(make, plate, color);
    }

    public Car(String make, String plate, String color, String category, String type) {
        super(make, plate, color, category);
        this.type = type;
    }

    @NonNull
    @Override
    public String toString() {
        return  "Employee has a car\n" +
                "\t\t - make: " + this.getMake() + "\n" +
                "\t\t - plate: " + this.getPlate() + "\n" +
                "\t\t - color: " + this.getColor() + "\n" +
                "\t\t - type: " + this.type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
