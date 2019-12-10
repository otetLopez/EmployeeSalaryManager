package com.f19.vulcansalute_768425_fp.src;

import android.util.Log;

public class Simulator {


    public Simulator() {
    }

    public void run() {

        Car v1 = new Car("Lamborghini", "Custom Plate", "White", "Sport");
        Car v2 = new Car("BMW", "Custome Plate", "Black", "Sedan");
        Motorcycle v3 = new Motorcycle("Kawasaki", "Custome Plate", "Yellow", false);
        Motorcycle v4 = new Motorcycle("Honda", "Custome Plate", "Black", true);


        // 104472.00 : (104472.00 - (30 * 500)) / 12
        Manager serge = new Manager("Serge", 1985, 7456.0, 100, v1, 30);
        // 89104.00 : (89104.00 - (20 * 500)) / 12 / .8
        Manager cindy = new Manager("Cindy", 1974, 8240, 80, v2, 20);
        // 58704.00 : (58704.00 - (3 * 200) / 12 / .75 )
        Programmer paul = new Programmer("Paul", 1993, 6456, 75, v3, 3);
        // 33976.00 : (33976.00 - (124 * 10)) / 12 / .50
        Tester pierre = new Tester("Pierre", 1987, 5456, 50, v4, 124);

        Log.i("simulate project", "Employees description:\n-------------------------\n" +
                serge.toString() + "\n-------------------------\n-------------------------\n" +
                cindy.toString() + "\n-------------------------\n-------------------------\n" +
                paul.toString() + "\n-------------------------\n-------------------------\n" +
                pierre.toString());
    }
}

/**  Expected Output
    Execution example:
        Employees description:
        -------------------------
        Name: Serge, a manager
        Age: 34
        Employee has a car
        - make: Lamborghini
        - plate: Custom Plate
        - color: White
        - type: Sport
        Occupation rate: 100%
        Annual income: $ 104472.00
        He/She has brought 30 new clients.
        -------------------------
        -------------------------
        Name: Cindy, a manager
        Age: 45
        Employee has a car
        - make: BMW
        - plate: Custom Plate
        - color: Black
        - type: Sedan
        Occupation rate: 80%
        Annual income: $ 89104.00
        He/She has brought 20 new clients.
        -------------------------
        -------------------------
        Name: Paul, a programmer
        Age: 26
        Employee has a motorcycle
        - make: Kawasaki
        - plate: Custom Plate
        - color: Yellow
        - without sidecar
        Occupation rate: 75%
        Annual income is 58704.00
        He/She has completed 3 projects.
        -------------------------
        -------------------------
        Name: Pierre, a tester
        Age: 31
        Employee has a motorcycle
        - make: Honda
        - plate: Custom Plate
        - color: Black
        - with sidecar
        Occupation rate: 50%
        annual income is 33976.00
        He/she has corrected 124 bugs.
 */