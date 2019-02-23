/*
JuanDiego Castano
ms. Krasteva
02/13/19
This program answers question two, it is the blueprint for a car with diffrent variables,
    brand, model, kilometers, gas and tank capacity. This Car1 class is diffrent from the 
    other car class. 
*/

import java.awt.*;
import hsa.Console;

public class Car1
{
	/*
	    brand: String - this variable stores the brand name 
	    model: String - this variable stores the name of the model 
	    kilometers: int - this variable stores the distance in kilometers
	    gas: double - this variable will store the amount of gas in the tank
	    tankCapacity : double - This variable stores the tank capacity
	*/
    private String brand;
    private String model;
    private int kilometers;
    private double gas;
    private double tankCapacity;
   //initializes the car objects  
    public Car (String b, String m, double g, double tCap)  
    {
	brand = b;
	model = m;
	kilometers = 0;
	gas = g;
	tankCapacity = tCap;
    }

//This method takes into account the distence travled by the car 
    public void drive (double distance)
    {
	kilometers += distance;
	gas -= distance / 5;

    }


    public void gasUp ()
    {
	gas = tankCapacity;
    }


    public String getInfo ()
    {
	return brand + " " + model;
    }
} //Car class
