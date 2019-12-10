package com.f19.vulcansalute_768425_fp.src;

import com.f19.vulcansalute_768425_fp.constants.Constants;

public class Tester extends Employee {
    private int nbBugs;

    public Tester(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        nbBugs = 0;
    }

    public Tester(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle, int numBugs) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        this.nbBugs = numBugs;
    }

    /** For a tester, a bonus of 10 dollars per corrected bug is added (a constant can be used
     like GAIN_FACTOR_ERROR equals 10) */
    @Override
    public double annualIncome() {
        return (this.getmIncome() * Constants.PAID_MONTHS_IN_A_YEAR * (this.getoRate() * Constants.PERCENTAGE)) +
                (nbBugs * Constants.GAIN_FACTOR_ERROR);
    }

    public int getNumBugs() {
        return nbBugs;
    }

    public void setNumBugs(int numBugs) {
        this.nbBugs = numBugs;
    }


}
