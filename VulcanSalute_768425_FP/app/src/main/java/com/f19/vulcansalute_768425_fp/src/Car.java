package com.f19.vulcansalute_768425_fp.src;

public class Car extends Vehicle {
    private String type;

    public Car(String make, String plate, String color, String category, String type) {
        super(make, plate, color, category);
        this.type = type;
    }

    public Car(String make, String plate, String color, String category) {
        super(make, plate, color, category);
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
