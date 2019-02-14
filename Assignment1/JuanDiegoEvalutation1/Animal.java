/*
 JuanDiego 
 Ms. Kresteva 
 02/13/2019 
 This program is the blueprint for an animal that inclues its name, weight, if its hungry and and if its tired. 
 */
import java.awt.*;
import hsa.Console;

public class Animal
{
    private String name; // stores the name of the animal 
    private double weight;//stores the weight of the animal 
    private boolean tired; // stores if the animal is tired 
    private boolean hungry;//stores if the animal is hngry 

// initalizes the variables 
    public Animal (String n, double w)
    {
	name = n;
	tired = true;
	hungry = true;
	weight = w;
    }

// if the animal needs feeding its weight will change 
    public void feed (String v)
    {
	hungry = false;
	if (v.equals ("vegetables"))
	    weight += 2;
	else if (v.equals ("meat"))
	    weight += 4;
	else
	    weight += 1;

    }

// when the animal sleeps it will lose weight 

    public void sleep ()
    {
	tired = false;   //if the animal sleeps it will not be tired
	weight -= 3;
    }
} //Car class
