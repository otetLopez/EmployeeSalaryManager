package com.f19.vulcansalute_768425_fp.src;

import com.f19.vulcansalute_768425_fp.constants.Constants;

/** An employee is characterized by his/her name (the field name must remain
 unchanged after its initialisation); his/her birth year; his/her age as a property which computes
 and returns his/her age regarding the current year and his/her year of birth; a monthly income
 and an occupation rate (the percentage of time worked monthly; for example, 80%) and an
 employee Id. The employee has also a vehicle */

public class Employee {
    private String name;
    private int birthYear;
    private int age;
    private double mIncome;
    private double oRate;
    private Vehicle vehicle;

    public Employee(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = age;
        this.mIncome = mIncome;
        this.oRate = validateRate(oRate);
        this.vehicle = vehicle;
    }

    /** Each employee has a base yearly income computed as 12 times the monthly
     income multiplied by the occupation rate. */
    public double annualIncome() {
        return this.mIncome * Constants.PAID_MONTHS_IN_A_YEAR * (this.oRate * Constants.PERCENTAGE);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getmIncome() {
        return mIncome;
    }

    public void setmIncome(double mIncome) {
        this.mIncome = mIncome;
    }

    public double getoRate() {
        return oRate;
    }

    public void setoRate(double oRate) {
        this.oRate = oRate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    private double validateRate(double oRate) {
        if(oRate > 100)
            return 100;
        else if (oRate < 10)
            return 10;
        else
            return oRate;
    }
}
