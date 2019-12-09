package com.f19.vulcansalute_768425_fp.src;

public class Tester extends Employee {
    private int numBugs;

    public Tester(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        numBugs = 0;
    }

    public Tester(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle, int numBugs) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        this.numBugs = numBugs;
    }

    public int getNumBugs() {
        return numBugs;
    }

    public void setNumBugs(int numBugs) {
        this.numBugs = numBugs;
    }
}
