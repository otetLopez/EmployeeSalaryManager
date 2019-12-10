package com.f19.vulcansalute_768425_fp.src;

import com.f19.vulcansalute_768425_fp.constants.Constants;

public class Programmer extends Employee {
    private int nbProjects;

    public Programmer(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle, int numProjects) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        this.nbProjects = numProjects;
    }

    public Programmer(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        this.nbProjects = 0;
    }

    /** For a programmer, a bonus of 200 dollars per completed project */
    @Override
    public double annualIncome() {
        return (this.getmIncome() * Constants.PAID_MONTHS_IN_A_YEAR * (this.getoRate() * Constants.PERCENTAGE)) +
                (nbProjects * Constants.GAIN_FACTOR_PROJECT);
    }

    public int getNumProjects() {
        return nbProjects;
    }

    public void setNumProjects(int numProjects) {
        this.nbProjects = numProjects;
    }
}
