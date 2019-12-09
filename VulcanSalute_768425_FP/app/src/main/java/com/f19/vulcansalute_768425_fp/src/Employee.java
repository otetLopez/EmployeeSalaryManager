package com.f19.vulcansalute_768425_fp.src;

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

    public String getName() {
        return this.name;
    }
    public int getBirthYear() {
        return this.birthYear;
    }
    public int getAge() {
        return this.age;
    }
    public double getmIncome() {
        return this.mIncome;
    }
    public double getoRate() {
        return this.oRate;
    }
    public Vehicle getVehicle() {
        return this.vehicle;
    }

    public Employee(String name, int birthYear, int age, double mIncome, double oRate, Vehicle vehicle) {
        this.name = name;
        this.birthYear = birthYear;
        this.age = age;
        this.mIncome = mIncome;
        this.oRate = oRate;
        this.vehicle = vehicle;
    }
}
