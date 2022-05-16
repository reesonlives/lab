package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Factory fac = new Factory();
        System.out.println(fac.getTop(4));
    }
}
