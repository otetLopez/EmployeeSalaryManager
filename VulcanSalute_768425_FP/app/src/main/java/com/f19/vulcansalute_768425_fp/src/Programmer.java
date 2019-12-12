package com.f19.vulcansalute_768425_fp.src;

import com.f19.vulcansalute_768425_fp.constants.Constants;

import androidx.annotation.NonNull;

public class Programmer extends Employee {
    private int nbProjects;

    public Programmer(String fname, String lname, int birthYear, double mIncome, double oRate, Vehicle vehicle, int nbProjects) {
        super(fname, lname, birthYear, mIncome, oRate, vehicle);
        this.nbProjects = nbProjects;
    }

    /** For a programmer, a bonus of 200 dollars per completed project */
    @Override
    public double annualIncome() {
        return (this.getmIncome() * Constants.PAID_MONTHS_IN_A_YEAR * (this.getoRate() * Constants.PERCENTAGE)) +
                (nbProjects * Constants.GAIN_FACTOR_PROJECT);
    }

    @NonNull
    @Override
    public String toString() {
        return "Name: " + this.getFname() + " " + this.getLname() + ", a Programmer\n" +
                "Age: " + this.getAge() + "\n" +
                (getVehicle() != null ? (this.getVehicle().toString() + "\n") : "" ) +
                "Occupation Rate: " + this.getoRate() + "%\n" +
                "Annual Income: $ " + String.format("%.2f", this.annualIncome()) + "\n" +
                "He/She has completed " + this.nbProjects + " projects.";
    }

    public int getNumProjects() {
        return nbProjects;
    }

    public void setNumProjects(int numProjects) {
        this.nbProjects = numProjects;
    }
}
