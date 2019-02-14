/*
    JuanDiego Castano
    Ms. Krasteva
    02/13/19
    This program is the bluepring for a car, that takes into account brand, model,
	kilometers, gas in tank and tank capacity.
*/

import java.awt.*;
import hsa.Console;

public class Car
{
    private String brand; // can store the car brand
    private String model; // will store the model of the car
    private int kilometers; // will store the distance traveled
    private double gas; // will store how much gas the car currently has
    private double tankCapacity; // will store the total capacity of the cars tank
    // Initialize the cars starting values.
    public Car (String b, String m, double g, double tCap)
    {
	brand = b;
	model = m;
	kilometers = 0;
	gas = g;
	tankCapacity = tCap;
    }


    /*  As the distance the car has travleled increases, the cars gas decreases
     this method takes that into account and calculates the gas consumed based on the
     distance travlled.
    */
    public void drive (double distance)
    {
	kilometers += distance;
	gas -= distance / 5;

    }


    // When the car is gased up, the tank will be filled to full capacity
    public void gasUp ()
    {
	gas = tankCapacity;
    }



} //Car class
