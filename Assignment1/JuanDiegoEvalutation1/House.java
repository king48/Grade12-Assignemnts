/*
    JuanDiego Castano
    Ms. Krasteva
    02/13/19
    This program is the bluepring for a House, that takes into account where the house is
	the size of the house, whether it is detached or not and how many stores there are.
*/

import java.awt.*;
import hsa.Console;

public class House
{
    private int street_num; // This variable stores the street number
    private String street; // This varible will store the street name
    private String city; // This variable will store the name of the city
    private String provence; // This variable will store the name of the provence
    private String postal_code; // This variable will store the postal code of a cirtain object
    private double size; // This variable will store the size of the house
    private boolean detached; // This variable will store if it is detached or not
    private int stories; // This variable will store the number of stories of the house

    // This method will initialize the object for the house
    public House (int n, String s, String c, String pv, String p, double si, boolean d, int l)
    {
	street_num = n;
	street = s;
	city = c;
	provence = pv;
	postal_code = p;
	size = si;
	detached = d;
	stories = l;
    }

    // This method will display the Address
    public void displayAddress ()
    {
	System.out.println (street_num + " " + street);
	System.out.println (city + " " + provence);
	System.out.println (postal_code);
    }
} //House class
