package com.f19.vulcansalute_768425_fp.src;

import com.f19.vulcansalute_768425_fp.constants.Constants;

public class Manager extends Employee implements  java.io.Serializable{
    private int nbClients;
    private int nbTravelDays;

    public Manager(String fname, String lname, String id, int birthYear, double mIncome, double oRate, Vehicle vehicle, int nbClients) {
        super(fname, lname, id, birthYear, mIncome, oRate, vehicle);
        this.nbClients = nbClients;
        this.nbTravelDays = 0;
    }

    public Manager(String fname, String lname, String id, int birthYear, double mIncome, double oRate, Vehicle vehicle, int nbClients, int nbTravelDays) {
        super(fname, lname, id, birthYear, mIncome, oRate, vehicle);
        this.nbClients = nbClients;
        this.nbTravelDays = nbTravelDays;
    }

    /** For a manager a bonus of 500 dollars per client brought to the company is added as well
     as 100 dollars per day for the expenditure of the travelled days. (you can define two
     constants like GAIN_FACTOR_CLIENT equals to 500 and GAIN_FACTOR_TRAVEL
     equals to 100) */
    @Override
    public double annualIncome() {
        return (this.getmIncome() * Constants.PAID_MONTHS_IN_A_YEAR * (this.getoRate() * Constants.PERCENTAGE)) +
                (this.nbClients * Constants.GAIN_FACTOR_CLIENT) + (this.nbTravelDays * Constants.GAIN_FACTOR_TRAVEL);
    }

    @Override
    public String toString() {
        return  "Name: " + this.getFname() + " " + this.getLname() + ", a Manager\n" +
                "Id number: " + this.getId() + "\n" +
                "Age: " + this.getAge() + "\n" +
                (getVehicle() != null ? (this.getVehicle().toString() + "\n") : "" ) +
                "Occupation Rate: " + this.getoRate() + "%\n" +
                "Annual Income: $ " + String.format("%.2f", this.annualIncome()) + "\n" +
                "He/She has brought " + this.nbClients + " new clients.";
    }


}
