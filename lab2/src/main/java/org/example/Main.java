package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Factory fac = new Factory();
        int amount = 5;
        BasicAircraft[] test = fac.getTop(amount);
        for (int i = 0; i < amount; i++) {
            test[i].PrintAircraftInfo();
        }
    }
}
