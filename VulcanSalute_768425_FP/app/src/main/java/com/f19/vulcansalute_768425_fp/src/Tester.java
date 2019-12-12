package com.f19.vulcansalute_768425_fp.src;

import com.f19.vulcansalute_768425_fp.constants.Constants;

import androidx.annotation.NonNull;

public class Tester extends Employee implements java.io.Serializable{
    private int nbBugs;

    public Tester(String fname, String lname, int birthYear, double mIncome, double oRate, Vehicle vehicle, int nbBugs) {
        super(fname, lname, birthYear, mIncome, oRate, vehicle);
        this.nbBugs = nbBugs;
    }

    public Tester(String fname, String lname, int birthYear, double mIncome, double oRate, Vehicle vehicle, int eType, int nbBugs) {
        super(fname, lname, birthYear, mIncome, oRate, vehicle, eType);
        this.nbBugs = nbBugs;
    }

    /** For a tester, a bonus of 10 dollars per corrected bug is added (a constant can be used
     like GAIN_FACTOR_ERROR equals 10) */
    @Override
    public double annualIncome() {
        return (this.getmIncome() * Constants.PAID_MONTHS_IN_A_YEAR * (this.getoRate() * Constants.PERCENTAGE)) +
                (nbBugs * Constants.GAIN_FACTOR_ERROR);
    }

    @NonNull
    @Override
    public String toString() {
        return  "Name: " + this.getFname() + " " + this.getLname() + ", a Tester\n" +
                "Age: " + this.getAge() + "\n" +
                (getVehicle() != null ? (this.getVehicle().toString() + "\n") : "" ) +
                "Occupation Rate: " + this.getoRate() + "%\n" +
                "Annual Income: $ " + String.format("%.2f", this.annualIncome()) + "\n" +
                "He/She has corrected " + this.nbBugs + " bugs.";
    }

    public int getNumBugs() {
        return nbBugs;
    }

    public void setNumBugs(int numBugs) {
        this.nbBugs = numBugs;
    }


}
