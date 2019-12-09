package com.f19.vulcansalute_768425_fp.src;

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

    public int getNumProjects() {
        return nbProjects;
    }

    public void setNumProjects(int numProjects) {
        this.nbProjects = numProjects;
    }
}
