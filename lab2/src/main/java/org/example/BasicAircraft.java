package org.example;

import java.util.Date;

public class BasicAircraft {
    private String icao;
    private String operator;
    private Date posTime;
    private Coordinate coordinate;
    private Double speed;
    private Double trak;
    private Integer altitude;

    public BasicAircraft(String s1, String s2, Date d, Coordinate coord, Double sp, Double tr) {
        icao = s1;
        operator = s2;
        posTime = d;
        coordinate = coord;
        speed = sp;
        trak = tr;
    }

    public void PrintAircraftInfo() {
        System.out.print("BasicAircraft [icao=" + icao + ", operator=" + operator + " , posTime=" + posTime + " ,48,33 / 9,2048,33 / 9,20, speed=" + speed + ",trak =" + trak +"]\n");
    }
}
