package com.f19.vulcansalute_768425_fp.src;

import androidx.annotation.NonNull;

public class Motorcycle extends Vehicle implements java.io.Serializable {
    private boolean isSideCar;

    public Motorcycle(String make, String plate, String color, boolean isSideCar) {
        super(make, plate, color);
        this.isSideCar = isSideCar;
    }

    @NonNull
    @Override
    public String toString() {
        return  "Employee has a motorcycle \n" +
                "\t\t - make: " + this.getMake() + "\n" +
                "\t\t - plate: " + this.getPlate() + "\n" +
                "\t\t - color: " + this.getColor() + "\n" +
                "\t\t - " + (isSideCar ? "with sidecar" : "without sidecar");
    }

    public boolean isSideCar() {
        return isSideCar;
    }

    public void setSideCar(boolean sideCar) {
        isSideCar = sideCar;
    }
}
