/*
JuanDiego Castano
ms. Krasteva
02/13/19
This class initalizes car variables, it creates two car objects. 
*/
import java.awt.*;
import hsa.Console;

public class CreatingCarObjects
{
    public static void main (String[] args)
    {
	Car cOne = new Car ("Acura", "Crossover", 80, 160);
	cOne.drive (145);
	cOne.gasUp ();
	cOne.getInfo (); 
	Car cTwo = new Car ("Ford", "F-150", 100, 105);
	cTwo.drive (189);
	cTwo.gasUp ();
	cTwo.getInfo (); 
    }
}
