package com.f19.vulcansalute_768425_fp.src;

public class Manager extends Employee {
    private int nbClients;

    public Manager(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        nbClients = 0;
    }

    public Manager(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle, int numClients) {
        super(name, birthYear, age, mIncome, oRate, vehicle);
        this.nbClients = numClients;
    }

    public void setNumClients(int numClients) {
        this.nbClients = numClients;
    }

    public int getNumClients() {
        return nbClients;
    }
}
