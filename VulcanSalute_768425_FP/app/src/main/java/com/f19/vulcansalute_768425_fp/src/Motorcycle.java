package com.f19.vulcansalute_768425_fp.src;

public class Motorcycle extends Vehicle {
    private boolean isSideCar;

    public Motorcycle(String make, String plate, String color, String category, boolean isSideCar) {
        super(make, plate, color, category);
        this.isSideCar = isSideCar;
    }

    public Motorcycle(String make, String plate, String color, String category) {
        super(make, plate, color, category);
    }

    public boolean isSideCar() {
        return isSideCar;
    }

    public void setSideCar(boolean sideCar) {
        isSideCar = sideCar;
    }
}
