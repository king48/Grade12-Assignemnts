/*
JuanDiego Castano
ms. Krasteva
02/13/19
*/
import java.awt.*;
import hsa.Console;

public class Person
{
    private String fname;
    private String lname;
    private String DOB;
    private double height;
    private double weight;

    public Person (String first, String last)
    {
	fname = first;
	lname = last;
    }


    public Person (String first, String last, String dob)
    {
	fname = first;
	lname = last;
	DOB = dob;
    }


    public Person (String first, String last, String dob, double h, double w)
    {
	fname = first;
	lname = last;
	DOB = dob;
	height = h;
	weight = w;
    }


    public void setName (String first, String last) 
    {
	fname = first;
	lname = last;
    }


    public double convertKgToLbs (double kg)
    {
	double lbs = kg * 2.20462;
	return lbs;
    }
}
