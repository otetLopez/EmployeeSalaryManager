package com.f19.vulcansalute_768425_fp.src;

import androidx.annotation.NonNull;

public class Car extends Vehicle {
    private String type;

    public Car(String make, String plate, String color, String category, String type) {
        super(make, plate, color, category);
        this.type = type;
    }

    public Car(String make, String plate, String color, String category) {
        super(make, plate, color, category);
    }

    @NonNull
    @Override
    public String toString() {
        return  "\t\t\t - make: " + this.getMake() + "\n" +
                "\t\t\t - plate: " + this.getPlate() + "\n" +
                "\t\t\t - color: " + this.getColor() + "\n" +
                "\t\t\t - type: " + this.type + "\n";
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
