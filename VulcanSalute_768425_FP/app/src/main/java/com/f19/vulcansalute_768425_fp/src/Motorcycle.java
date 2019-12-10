package com.f19.vulcansalute_768425_fp.src;

import androidx.annotation.NonNull;

public class Motorcycle extends Vehicle {
    private boolean isSideCar;

    public Motorcycle(String make, String plate, String color, boolean isSideCar) {
        super(make, plate, color);
        this.isSideCar = isSideCar;
    }

    @NonNull
    @Override
    public String toString() {
        return  "Employee has a motorcycle \n" +
                "\t\t\t - make: " + this.getMake() + "\n" +
                "\t\t\t - plate: " + this.getPlate() + "\n" +
                "\t\t\t - color: " + this.getColor() + "\n" +
                "\t\t\t - " + (isSideCar ? "with sidecar" : "without sidecar") + "\n";
    }

    public boolean isSideCar() {
        return isSideCar;
    }

    public void setSideCar(boolean sideCar) {
        isSideCar = sideCar;
    }
}
